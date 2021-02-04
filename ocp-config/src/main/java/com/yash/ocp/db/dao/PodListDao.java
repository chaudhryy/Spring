package com.yash.ocp.db.dao;

import com.yash.ocp.db.model.PodList;
import com.yash.ocp.db.model.VersionDelta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodListDao extends CrudRepository<PodList,Integer> {

}
