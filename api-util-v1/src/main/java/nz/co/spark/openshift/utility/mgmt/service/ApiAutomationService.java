package nz.co.spark.openshift.utility.mgmt.service;


import nz.co.spark.openshift.utility.mgmt.beans.ApiServiceThread;
import nz.co.spark.openshift.utility.mgmt.beans.ReportManager;
import nz.co.spark.openshift.utility.mgmt.beans.RequestManager;
import nz.co.spark.openshift.utility.mgmt.beans.RuleManager;
import nz.co.spark.openshift.utility.mgmt.model.InputParameters;
import nz.co.spark.openshift.utility.mgmt.model.re.RuleRecord;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

@Component
public class ApiAutomationService {

    private static Logger logger = LoggerFactory.getLogger("Application");


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    RequestManager requestManager;

    @Autowired
    RuleManager ruleManager;

    @Autowired
    ReportManager reportManager;

     public void execute(InputParameters parameters){
        try {
            logger.debug("Request recieved with " + parameters);
            requestManager.init();
            ruleManager.init(parameters.getRuleFile(),reportManager);
            Iterable<CSVRecord> records =  getCSVRecords(parameters);
            Map<String,Future<List<RuleRecord>>> futureList = new LinkedHashMap<>();
            int maxThreads = parameters.getThreads() >1 ?parameters.getThreads():1;
            ExecutorService executor = Executors.newWorkStealingPool(maxThreads);
            for (CSVRecord record:records) {
                Map<String, String> recordMap = record.toMap();
                logger.debug("Submitting request for usecase [ " +recordMap.get("Usecase") + "] ");

                ApiServiceThread thread = new ApiServiceThread(recordMap,parameters, requestManager,restTemplate,ruleManager);
                Future<List<RuleRecord>> task = executor.submit(thread);
                futureList.put(recordMap.get("Usecase")+record.hashCode(),task);
                logger.debug("Request Submitted for Usecase  [ " +recordMap.get("Usecase") + "] ");

            }
            waitForThreads(futureList);
            reportManager.printReport(futureList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void waitForThreads(Map<String,Future<List<RuleRecord>>> futureList) {
         Map<String,List<RuleRecord>> outputMap = new LinkedHashMap<>();
        boolean isRunning = true ;
        while (isRunning){
            boolean isRunningTemp = false;
            for (Map.Entry<String, Future<List<RuleRecord>>> entry :futureList.entrySet()  ) {
                Future<List<RuleRecord>> future = entry.getValue();
                if (!isRunningTemp) {
                    boolean temp= future.isDone();
                    if( !temp){
                        isRunningTemp = true;
                    }
                }
                isRunning =isRunningTemp;
            }
        }

    }

    private Iterable<CSVRecord> getCSVRecords(InputParameters parameters) throws IOException {
        Reader in = new FileReader(parameters.getDataFile().getAbsolutePath());
        final CSVFormat format = CSVFormat.DEFAULT.withFirstRecordAsHeader();
        CSVParser parser = new CSVParser(in,format);
        return parser.getRecords();
    }
}
