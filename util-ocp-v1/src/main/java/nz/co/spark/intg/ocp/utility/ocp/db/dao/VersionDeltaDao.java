package nz.co.spark.intg.ocp.utility.ocp.db.dao;

import nz.co.spark.intg.ocp.utility.ocp.db.model.VersionDelta;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VersionDeltaDao extends CrudRepository<VersionDelta,Integer> {

}
