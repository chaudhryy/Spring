package nz.co.spark.intg.ocp.utility.ocp.db.service;

import nz.co.spark.intg.ocp.utility.cache.LocalCache;
import nz.co.spark.intg.ocp.utility.cache.PodCache;
import nz.co.spark.intg.ocp.utility.ocp.utils.DbUtil;
import nz.co.spark.intg.ocp.utility.ocp.db.dao.PodListDao;
import nz.co.spark.intg.ocp.utility.ocp.db.dao.RefrenceMasterDao;
import nz.co.spark.intg.ocp.utility.ocp.db.model.PodList;
import nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists.PodListSuccessResponse;
import nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

@Service
public class PodListService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    PodListDao dao;

    @Autowired
    RefrenceMasterDao masterDao;

    @Autowired
    LocalCache cache;

    @Autowired
    PodCache podCache;




    public void createPodList(PodListSuccessResponse response) {

        if(response != null && !CollectionUtils.isEmpty(response.getItems())){
                int count = new Long(dao.count()).intValue();
            for(Item item : response.getItems()){
                count++;
                if (item!= null && item.getMetadata()!= null && !item.getMetadata().getName().startsWith("amq")) {
                    PodList podList = new PodList();
                    podList.setModule_Name(item.getMetadata().getLabels().getApp());
                    podList.setPod_Name(item.getMetadata().getName());
                    podList.setId(count);
                    podList.setRelease(DbUtil.getRelease(item.getMetadata().getName()));
                    Calendar cal = Calendar.getInstance();
                    Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
                    podList.setCreated(item.getMetadata().getCreationTimestamp());
                    podList.setVersion(cache.getLastVersion());

                    dao.save(podList);
                    System.out.println("Successfully Created POD " + podList.getPod_Name() + " Version " + cache.getLastVersion());
                }
            }
        }

    }



    private void compare(Map<String, PodList> recentVersion, Map<String, PodList> prevVersion) {


    }

    public void compareLastTwoVersions(int from, int to) {
        Map<String, PodList> recentVersion = new HashMap<>();
        Map<String,PodList> prevVersion = new HashMap<>();

        {
            Iterable<PodList> podList = dao.findAll();

            if (podList != null) {
                for (PodList pod : podList) {
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
}
