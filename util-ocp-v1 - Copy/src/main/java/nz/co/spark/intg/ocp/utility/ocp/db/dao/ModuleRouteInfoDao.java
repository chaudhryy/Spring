package nz.co.spark.intg.ocp.utility.ocp.db.dao;

import nz.co.spark.intg.ocp.utility.ocp.db.model.ModuleRouteInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRouteInfoDao extends CrudRepository<ModuleRouteInfo,Integer> {
}
