package nz.co.spark.intg.ocp.utility.ocp.db.service;

import nz.co.spark.intg.ocp.utility.beans.RestOcpClient;
import nz.co.spark.intg.ocp.utility.cache.LocalCache;
import nz.co.spark.intg.ocp.utility.cache.PodCache;
import nz.co.spark.intg.ocp.utility.model.Pod;
import nz.co.spark.intg.ocp.utility.ocp.db.dao.ModuleRouteInfoDao;
import nz.co.spark.intg.ocp.utility.ocp.db.model.ModuleRouteInfo;
import nz.co.spark.intg.ocp.utility.ocp.utils.OcpUtil;
import nz.co.spark.intg.ocp.utility.provider.ocp.json.routelist.Item;
import nz.co.spark.intg.ocp.utility.provider.ocp.json.routelist.RouteListSuccessResponse;
import io.swagger.models.Path;
import io.swagger.models.Swagger;
import io.swagger.parser.Swagger20Parser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ModuleRouteInfoService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired(required = false)
    ModuleRouteInfoDao dao;

    @Autowired
    LocalCache cache;

    @Autowired
    PodCache podCache;


    @Autowired
    RestOcpClient client;


    public void createInfo(RouteListSuccessResponse routeListSuccessResponse) {
        int count = new Long(dao.count()).intValue();
        if(routeListSuccessResponse != null && !CollectionUtils.isEmpty(routeListSuccessResponse.getItems())){
            for(Item item : routeListSuccessResponse.getItems()){

                if(item != null && item.getMetadata() != null && item.getMetadata().getName() != null ){
                    if(item.getMetadata().getName().contains("rest")){
                      count++;
                        ModuleRouteInfo routeInfo = new ModuleRouteInfo();
                        routeInfo.setId(count);
                        routeInfo.setVersion(cache.getLastVersion());
                        routeInfo.setModule_Name(item.getMetadata().getLabels().getApp());
                        if (item.getMetadata().getAnnotations() != null && item.getMetadata().getAnnotations().getHaproxyRouterOpenshiftIoTimeout() != null) {
                            routeInfo.setHaProxyTimeout(item.getMetadata().getAnnotations().getHaproxyRouterOpenshiftIoTimeout());
                        }
                        routeInfo.setPort(item.getSpec().getPort().getTargetPort());
                        routeInfo.setHost(item.getSpec().getHost());
                        routeInfo.setType("REST");
//                        routeInfo.setUrl();

                        getAndSetDetailsFromSwagger(item.getSpec().getHost(),routeInfo);

                        dao.save(routeInfo);

                    }else if(!item.getMetadata().getName().startsWith("amq")){
                        count++;
                        ModuleRouteInfo routeInfo = new ModuleRouteInfo();
                        routeInfo.setId(count);
                        routeInfo.setVersion(cache.getLastVersion());
                        routeInfo.setModule_Name(item.getMetadata().getLabels().getApp());
                        if (item.getMetadata().getAnnotations() != null && item.getMetadata().getAnnotations().getHaproxyRouterOpenshiftIoTimeout() != null) {
                            routeInfo.setHaProxyTimeout(item.getMetadata().getAnnotations().getHaproxyRouterOpenshiftIoTimeout());
                        }
                        routeInfo.setPort(item.getSpec().getPort().getTargetPort());
                        routeInfo.setHost(item.getSpec().getHost());
                        routeInfo.setType("SOAP");
                        getAndSetDetailsFromCXFServiceList(item.getSpec().getHost(),routeInfo);

                        dao.save(routeInfo);
                        System.out.println("Successfully processed route dump for " + routeInfo.getHost() + " ,Version " + cache.getLastVersion());
                    }
                }
            }
        }

    }

    private void getAndSetDetailsFromCXFServiceList(String host, ModuleRouteInfo routeInfo) {
        try {
            String responseResponseEntity = client.getCxfServiceList(host);

            if (responseResponseEntity != null && !responseResponseEntity.contains("Fetch-Exception")) {
                List<String> keyList = new LinkedList<>();
                List<String> valueList = new LinkedList<>();

                {
                    Pattern pattern = Pattern.compile("porttypename\">[A-Za-z0-9]*");
                    Matcher matcher = pattern.matcher(responseResponseEntity);
                    while (matcher.find()) {
                        int count = 0;
                        keyList.add(matcher.group(0).replace("porttypename\">",""));

                    }
                }

                {
                    Pattern pattern = Pattern.compile("http:\\/\\/[^\\s]*?.wsdl");
                    Matcher matcher = pattern.matcher(responseResponseEntity);
                   while (matcher.find()) {

                        int count = matcher.groupCount();


                            valueList.add(matcher.group(0));

                    }
                }

                if(!CollectionUtils.isEmpty(keyList)){
                    StringJoiner joiner = new StringJoiner(",");
                    int i = 0;
                    for(String key : keyList){
                        if(i<valueList.size()) {
                            joiner.add(key + "=" + valueList.get(i));
                        }else{
                            joiner.add(key+"=");
                        }
                        i++;
                    }
                    routeInfo.setUrl(joiner.toString());

                }
            }else{
                routeInfo.setUrl(responseResponseEntity);
            }


        } catch (Exception e) {
            System.out.println("Exception " + e.getLocalizedMessage());
        }
    }

    private void getAndSetDetailsFromSwagger(String host, ModuleRouteInfo routeInfo) {
        try {
            String responseResponseEntity = client.getRestSwagger(host);

            if (responseResponseEntity != null && !responseResponseEntity.contains("Fetch-Exception")) {
                Swagger swagger = new Swagger20Parser().parse(responseResponseEntity);
                StringJoiner joiner = new StringJoiner(",");
                if(swagger != null && !CollectionUtils.isEmpty(swagger.getPaths())){
                    for(Map.Entry<String, Path> entry : swagger.getPaths().entrySet()){
                        if(entry.getValue().getGet() != null){
                                joiner.add(entry.getValue().getGet().getOperationId() + "=GET:"+ entry.getKey());
                        }else if(entry.getValue().getPost() != null){
                            joiner.add(entry.getValue().getPost().getOperationId() + "=POST:"+ entry.getKey());
                        }else if(entry.getValue().getPut() != null){
                            joiner.add(entry.getValue().getPut().getOperationId() + "=PUT:"+ entry.getKey());

                        }else if(entry.getValue().getDelete() != null){
                            joiner.add(entry.getValue().getDelete().getOperationId() + "=DELETE:"+ entry.getKey());

                        }

                    }
                    routeInfo.setUrl(joiner.toString());
                }
            }else{
                routeInfo.setUrl(responseResponseEntity);
            }

//            swagger
//            if(response != null && CollectionUtils.isEmpty(response.getPaths())){
//
//            }
        } catch (Exception e) {
            System.out.println("Exception " + e.getLocalizedMessage());
        }
    }

    public void compareLastTwoVersions(int from, int to) {
        Map<String, ModuleRouteInfo> recentVersion = new HashMap<>();
        Map<String,ModuleRouteInfo> prevVersion = new HashMap<>();

        {
            Iterable<ModuleRouteInfo> podList = dao.findAll();

            if (podList != null) {
                for (ModuleRouteInfo pod : podList) {
                    if (pod.getVersion() == from) {
                        recentVersion.put(pod.getModule_Name(), pod);
                    } else if (pod.getVersion() == to) {
                        prevVersion.put(pod.getModule_Name(), pod);
                    }
                }
            }
        }

        compare(recentVersion,prevVersion);

    }

    private void compare(Map<String, ModuleRouteInfo> recentVersion, Map<String, ModuleRouteInfo> prevVersion) {

        for(Map.Entry<String, ModuleRouteInfo> entry: recentVersion.entrySet()){

            ModuleRouteInfo stat = prevVersion.get(entry.getKey());
            compareEndpoint(entry.getValue(),stat);

        }

    }

    private void compareEndpoint(ModuleRouteInfo nVersion, ModuleRouteInfo pVersion) {
        if(nVersion.getType().equals("REST")){
            compareRestVersions(nVersion,pVersion);
        }else{
            compareSoapVersion(nVersion,pVersion);
        }
    }

    private void compareSoapVersion(ModuleRouteInfo nVersion, ModuleRouteInfo pVersion) {

        if(pVersion == null){
            if (nVersion.getUrl() == null || nVersion.getUrl().contains("Fetch-Exception ")) {
                Pod pod =podCache.getPod(nVersion.getModule_Name());
                podCache.getSoapEndpoint().add(nVersion.getHost() + ", " + nVersion.getUrl());
            }else{
                Pod pod =podCache.getPod(nVersion.getModule_Name());
                Map<String, String> keyValueMap = OcpUtil.getEnvList(nVersion.getUrl());
                for(Map.Entry<String, String> entry : keyValueMap.entrySet()) {
                    pod.getSoapListAdded().put(entry.getKey(),entry.getValue());
                }
                pod.setSoapHost(nVersion.getHost());
            }
        }else{
            if (nVersion.getUrl() == null || nVersion.getUrl().contains("Fetch-Exception ")) {
                Pod pod =podCache.getPod(nVersion.getModule_Name());
                podCache.getSoapEndpoint().add(nVersion.getHost() + ", " + nVersion.getUrl());
            }else{
                Pod pod =podCache.getPod(nVersion.getModule_Name());
                Map<String, String> nKeyValueMap = OcpUtil.getEnvList(nVersion.getUrl());
                pod.setSoapHost(nVersion.getHost());
                Map<String, String> oKeyValueMap = OcpUtil.getEnvList(pVersion.getUrl());

                for(Map.Entry<String, String> entry : nKeyValueMap.entrySet()){

                    String oValue = oKeyValueMap.get(entry.getKey());
                    if(oValue == null){
                        pod.getSoapListAdded().put(entry.getKey(),entry.getValue());
                    }else if(!oValue.equals(entry.getValue())){
                        pod.getSoapListDiff().put(entry.getKey(),entry.getValue());
                    }

                }

                for(Map.Entry<String, String> entry : oKeyValueMap.entrySet()){

                    String nValue = nKeyValueMap.get(entry.getKey());
                    if(nValue == null){
                        pod.getSoapListDeleted().put(entry.getKey(),entry.getValue());
                    }

                }

            }
        }
    }

    private void compareRestVersions(ModuleRouteInfo nVersion, ModuleRouteInfo pVersion) {
        {

            if(pVersion == null){
                if (nVersion.getUrl() == null || nVersion.getUrl().contains("Fetch-Exception ")) {
                    Pod pod =podCache.getPod(nVersion.getModule_Name());
                    podCache.getRestEndpoint().add(nVersion.getHost() + ", " + nVersion.getUrl());
                    pod.setRestAdded(true);
                }else{
                    Pod pod =podCache.getPod(nVersion.getModule_Name());
                    Map<String, String> keyValueMap = OcpUtil.getEnvList(nVersion.getUrl());
                    for(Map.Entry<String, String> entry : keyValueMap.entrySet()) {
                        pod.getRestListAdded().put(entry.getKey(),entry.getValue());
                    }
                    pod.setRestHost(nVersion.getHost());
                    pod.setRestAdded(true);
                }
            }else{
                if (nVersion.getUrl() == null || nVersion.getUrl().contains("Fetch-Exception ")) {
                    Pod pod =podCache.getPod(nVersion.getModule_Name());
                    podCache.getRestEndpoint().add(nVersion.getHost() + ", " + nVersion.getUrl());
                }else{
                    Pod pod =podCache.getPod(nVersion.getModule_Name());
                    Map<String, String> nKeyValueMap = OcpUtil.getEnvList(nVersion.getUrl());
                    pod.setRestHost(nVersion.getHost());
                    Map<String, String> oKeyValueMap = OcpUtil.getEnvList(pVersion.getUrl());

                    for(Map.Entry<String, String> entry : nKeyValueMap.entrySet()){

                        String oValue = oKeyValueMap.get(entry.getKey());
                        if(oValue == null){
                            pod.getRestListAdded().put(entry.getKey(),entry.getValue());
                        }else if(!oValue.equals(entry.getValue())){
                            pod.getRestListDiff().put(entry.getKey(),entry.getValue());
                        }

                    }

                    for(Map.Entry<String, String> entry : oKeyValueMap.entrySet()){

                        String nValue = nKeyValueMap.get(entry.getKey());
                        if(nValue == null){
                            pod.getRestListDeleted().put(entry.getKey(),entry.getValue());
                        }

                    }

                }
            }
        }
    }
}
