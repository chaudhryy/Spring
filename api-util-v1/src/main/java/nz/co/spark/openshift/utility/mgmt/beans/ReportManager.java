package nz.co.spark.openshift.utility.mgmt.beans;

import nz.co.spark.openshift.utility.mgmt.model.re.RuleRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Component
public class ReportManager {

    private static Logger logger = LoggerFactory.getLogger("Report");

    Map<String, List<RuleRecord>> masterMap = new LinkedHashMap<>();

     public  void printReport(Map<String, Future<List<RuleRecord>>> futureList){
        logger.info("-----------------------------------------------------------------------");
        int usecaseCount =1;
        for (Map.Entry<String, Future<List<RuleRecord>>> entry :futureList.entrySet()  ) {
            logger.info(usecaseCount+ ". \t\tResult for [ " + entry.getKey() + " ]");
            logger.info("-----------------------------------------------------------------------");

            try {
                if (entry.getValue() != null) {
                    List<RuleRecord> recordList = entry.getValue().get();
                    int i =1;
                    for(RuleRecord ruleRecord : recordList){
                        if(ruleRecord.isSuccess()) {
                            logger.info(usecaseCount + "." + i + ". \t" + ruleRecord);
                        }else{
                            logger.error(usecaseCount + "." + i + ". \t" + ruleRecord);

                        }
                        i++;
                    }
                }
                usecaseCount++;
                logger.info("-----------------------------------------------------------------------");

            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
