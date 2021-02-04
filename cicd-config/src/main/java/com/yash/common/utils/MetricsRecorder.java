package com.yash.common.utils;

import com.yash.model.RecorderStats;
import de.vandermeer.asciitable.AT_Context;
import de.vandermeer.asciitable.AsciiTable;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

@Component
public class MetricsRecorder {


    static Map<String, RecorderStats> changes = new HashMap<>();
    static List<String> moduleList = new ArrayList<>() ;

    public void recordEnvChange(String app, String key,String oldV,String newV) {
        RecorderStats stats = changes.get(app);
        if(stats == null){
            stats = new RecorderStats();
            changes.put(app,stats);
        }
        stats.setEnvChange(key,oldV,newV);
    }

    public void recordResourceChange(String app, String key,String oldV,String newV) {
        RecorderStats stats = changes.get(app);
        if(stats == null){
            stats = new RecorderStats();
            changes.put(app,stats);
        }
        stats.setResourceChanges(key,oldV,newV);
    }

    public void setModuleList(List<String> moduleList) {
        this.moduleList.addAll(moduleList);
    }

    public void generateReport(boolean generateCsv){
        {

            AT_Context context = new AT_Context();
            context.setWidth(150);
            AsciiTable table = new AsciiTable(context);
            table.addRule();
            table.addRow("Module_Name", "Change_type", "Key","state", "Change_Comment");

            for (Map.Entry<String, RecorderStats> entry : changes.entrySet()) {
                table.addRule();

                table.addRow(entry.getKey(), "", "", "","");

                RecorderStats stats = entry.getValue();
                if (stats.getEnvChange().size() > 0) {
                    for (Map.Entry<String, Map<String, String>> subEntryEnv : stats.getEnvChange().entrySet()) {
                        for(Map.Entry<String, String> onVMap : subEntryEnv.getValue().entrySet()){
                            table.addRule();
                            table.addRow("", "Environment", subEntryEnv.getKey(),onVMap.getKey(), onVMap.getValue());
                        }
                    }
                }

                if (stats.getResourceChanges().size() > 0) {
                    for (Map.Entry<String, Map<String, String>> subEntryEnv : stats.getResourceChanges().entrySet()) {
                        for(Map.Entry<String, String> onVMap : subEntryEnv.getValue().entrySet()){
                            table.addRule();
                            table.addRow("", "Resource", subEntryEnv.getKey(),onVMap.getKey(), onVMap.getValue());
                        }
                    }

                }


            }
            System.out.println(table.render());
            System.out.println("");
            if(generateCsv){
                writeRecordsAsCsv(null);
            }

        }
        {

            AsciiTable table = new AsciiTable();
            List<String> noChangeList = new ArrayList<>();
            for (String module : moduleList) {
                RecorderStats stat = changes.get(module);
                if (stat == null && !module.equalsIgnoreCase(".git")) {
                    noChangeList.add(module);
                }

            }

            if(noChangeList.size() > 0){
                table.addRule();
                table.addRow("Fuse Modules ( No - Change )");
                for(String changeModule : noChangeList) {
                    table.addRule();
                    table.addRow(changeModule);
                }
                System.out.println(table.render());
                if(generateCsv){
                    writeRecordsAsCsv(noChangeList);
                }
            }
        }


    }

    private void writeRecordsAsCsv(List<String> noChangeList) {
        try {
        if (noChangeList == null) {

                BufferedWriter writer = Files.newBufferedWriter(Paths.get("application_"+new Date().getTime()+".csv"));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("Module_Name", "Change_type", "Key","state", "Change_Comment"));
                for (Map.Entry<String, RecorderStats> entry : changes.entrySet()) {

                    csvPrinter.printRecord(entry.getKey(),"", "", "","");

                    RecorderStats stats = entry.getValue();
                    if (stats.getEnvChange().size() > 0) {
                        for (Map.Entry<String, Map<String, String>> subEntryEnv : stats.getEnvChange().entrySet()) {
                            for(Map.Entry<String, String> onVMap : subEntryEnv.getValue().entrySet()){
                                csvPrinter.printRecord("", "Environment", subEntryEnv.getKey(),onVMap.getKey(), onVMap.getValue());
                            }
                        }
                    }

                    if (stats.getResourceChanges().size() > 0) {
                        for (Map.Entry<String, Map<String, String>> subEntryEnv : stats.getResourceChanges().entrySet()) {
                            for(Map.Entry<String, String> onVMap : subEntryEnv.getValue().entrySet()){
                                csvPrinter.printRecord("", "Resource", subEntryEnv.getKey(),onVMap.getKey(), onVMap.getValue());
                            }
                        }

                    }


                }
            csvPrinter.flush();

        }else{
            BufferedWriter writer = Files.newBufferedWriter(Paths.get("application_"+new Date().getTime()+".csv"));
            CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                    .withHeader("Fuse Modules ( No - Change )"));
            for(String changeModule : noChangeList) {
                csvPrinter.printRecord(changeModule);
            }
            csvPrinter.flush();
        }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
