package com.yash.ocp.db.dao;

import com.yash.ocp.db.model.VersionDelta;
import org.springframework.data.repository.CrudRepository;

public interface VersionDeltaDao extends CrudRepository<VersionDelta,Integer> {

}
