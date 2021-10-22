package nz.co.spark.openshift.utility.fuse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuseBusinessService {

    @Autowired
    OpenShiftBusinessService service;

    public void execute() throws Exception{
            service.getEnvVariables();
            service.getPropertiesFile();
            service.resolvePodParams();

    }
}
