package nz.co.spark.openshift.utility.reg.ocp.db.service;

import nz.co.spark.openshift.utility.reg.ocp.db.dao.FuseImageBackupEntityDao;
import nz.co.spark.openshift.utility.reg.ocp.db.dao.FuseImageEntityDao;
import nz.co.spark.openshift.utility.reg.ocp.db.model.FuseImageBackupEntity;
import nz.co.spark.openshift.utility.reg.ocp.db.model.FuseImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
public class FuseImageService {

    @Autowired
    FuseImageEntityDao fuseImageEntityDao;

    @Autowired
    FuseImageBackupEntityDao fuseImageBackupEntityDao;

    Map<String,List<String>> fuseImageMap ;
    Map<String,List<FuseImageEntity>> backUpEntityMap;

    public void persistInDb(Map<String, String> stg, String namespace) {

         long recordCount = fuseImageEntityDao.count();
//         long bkpRecordCount = fuseImageBackupEntityDao.count();

         if(CollectionUtils.isEmpty(fuseImageMap)) {
             fuseImageMap = getFuseImageMap();
         }
        for(Map.Entry<String, String> entry : stg.entrySet()){
            boolean isPersistRequired = true;
            if(entry != null){
                if(!CollectionUtils.isEmpty(fuseImageMap)){
                    List<String> env = fuseImageMap.get(entry.getValue());
                    if(env != null && env.contains(namespace)){
                        isPersistRequired = false;
                    }
                }
                if (isPersistRequired) {
                    FuseImageEntity entity = new FuseImageEntity();
                    ++recordCount;
                    entity.setId(recordCount);
                    entity.setCreted((new Date()).toString());
                    entity.setImage(entry.getValue());
                    entity.setModule(entry.getKey());
                    entity.setEnviornment(namespace);
                    entity.setVersion(1);
//                    FuseImageEntity backUpEntity = backUpEntityMap.get(entity.getModule()+":"+entity.getEnviornment());
//                    if(backUpEntity != null){
//                        ++bkpRecordCount;
//                        FuseImageBackupEntity newBackUpEntity = new FuseImageBackupEntity();
//                        newBackUpEntity.setCreted(backUpEntity.getCreted());
//                        newBackUpEntity.setEnviornment(backUpEntity.getEnviornment());
//                        newBackUpEntity.setId(bkpRecordCount);
//                        newBackUpEntity.setImage(backUpEntity.getImage());
//                        newBackUpEntity.setModule(backUpEntity.getModule());
//                        fuseImageBackupEntityDao.save(newBackUpEntity);
//                        fuseImageEntityDao.delete(backUpEntity);
//                    }
                    saveFuseImageEntiry(entity);
                }
            }

        }


    }

    private void saveFuseImageEntiry(FuseImageEntity entity) {
        List<FuseImageEntity> imageEntityList = backUpEntityMap.get(entity.getModule()+":"+entity.getEnviornment());
        if(!CollectionUtils.isEmpty(imageEntityList)){
            for(FuseImageEntity existingEntity : imageEntityList){
                long currVersion = existingEntity.getVersion();
                currVersion++;
                existingEntity.setVersion(currVersion);
                fuseImageEntityDao.save(existingEntity);
            }
        }
        fuseImageEntityDao.save(entity);

    }

    private Map<String, List<String>> getFuseImageMap() {

        Map<String, List<String>> imageMap = new LinkedHashMap<>();
        backUpEntityMap = new LinkedHashMap<>();
        Iterable<FuseImageEntity> fuseImageEntity = fuseImageEntityDao.findAll();

        for(FuseImageEntity entity :fuseImageEntity){
                List<String> envList = imageMap.get(entity.getImage());
                if(CollectionUtils.isEmpty( envList)){
                 envList = new ArrayList<>();
                }
                envList.add(entity.getEnviornment());
                imageMap.put(entity.getImage(),envList);
                List<FuseImageEntity> imageEntityList = backUpEntityMap.get(entity.getModule()+":"+entity.getEnviornment());
                if(CollectionUtils.isEmpty(imageEntityList)){
                    imageEntityList = new ArrayList<>();
                }
                imageEntityList.add(entity);
                backUpEntityMap.put(entity.getModule()+":"+entity.getEnviornment(),imageEntityList);
//            System.out.println("ImageMap " +entity.getImage() +":" +entity.getEnviornment());
        }
        return  imageMap;
    }

    public void removeUnwantedVersions(Integer count) {
        int maxVersion = count.intValue();
        maxVersion++;
        Iterable<FuseImageEntity> entityList  = fuseImageEntityDao.findAll();
        if(entityList != null){
            for(FuseImageEntity imageEntity : entityList){
                if(imageEntity.getVersion() >maxVersion){
                    fuseImageEntityDao.delete(imageEntity);
                }
            }

        }
    }
}
