package nz.co.spark.openshift.utility.mgmt.beans;

import freemarker.template.TemplateException;
import nz.co.spark.openshift.utility.mgmt.model.InputParameters;
import nz.co.spark.openshift.utility.mgmt.model.re.RuleRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

public class ApiServiceThread implements Callable<List<RuleRecord>> {

    private static Logger logger = LoggerFactory.getLogger("ServiceThread");

    InputParameters parameters;

    Map<String,String> dataMap;

    RequestManager manager ;

    RestTemplate restTemplate;

    RuleManager ruleManager;

    public ApiServiceThread(Map<String, String> dataMap, InputParameters parameters, RequestManager manager, RestTemplate restTemplate, RuleManager ruleManager){
        this.dataMap = dataMap;
        this.parameters = parameters;
        this.manager = manager;
        this.restTemplate = restTemplate;
        this.ruleManager = ruleManager;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public List<RuleRecord> call() {
        logger.debug("Executing Service Thread for UseCase " + dataMap.get("Usecase"));
        try {
           String request = manager.prepareRequest(dataMap);


            HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.CONTENT_TYPE,parameters.getContentType());
            HttpEntity<String> entity = new HttpEntity<String>(request,headers);

            logger.info("Request " + request);
            ResponseEntity<?> response = restTemplate.exchange(parameters.getUrl(), HttpMethod.valueOf(parameters.getHttpMethod()),entity,String.class);
            ArrayList<RuleRecord> returnList =  ruleManager.validateRules(dataMap.get("Usecase"),response);
            logger.info("Response Code " + response.getStatusCode() );
            logger.info("Response Body " + response.getBody());
            logger.debug("Finished Executing Service Thread for UseCase " + dataMap.get("Usecase") );
            logger.debug("Returned " + returnList);
            return returnList;
        } catch (IOException |TemplateException e) {
            e.printStackTrace();
        }
        return  new ArrayList<>();
    }
}
