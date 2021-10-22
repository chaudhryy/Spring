package nz.co.spark.openshift.utility.fuse.service;

import nz.co.spark.openshift.utility.fuse.beans.LoggingRequestInterceptor;
import nz.co.spark.openshift.utility.fuse.beans.RestOcpClient;
import nz.co.spark.openshift.utility.fuse.cache.LocalCache;
import nz.co.spark.openshift.utility.fuse.exceptions.OcpException;
import nz.co.spark.openshift.utility.fuse.model.EnvTypeEnum;
import nz.co.spark.openshift.utility.fuse.provider.ocp.json.dclist.*;
import nz.co.spark.openshift.utility.fuse.provider.ocp.json.dclist.Container;
import nz.co.spark.openshift.utility.fuse.provider.ocp.json.secretlist.SecretScuccesResponse;
import nz.co.spark.openshift.utility.fuse.provider.ocp.json.configmap.ConfigSuccessResponse;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

@Component
public class OpenShiftBusinessService {
    final static Logger log = LoggerFactory.getLogger(LoggingRequestInterceptor.class);
    @Autowired
    RestOcpClient client;

    @Autowired
    LocalCache cache;


    @Value("${ocp.namespace}")
    private String inputNameSpace;

    @Value("${ocp.pod-name}")
    private String podName;

    @Value("${properties.output-path:src/main/resources/}")
    private File outPutPath;

    private Map<String, String> getEnviornmentVariables(String namespace, EnvTypeEnum type, String podName) throws OcpException {
        cache.setNamespace(namespace,type);

        ResponseEntity<DcSuccessResponse> reResponse = client.getDCList(type);
        DcSuccessResponse response = reResponse.getBody();
        Map<String,String> envVariables = getEnvVariables(response,podName);

        return envVariables ;
    }


    private Map<String, String> getEnvVariables(DcSuccessResponse response, String podName) {
        Map<String,String> envVariables = new HashMap<>();
        Map<String, Map<String, String>> secretsMap = cache.getSecretMap();
        if(response != null){
            List<Item> itemList = response.getItems();
            if(!CollectionUtils.isEmpty(itemList)){
                for(Item item : itemList){
                    Spec spec = item.getSpec();
                    if(spec != null){
                        Template template = spec.getTemplate();
                        if(template != null){
                            Spec_ spec_ = template.getSpec();
                            if(spec_ != null){
                                List<Container> containerList = spec_.getContainers();
                                if(!CollectionUtils.isEmpty(containerList)){
                                    for(Container container : containerList){
                                        if (!StringUtils.isEmpty(container.getName()) && container.getName().equalsIgnoreCase(podName)) {
                                            List<Env> envList = container.getEnv();
                                            if(!CollectionUtils.isEmpty(envList)){
                                                    for( Env env : envList){
                                                         if(env != null &&
                                                                 env.getValueFrom() != null &&
                                                                 env.getValueFrom().getSecretKeyRef() != null){
                                                                    Map<String, String> keyValuePair=secretsMap.get(env.getValueFrom().getSecretKeyRef().getName());
                                                                    if(!CollectionUtils.isEmpty(keyValuePair)){
                                                                        String value = keyValuePair.get(env.getValueFrom().getSecretKeyRef().getKey());
                                                                        envVariables.put(env.getName(),value);
                                                                    }
                                                         }
                                                    }

                                            }
                                        }


                                    }
                                }

                            }
                        }
                    }

                }
            }
        }
        return envVariables;
    }

    public void getEnvVariables()  {

        try {
            cacheSecrets();
//            resolvePodParams();
        } catch (OcpException e ) {
            e.printStackTrace();
        }
    }

    public void resolvePodParams()  {
        try {
            Map<String,String> responseMap = getEnviornmentVariables(inputNameSpace,EnvTypeEnum.NPE,podName);
            StringJoiner sj = new StringJoiner(";");
            for(Map.Entry<String, String> entry : responseMap.entrySet()){
                if (!(entry.getKey().contains("APPDYNAMICS")||entry.getKey().contains("PUBSUB"))) {
                    sj.add(entry.getKey()+"="+entry.getValue());
                }

            }
            prepareParentDirs();
            File file = new File(outPutPath.getPath()+"/"+podName+"/enviornment-"+(inputNameSpace
                    .replace("intg","")
                    .replace("-",""))+".csv");
            writeTextToFile(sj.toString(),file);
        } catch (OcpException | IOException e) {
            e.printStackTrace();
        }

    }

