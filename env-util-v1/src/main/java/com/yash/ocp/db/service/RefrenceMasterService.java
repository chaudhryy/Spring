package com.yash.ocp.db.service;

import com.yash.cache.LocalCache;
import com.yash.ocp.db.dao.RefrenceMasterDao;
import com.yash.ocp.db.model.RootRefrenceMaster;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.Timestamp;
import java.util.Calendar;

@Service
public class RefrenceMasterService {

    @PersistenceContext
    EntityManager entityManager;

    @Autowired
    RefrenceMasterDao dao;

    @Autowired
    LocalCache cache;



    public void createVersion(){

        long count = dao.count();
        int nextId = new Long(count).intValue();
        nextId++;
        RootRefrenceMaster master = new RootRefrenceMaster(nextId);
        master.setEnviornment(cache.getNamespace());
        Calendar cal = Calendar.getInstance();
        Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
        master.setCreated(timestamp.toString());
        dao.save(master);
        cache.setLastVersion(nextId);

    }

}
