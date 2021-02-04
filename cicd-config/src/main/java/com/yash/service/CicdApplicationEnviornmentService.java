package com.yash.service;

import com.yash.common.ActionTypeEnum;
import com.yash.common.TargetEnviornmentNamespaceEnum;
import com.yash.common.utils.FileProcessorUtil;
import com.yash.common.utils.MetricsRecorder;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@Component
@CommandLine.Command(name = "Update-Variables", mixinStandardHelpOptions = true, version = "Update-Variables 1.0",
        description = "Updates the appenv.json in you local repo copy.")
public class CicdApplicationEnviornmentService implements Callable<Integer> {


    @CommandLine.Option(names = {"-a", "--action"}, required = true, paramLabel = "ActionType", description = "The action type, Expected Values : ${COMPLETION-CANDIDATES}")
    ActionTypeEnum type;

    @CommandLine.Option(names = {"-f", "--file"}, required = false, paramLabel = "CsvFile", description = "The input csv file with absolute path")
    String csvFilePath;

    @CommandLine.Option(names = {"-r", "--repo"}, required = false, paramLabel = "RepoPath", description = "The Local repository path hosting all the properties and appenv.json")
    String repoPath;

    @CommandLine.Option(names = {"-e", "--env"}, required = false, paramLabel = "Environment", description = "The Target Environment appenv.json to be updated , Expected Values : ${COMPLETION-CANDIDATES}")
    TargetEnviornmentNamespaceEnum targetEnvName;

    @CommandLine.Option(names = {"-v", "--valueToAdd"}, defaultValue = "0", paramLabel = "ValueToAdd", description = "Required only Updating the Java Options")
    String valueToAdd;

    @CommandLine.Option(names = {"-x", "--Xms"}, defaultValue = "false", paramLabel = "XMS", description = "This will remove Xms if disabled and if enabled will copy the value of XMX to XMS")
    boolean addXms;

    @CommandLine.Option(names = {"-g", "--report"}, defaultValue = "false", paramLabel = "isCsvReport", description = "This is to generate Report in CSV Format ")
    boolean generateCsv;

    @CommandLine.Option(names = {"-s", "--sourceCsv"}, paramLabel = "SourceCsv", description = "Absolute source file path")
    String sourceCsv;

    @CommandLine.Option(names = {"-t", "--targetCsv"}, paramLabel = "TargetCsv", description = "Absolute target file path")
    String targetCsv;

    @Autowired
    FileProcessorUtil fileProcessor;

    @Autowired
    MetricsRecorder recorder;
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    @Override
    public Integer call() throws Exception {

        switch (type) {


                case compare_csv:
                    fileProcessor = new FileProcessorUtil();
                    fileProcessor.recordModules(repoPath);
                    fileProcessor.compareCsv(sourceCsv, targetCsv);
                    break;
                case java_opts:
                    fileProcessor = new FileProcessorUtil();
                    Iterable<CSVRecord> csvRecordList1 = fileProcessor.getCsvFileRecords(csvFilePath);
                    fileProcessor.recordModules(repoPath);
                    for (CSVRecord record : csvRecordList1) {
                        fileProcessor.updateJavaOptions(repoPath + "/" + record.get("APP") + "/" + targetEnvName.getNamespace(), valueToAdd, addXms, record);
                    }
                    break;
                case variable:
                    fileProcessor = new FileProcessorUtil();
                    Iterable<CSVRecord> csvRecordList2 = fileProcessor.getCsvFileRecords(csvFilePath);
                    fileProcessor.recordModules(repoPath);
                    for (CSVRecord record : csvRecordList2) {
                        fileProcessor.updateAppEnvJson(repoPath + "/" + record.get("APP") + "/" + targetEnvName.getNamespace(), record);
                    }
            }

        recorder.generateReport(generateCsv);

        return 0;
    }
}
