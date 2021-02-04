package nz.co.spark.intg.ocp.utility.ocp.db.dao;

import nz.co.spark.intg.ocp.utility.ocp.db.model.PodList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PodListDao extends CrudRepository<PodList,Integer> {

}
