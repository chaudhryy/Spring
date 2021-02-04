package nz.co.spark.openshift.utility.reg.ocp.db.dao;

import nz.co.spark.openshift.utility.reg.ocp.db.model.ImageStreamTagListEntity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageStreamTagListEntityDao extends CrudRepository<ImageStreamTagListEntity,Long> {

}
