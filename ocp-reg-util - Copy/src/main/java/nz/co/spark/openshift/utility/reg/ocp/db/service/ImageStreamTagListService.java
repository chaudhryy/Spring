package nz.co.spark.openshift.utility.reg.ocp.db.service;

import nz.co.spark.openshift.utility.reg.ocp.db.dao.FuseImageBackupEntityDao;
import nz.co.spark.openshift.utility.reg.ocp.db.dao.FuseImageEntityDao;
import nz.co.spark.openshift.utility.reg.ocp.db.dao.ImageStreamTagListEntityDao;
import nz.co.spark.openshift.utility.reg.ocp.db.model.FuseImageBackupEntity;
import nz.co.spark.openshift.utility.reg.ocp.db.model.FuseImageEntity;
import nz.co.spark.openshift.utility.reg.ocp.db.model.ImageStreamTagListEntity;
import nz.co.spark.openshift.utility.reg.provider.ocp.json.registry.Image;
import nz.co.spark.openshift.utility.reg.provider.ocp.json.registry.ImageStreamTags;
import nz.co.spark.openshift.utility.reg.provider.ocp.json.registry.Item;
import nz.co.spark.openshift.utility.reg.provider.ocp.json.registry.Metadata_;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class ImageStreamTagListService {

    @Autowired
    ImageStreamTagListEntityDao dao;

    @Autowired
    FuseImageBackupEntityDao backUpEntityDao;

    @Autowired
    FuseImageEntityDao fuseImageEntityDao;

    List<String> imageEntityList ;

    @Value("#{'${ocp.reg.image.skip.list.of.strings}'.split(',')}")
    private List<String> regSkipList;



    public void persistInDb(ImageStreamTags imageStreamTags) {
        long count = dao.count();

        if(CollectionUtils.isEmpty(imageEntityList)){
            imageEntityList = getImageEntityList();
        }


        if(imageStreamTags != null){
            List<Item> itemList = imageStreamTags.getItems();
            if(!CollectionUtils.isEmpty(itemList)){
                for(Item item : itemList){
                    if(item != null && item.getMetadata() != null) {
                        String name = item.getMetadata().getName();
                        if(!imageEntityList.contains(name)){
                            Metadata_ metadata= item.getMetadata();
                            ImageStreamTagListEntity entity = new ImageStreamTagListEntity();
                            Image image = item.getImage();
                            entity.setImage(image.getDockerImageReference());
                            entity.setCreationTimeStamp(metadata.getCreationTimestamp());
                            entity.setName(name);
                            ++count;
                            entity.setId(count);
                            dao.save(entity);
                        }
                    }

                }

            }
        }

    }

    private List<String> getImageEntityList() {
        List<String> entityList = new ArrayList<>();
        Iterable<ImageStreamTagListEntity> imageEntityList = dao.findAll();

        if (imageEntityList != null) {
            for(ImageStreamTagListEntity imageEntity : imageEntityList){
                entityList.add(imageEntity.getName());
            }
        }

        return entityList;
    }

    public List<ImageStreamTagListEntity> getImageStreamListToBeDeleted(String timeInDays){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR,-Integer.parseInt(timeInDays));
        System.out.println("Last Date : " + calendar.getTime());
        List<ImageStreamTagListEntity> returnResponse = new LinkedList<>();
        Iterable<ImageStreamTagListEntity> iterableList = dao.findAll();
        List<String> totalList = new LinkedList<>();
//        Iterable<FuseImageBackupEntity> backUpEntityList = backUpEntityDao.findAll();
        Iterable<FuseImageEntity> entityLIst = fuseImageEntityDao.findAll();
//        for(FuseImageBackupEntity entity : backUpEntityList){
//            totalList.add(entity.getImage());
//        }

        for(FuseImageEntity entity : entityLIst){
            totalList.add(entity.getImage());
        }
        for(ImageStreamTagListEntity streamTagList : iterableList){
            if(streamTagList.getName() != null && !totalList.contains(streamTagList.getName())){
                if(checkIfDateBefore(streamTagList.getCreationTimeStamp(),calendar) && !checkIfExistsInSkipList(streamTagList.getName())) {
                    returnResponse.add(streamTagList);
                }
            }
        }
        return returnResponse;
    }

    private boolean checkIfExistsInSkipList(String name) {

        for(String skipNmae : regSkipList){
            if(name!= null && skipNmae!= null && name.contains(skipNmae)){
                return  true;
            }
        }

        return false;

    }

    private boolean checkIfDateBefore(String creationTimeStamp, Calendar calendar) {
        // 2019-06-04T23:59:59Z
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
            Date newDateTime = dateFormat.parse(creationTimeStamp);
            Calendar entityCal = Calendar.getInstance();
            entityCal.setTimeInMillis(newDateTime.getTime());
            if(entityCal.before(calendar)){
                return true;
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;

    }

    public void delete(ImageStreamTagListEntity entity) {
        dao.delete(entity);
    }
}
