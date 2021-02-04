package com.yash.common.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yash.model.AppEnvJson;
import com.yash.model.Env;
import com.yash.model.Resource;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

@Component
public class FileProcessorUtil {


   static List<String> resourceVariableList = new ArrayList<>();
   static {
       resourceVariableList.add("NO_OF_REPLICA");
       resourceVariableList.add("CPU_LIMIT");
       resourceVariableList.add("CPU_REQUEST");
       resourceVariableList.add("MEMORY_LIST");
       resourceVariableList.add("MEMORY_REQUEST");
   }

    MetricsRecorder recorder = new MetricsRecorder();

    private static ObjectMapper MAPPER = new ObjectMapper();
    {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public Iterable<CSVRecord> getCsvFileRecords(String csvFilePath) {
        try {
            Reader in = new FileReader(csvFilePath);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            return records;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void updateAppEnvJson(String app, CSVRecord record) {
        try {
            File oAppEnvJsonFile =new File(app+"/appenv.json");
            AppEnvJson oAppEnvJson = MAPPER.readValue(oAppEnvJsonFile, AppEnvJson.class);
            List<Env> oEnvList = oAppEnvJson.getEnv();
            List<Resource> oResourceList =oAppEnvJson.getResource();
            Map<String, String> nRecordMap = record.toMap();
            List<Env> nEnvList = getNewAppEnvList(oEnvList,nRecordMap);
            List<Resource> nResourceList = getNewResourceList(oResourceList,nRecordMap);

            AppEnvJson nAppEnvJson = new AppEnvJson();
            nAppEnvJson.setEnv(nEnvList);
            nAppEnvJson.setResource(nResourceList);

            oAppEnvJsonFile.createNewFile();
            MAPPER.writeValue(oAppEnvJsonFile,nAppEnvJson);

        } catch (IOException|CloneNotSupportedException e) {
            e.printStackTrace();
        }

    }

    private List<Env> getNewAppEnvList(List<Env> oEnvList, Map<String, String> nRecordMap) throws CloneNotSupportedException {
        List<Env> nEnvList = new ArrayList<>();
        if (resourceVariableList != null) {
            for(Env env : oEnvList){
                if(!resourceVariableList.contains(env.getName())){
                    if(!((env.getName().equalsIgnoreCase("ENVNAME")) || (env.getName().equalsIgnoreCase("PUBSUB_PASSWORD")))){
                        String value =nRecordMap.get(env.getName());
                        Env nEnv = new Env();
                        nEnv.setValue(env.getValue());
                        nEnv.setName(env.getName());
                        nEnv.setSecretKey(env.getSecretKey());
                        nEnv.setSecretName(env.getSecretName());
                        nEnv.setValueFrom(env.getValueFrom());

                        if (!StringUtils.isEmpty(value)) {
                            if(!value.equalsIgnoreCase(env.getValue())){
                                if(env.getName().equalsIgnoreCase("JAVA_OPTIONS")){
                                    Map<String,String> inDepthDiff = getInDepthDiffInJavaOptions(env.getValue(),value);
                                    if(!(StringUtils.isEmpty(inDepthDiff.get("OLD")) && StringUtils.isEmpty(inDepthDiff.get("NEW")))) {
                                        nEnv.setValue(getJavaOptionsAsString(getStringAsList(value)));
                                        recorder.recordEnvChange(nRecordMap.get("APP"), env.getName(), inDepthDiff.get("OLD"), inDepthDiff.get("NEW"));
                                    }
                                }else{
                                    recorder.recordEnvChange(nRecordMap.get("APP"),env.getName(),env.getValue(),value);
                                    nEnv.setValue(value);

                                }
                            }
                        }

                        nEnvList.add(nEnv);
                    }else{
                        recorder.recordEnvChange(nRecordMap.get("APP"),env.getName(),env.getValue(),"");

                    }
                }

            }
        }

        return nEnvList;
    }

    private Map<String, String> getInDepthDiffInJavaOptions(String oldValue, String newValue) {
        Set<String> olValList = getStringAsList(oldValue);
        Set<String> nValList = getStringAsList(newValue);
        Set<String> oValListClone = new LinkedHashSet<>(olValList);
        Set<String> nValListClone = new LinkedHashSet<>(nValList);
        for(String val : oValListClone){
            if(nValList.contains(val)){
                nValList.remove(val);
                olValList.remove(val);
            }
        }
        Map<String,String> retMap = new HashMap<>();
        retMap.put("OLD",getJavaOptionsAsString(olValList));
        retMap.put("NEW",getJavaOptionsAsString(nValList));

        return retMap;
    }

    private String getJavaOptionsAsString(Set<String> olValList) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst =true;
        for(String st : olValList){
            if(isFirst){
                sb.append(st);
                isFirst = false;
            }else {
                sb.append(" "+st);
            }
        }
        return  sb.toString();
    }

    private Set<String> getStringAsList(String oldValue) {
        Set<String> retVal = new LinkedHashSet<>();
        String[] valArr = oldValue.split(" ");

        for (String val : valArr ){
            if(!StringUtils.isEmpty(val)){
                retVal.add(val);
            }
        }
        return retVal;
    }

    private List<Resource> getNewResourceList(List<Resource> oEnvList, Map<String, String> nRecordMap) throws CloneNotSupportedException {
        List<Resource> nResourceList = new ArrayList<>();
        if (oEnvList != null) {
            for(Resource resource : oEnvList){
                String value =nRecordMap.get(resource.getName());
                Resource nResource = new Resource();
                nResource.setValue(resource.getValue());
                nResource.setName(resource.getName());


                if (!StringUtils.isEmpty(value)) {
                    if(!value.equalsIgnoreCase(resource.getValue())) {
                        nResource.setValue(value);
                        recorder.recordResourceChange(nRecordMap.get("APP"), nResource.getName(), resource.getValue(),nResource.getValue());
                    }
                }
                nResourceList.add(nResource);
            }
        }else{
            for(String variable : resourceVariableList){
                String value =nRecordMap.get(variable);
                Resource nResource = new Resource();
                nResource.setValue(value);
                nResource.setName(variable);


                if (!StringUtils.isEmpty(value)) {
                    if(!value.equalsIgnoreCase(nResource.getValue())) {
                        nResource.setValue(value);
                        recorder.recordResourceChange(nRecordMap.get("APP"), nResource.getName(), "",nResource.getValue());
                    }
                }
                nResourceList.add(nResource);
            }
        }

        return nResourceList;
    }


    public void updateJavaOptions(String repoLocation, String valueToAdd, boolean addXms, CSVRecord record) {

     try {
         File oAppEnvJsonFile =new File(repoLocation+"/appenv.json");
         AppEnvJson oAppEnvJson = MAPPER.readValue(oAppEnvJsonFile, AppEnvJson.class);
         List<Env> oEnvList = oAppEnvJson.getEnv();
         List<Env> nEnvList = new LinkedList<>();
         for(Env e : oEnvList){
             if(!((e.getName().equalsIgnoreCase("ENVNAME")) || (e.getName().equalsIgnoreCase("PUBSUB_PASSWORD")))){
                 if(e.getName().equalsIgnoreCase("JAVA_OPTIONS")){
                     String newValue = increaseXmx(e.getValue(),valueToAdd,addXms,record);
                     e.setValue(newValue);
                     nEnvList.add(e);
                 }else{
                     nEnvList.add(e);
                 }
             }
         }

         AppEnvJson nAppEnvJson = new AppEnvJson();
         nAppEnvJson.setEnv(nEnvList);
         nAppEnvJson.setResource(oAppEnvJson.getResource());

         oAppEnvJsonFile.createNewFile();
         MAPPER.writeValue(oAppEnvJsonFile,nAppEnvJson);
     } catch (IOException e) {
         e.printStackTrace();
     }


    }
    private String increaseXmx(String value, String valueToAdd, boolean addXms, CSVRecord record) {
        String[] javaOpts = value.split(" ");
        List<String> newJavaOpts = new ArrayList<>();
        Map<String, String> nRecordMap = record.toMap();

        int increaseByValue = Integer.parseInt(valueToAdd);
        for(String val:javaOpts){
            if(!StringUtils.isEmpty(val)){
                if(val.contains("Xmx")){
                    String rrippedVal = val.replace("-Xmx","");
                    String furtherRipped = rrippedVal.substring(0,rrippedVal.length()-1);
                    try {

                        int intVal = Integer.parseInt(furtherRipped);
                        intVal= intVal+increaseByValue;
                        String newXmx = val.replace("-Xmx"+furtherRipped,"-Xmx"+intVal);
                        newJavaOpts.add(newXmx);
                        recorder.recordEnvChange(nRecordMap.get("APP"), "XMX", val, newXmx);

                        if(addXms){
                            String xms = newXmx.replace("-Xmx","-Xms");
                            newJavaOpts.add(xms);
                            recorder.recordEnvChange(nRecordMap.get("APP"), "XMS", null, xms);
                        }


                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                }else if(val.contains("Xms") && !addXms){
                    recorder.recordEnvChange(nRecordMap.get("APP"), "Xms", val, "Removed");

                }else{
                    newJavaOpts.add(val);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        boolean isFirst =true;
        for(String st : newJavaOpts){
            if(isFirst){
                sb.append(st);
                isFirst = false;
            }else {
                sb.append(" "+st);
            }
        }
        return  sb.toString();
    }

    public void recordModules(String repoPath) {
        File baseDir = new File(repoPath);
        if(baseDir.isDirectory()){
            File[] fileList =baseDir.listFiles();
            List<String> moduleList = new ArrayList<>();
            for(File file : fileList){
                moduleList.add(file.getName());
            }
            recorder.setModuleList(moduleList);

        }
    }

    public void compareCsv(String sourceCsv, String targetCsv) {
        Iterable<CSVRecord> sourceCsvRecordList = getCsvFileRecords(sourceCsv);
        Iterable<CSVRecord> targetCsvRecordList = getCsvFileRecords(targetCsv);

        Map<String, Map<String, String>> sourceMap = getMap(sourceCsvRecordList);
        Map<String, Map<String, String>> targetMap = getMap(targetCsvRecordList);

        for(Map.Entry<String, Map<String, String>> entry : sourceMap.entrySet()){
            Map<String, String> sRecordMap = entry.getValue();
            Map<String, String> tRecordMap  = targetMap.get(entry.getKey());


                for (Map.Entry<String, String> sRecMap : sRecordMap.entrySet()) {
                     if (!(sRecMap.getKey().equalsIgnoreCase("POD"))) {
                        if(tRecordMap == null){
                            recorder.recordResourceChange(entry.getKey(),sRecMap.getKey(),sRecMap.getValue(),"");
                        }else {
                            if(sRecMap.getKey().equalsIgnoreCase("XMX")){
                                Map<String,String> inDepthDiff = getInDepthDiffInJavaOptions(sRecMap.getValue(),tRecordMap.get("XMX"));
                                if(!(StringUtils.isEmpty(inDepthDiff.get("OLD")) && StringUtils.isEmpty(inDepthDiff.get("NEW")))) {
                                    recorder.recordEnvChange(entry.getKey(),"XMX", inDepthDiff.get("OLD"), inDepthDiff.get("NEW"));
                                }
                            }else{
                                 String tValue = tRecordMap.get(sRecMap.getKey());
                                    if (!(tValue.equalsIgnoreCase(sRecMap.getValue()))) {
                                        recorder.recordResourceChange(entry.getKey(),sRecMap.getKey(),sRecMap.getValue(),tValue);
                                    }
                            }
                    }

                }
            }

        }

        for(Map.Entry<String, Map<String, String>> entry : targetMap.entrySet()){
            Map<String, String> tRecordMap = entry.getValue();
            Map<String, String> sRecordMap  = sourceMap.get(entry.getKey());


            for (Map.Entry<String, String> tRecMap : tRecordMap.entrySet()) {
                if (!(tRecMap.getKey().equalsIgnoreCase("POD"))) {
                    if(sRecordMap == null){
                        recorder.recordResourceChange(entry.getKey(),tRecMap.getKey(),"",tRecMap.getValue());
                    }else {
                        String sValue = tRecordMap.get(tRecMap.getKey());
                        if (!(sValue.equalsIgnoreCase(tRecMap.getValue()))) {
                            recorder.recordResourceChange(entry.getKey(),tRecMap.getKey(),sValue,tRecMap.getValue());
                        }
                    }

                }
            }

        }




    }

    private Map<String, Map<String,String>> getMap(Iterable<CSVRecord> sourceCsvRecordList) {
        Map<String, Map<String,String>> returnMap = new LinkedHashMap<>();
            for(CSVRecord record : sourceCsvRecordList){
                Map<String, String> nRecordMap = record.toMap();

                Map<String, String> recordMap = returnMap.get(nRecordMap.get("APP"));
                if(recordMap != null){
                    String count = recordMap.get("Count");
                    int intCount = Integer.parseInt(count);
                    intCount++;
                    recordMap.put("Count",intCount+"");
                }else{
                    String app = getValueForKey(nRecordMap,"APP");
                    String pod = nRecordMap.get("POD");
                    String release = pod.substring(0,pod.lastIndexOf("-"));
                    String releaseWithout = release.substring(0,release.lastIndexOf("-")).replace(app+"-","");
                    nRecordMap.put("Release",releaseWithout);
                    nRecordMap.put("Count","1");
                    returnMap.put(app,nRecordMap);
                }
            }
        return returnMap;
    }

    private String getValueForKey(Map<String, String> nRecordMap, String key) {
        Map.Entry<String, String> rEntry = null ;
        for(Map.Entry<String, String> entry : nRecordMap.entrySet()){
            if(entry.getKey().contains(key)){
                rEntry= entry;
            }

        }
        if(rEntry != null){
         nRecordMap.remove(rEntry.getKey());
         nRecordMap.put(key,rEntry.getValue());
         return rEntry.getValue();
        }
        return "";
    }
}
