package nz.co.spark.openshift.utility.reg.service;


import nz.co.spark.openshift.utility.reg.beans.RestOcpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegistryMaintainenceService {

    @Autowired
    RestOCPTransformationService service;


    public void execute(){

        // Fetch and Record Current Releases

            service.getReleases();
        // Filter Out Existing Releases

    }
}
