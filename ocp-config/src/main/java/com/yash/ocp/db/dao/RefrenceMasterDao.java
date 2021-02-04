package com.yash.ocp.db.dao;

import com.yash.ocp.db.model.RootRefrenceMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefrenceMasterDao  extends CrudRepository<RootRefrenceMaster,Integer> {


}
