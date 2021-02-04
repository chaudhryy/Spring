package com.yash.ocp.db.dao;

import com.yash.ocp.db.model.ModuleStat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleStatDao extends CrudRepository<ModuleStat,Integer> {
}
