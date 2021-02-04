package nz.co.spark.intg.ocp.utility.ocp.db.dao;

import nz.co.spark.intg.ocp.utility.ocp.db.model.RootRefrenceMaster;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RefrenceMasterDao  extends CrudRepository<RootRefrenceMaster,Integer> {


}
