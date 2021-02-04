package nz.co.spark.openshift.utility.reg.service;

import nz.co.spark.openshift.utility.reg.beans.RestOcpClient;
import nz.co.spark.openshift.utility.reg.cache.LocalCache;
import nz.co.spark.openshift.utility.reg.exceptions.OcpException;
import nz.co.spark.openshift.utility.reg.model.EnvTypeEnum;
import nz.co.spark.openshift.utility.reg.ocp.db.model.ImageStreamTagListEntity;
import nz.co.spark.openshift.utility.reg.ocp.db.service.ImageStreamTagListService;
import nz.co.spark.openshift.utility.reg.provider.ocp.json.registry.ImageStreamTags;
import nz.co.spark.openshift.utility.reg.ocp.db.service.FuseImageService;
import nz.co.spark.openshift.utility.reg.provider.ocp.json.dclist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class RestOCPTransformationService {

    @Autowired
    RestOcpClient client;

    @Autowired
    LocalCache cache;

    @Autowired
    FuseImageService fuseImageService;

    @Autowired
    ImageStreamTagListService imageStreamTagListService;

    @Value("${fuse.image.version.count:1}")
    private Integer count;

    @Value("#{'${ocp.npe.namespace.list.of.strings}'.split(',')}")
    private List<String> npeNameSpaceList;

    @Value("#{'${ocp.prod.namespace.list.of.strings}'.split(',')}")
    private List<String> prodNameSpaceList;

    @Value("#{'${ocp.reg.namespace.list.of.strings}'.split(',')}")
    private List<String> regNameSpaceList;

    @Value("${fuse.image.retain.time.in.days:180}")
    private String timeInDays;


    @Value("${fuse.print.commands:true}")
    private boolean printCommands;

    @Value("${fuse.delete.tags:true}")
    private boolean deleteTags;



    public void getReleases(){
//            cache.setUsername(username);
//            cache.setPassword(password);
        try {
            if (!CollectionUtils.isEmpty(npeNameSpaceList)) {
                for(String nameSpace : npeNameSpaceList){
                    if (!StringUtils.isEmpty(nameSpace)) {
                        Map<String,String> responseMap = getCotainerReleaseMap(nameSpace,EnvTypeEnum.NPE);
                    }

                }
            }

            if (!CollectionUtils.isEmpty(prodNameSpaceList)) {
                for(String nameSpace : prodNameSpaceList){
                    if (!StringUtils.isEmpty(nameSpace)) {
                        Map<String,String> responseMap = getCotainerReleaseMap(nameSpace,EnvTypeEnum.PROD);
                    }

                }
            }

            getAllRegistry();
            removeUnwantedFuseVersions();
            printOrDelete(printCommands,deleteTags);




        } catch (OcpException e) {
            e.printStackTrace();
        }

    }

    private void printOrDelete(boolean isPrint, boolean isDelete) throws OcpException {
        List<ImageStreamTagListEntity> imageStreamListEntity = imageStreamTagListService.getImageStreamListToBeDeleted(timeInDays);
        if(isPrint){
            for(ImageStreamTagListEntity entity : imageStreamListEntity){
                System.out.println("echo \"Creation Time : "+ entity.getCreationTimeStamp() + " , Tag Name : "+entity.getName() + " \"; oc tag -d " + entity.getName());
            }
        }
        if(isDelete){
            cache.setNamespace("intg",EnvTypeEnum.REG);
            client.deleteImageStreamstags(imageStreamListEntity,EnvTypeEnum.REG);
            for(ImageStreamTagListEntity entity : imageStreamListEntity){
                imageStreamTagListService.delete(entity);
            }
        }
    }

    private void removeUnwantedFuseVersions() {
        fuseImageService.removeUnwantedVersions(count);
    }

    private void getAllRegistry() throws OcpException {
        for(String namespace : regNameSpaceList) {
            if (!StringUtils.isEmpty(namespace)) {
                cache.setNamespace(namespace,EnvTypeEnum.REG);
                ImageStreamTags imageStreamTags = client.getDockerRegistry(EnvTypeEnum.REG);

                imageStreamTagListService.persistInDb(imageStreamTags);
            }
        }

    }

    private Map<String, String> getCotainerReleaseMap(String namespace,EnvTypeEnum type) throws OcpException {
        cache.setNamespace(namespace,type);

        ResponseEntity<DcSuccessResponse> reResponse = client.getDCList(type);
        DcSuccessResponse response = reResponse.getBody();
        Map<String,String> containerReleaseMap = getContainerReleaseMapFromDC(response);
//        containerReleaseMap.forEach((key, value) -> {
//            System.out.println(key + " : " +value);
//        });

        fuseImageService.persistInDb(containerReleaseMap,namespace+":"+type);
        return containerReleaseMap;
    }

    private Map<String, String> getContainerReleaseMapFromDC(DcSuccessResponse response) {
        Map<String,String> responseMap = new HashMap<>();
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
                                        String containerImage = container.getImage().replace("docker-registry-default.reg.ocp.internal.spark.co.nz/intg/","");
                                        responseMap.put(container.getName(),containerImage);
                                    }
                                }

                            }
                        }
                    }

                }
            }
        }
        return responseMap;
    }
}
