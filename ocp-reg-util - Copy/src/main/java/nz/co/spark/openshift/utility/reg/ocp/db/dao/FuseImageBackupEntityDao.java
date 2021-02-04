package nz.co.spark.openshift.utility.reg.ocp.db.dao;

import nz.co.spark.openshift.utility.reg.ocp.db.model.FuseImageBackupEntity;
import nz.co.spark.openshift.utility.reg.ocp.db.model.FuseImageEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FuseImageBackupEntityDao extends CrudRepository<FuseImageBackupEntity,Long> {
}