    private void cacheSecrets() throws OcpException {
        Map<String,Map<String,String>> secretsMap = getSecrets(inputNameSpace,EnvTypeEnum.NPE);
        cache.setSecretMap(secretsMap);

    }

    private Map<String, Map<String, String>> getSecrets(String namespace, EnvTypeEnum type) throws OcpException {
        cache.setNamespace(namespace,type);

        ResponseEntity<SecretScuccesResponse> reResponse = client.getSecretList(type);
        SecretScuccesResponse response = reResponse.getBody();
        Map<String, Map<String, String>>  getAllSecrets = getAllSecretMap(response);

        return getAllSecrets;
    }

    private Map<String, Map<String, String>> getAllSecretMap(SecretScuccesResponse response) {
        Map<String, Map<String, String>> secretsKeyValueMap = new HashMap<>();

        if(response != null && !CollectionUtils.isEmpty(response.getItems())){
            List<nz.co.spark.openshift.utility.fuse.provider.ocp.json.secretlist.Item> itemSecretList = response.getItems();
            for(nz.co.spark.openshift.utility.fuse.provider.ocp.json.secretlist.Item item : itemSecretList){
                if (item != null && item.getData() != null
                        && !CollectionUtils.isEmpty(item.getData().getAdditionalProperties())) {
                    Map<String, Object> secretPropertiesMapTmp = item.getData().getAdditionalProperties();
                    Map<String,String> secretPropertiesMap = getDecodedValues(secretPropertiesMapTmp);
                    if (!CollectionUtils.isEmpty(secretPropertiesMap)) {
                        secretsKeyValueMap.put(item.getMetadata().getName(),secretPropertiesMap);
                    }
                }
            }
        }
        return secretsKeyValueMap;
    }

    private Map<String, String> getDecodedValues(Map<String, Object> secretPropertiesMapTmp) {
        Map<String,String> keyValue = new HashMap<>();
        if (!CollectionUtils.isEmpty(secretPropertiesMapTmp)) {
            for (Map.Entry<String, Object> entry : secretPropertiesMapTmp.entrySet()) {
                try {
                    byte[] decodedBytes = Base64.getDecoder().decode(entry.getValue()+"");
                    if (decodedBytes != null) {
                        keyValue.put(entry.getKey(),new String(decodedBytes));
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        return keyValue;
    }

    public void getPropertiesFile() throws IOException {
        BufferedWriter output = null;
        try {
            cache.setNamespace(inputNameSpace,EnvTypeEnum.NPE);
            ResponseEntity<ConfigSuccessResponse> reResponse = client.getConfigMap(EnvTypeEnum.NPE,podName);
            ConfigSuccessResponse response = reResponse.getBody();
            prepareParentDirs();

            File file = new File(outPutPath.getPath()+"/"+podName+"/application-"+(inputNameSpace
                                                                                        .replace("intg","")
                                                                                        .replace("-",""))+".properties");
            writeTextToFile(response.getData().getApplicationProperties(),file);

        } catch (OcpException e) {
            e.printStackTrace();
        }

    }

    private void writeTextToFile(String input,File file) throws IOException {
        log.info("=========================== Write Begin ================================================");

        log.debug("Output file : {}", file.getPath());
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(file));
            output.write(input);
            output.flush();
        }catch ( IOException e) {
            e.printStackTrace();
        }finally {
            if(output != null) output.close();
         }
        log.info("=========================== Write End   ================================================");

    }
    private void prepareParentDirs() {
        if(!(outPutPath.exists())){
            outPutPath.mkdirs();
        }
        File podDir = new File(outPutPath.getPath()+"/"+podName);
        if(!podDir.exists()){
            podDir.mkdir();
        }
    }
}
