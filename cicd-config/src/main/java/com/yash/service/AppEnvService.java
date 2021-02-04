package com.yash.service;

import ch.qos.logback.core.util.FileUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.yash.model.AppEnvJson;
import com.yash.model.Env;
import com.yash.model.Resource;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.*;

@Service
public class AppEnvService {

    private static String HEADERS ="REPLICA,APP,ENV,CPU_LIMIT,CPU_REQ,MEM_LIMIT,MEM_REQ,JAVA_OPTS";

    private static ObjectMapper MAPPER = new ObjectMapper();
    {
        MAPPER.enable(SerializationFeature.INDENT_OUTPUT);
    }
    public String prepareConfig(String csvFileName,String repoLocation,String envName){
        Iterable<CSVRecord> valueMap = getValueMap(csvFileName);
        for (CSVRecord record :valueMap) {
            System.out.println(record);
            readJsonAndWrite(repoLocation+"/"+record.get("APP")+"/"+envName,record);

        }
        return "SUCCESS";
    }

//    public static void main(String[] args) {
//        new AppEnvService().updateXmx("C:\\Users\\t827090\\WorkSpace\\dev_workspace\\Repository\\fuse\\2020_1\\intg-fuse-properties1","0");
//    }
    private void readJsonAndWrite(String app, CSVRecord record) {
//        File file = new File(app);
//        file.toString();
        try {
            System.out.println("Path : " + app);
            File existingfile =new File(app+"/appenv.json");
            AppEnvJson json = MAPPER.readValue(existingfile, AppEnvJson.class);
            List<Env> env = json.getEnv();
            List<Env> newEnvList = new LinkedList<>();
            for(Env e : env){
                if(e.getName().equalsIgnoreCase("JAVA_OPTIONS")){
                    String javaOpts = record.get("JAVA_OPTS");
                    if (!StringUtils.isEmpty(javaOpts)) {
                        e.setValue(javaOpts);
                        newEnvList.add(e);
                    }
                }else if(!((e.getName().equalsIgnoreCase("ENVNAME")) || (e.getName().equalsIgnoreCase("PUBSUB_PASSWORD")))){
                    newEnvList.add(e);
                }
            }
            json.setEnv(newEnvList);
            List<Resource> resourceList =json.getResource();
            if(CollectionUtils.isEmpty(resourceList)){
                resourceList = new LinkedList<>();
                json.setResource(resourceList);
            }
           // getAndUpdate(resourceList,"NO_OF_REPLICA",record.get("REPLICA"));//record.get("REPLICA"));
            getAndUpdate(resourceList,"CPU_LIMIT",record.get("CPU_LIMIT"));
            getAndUpdate(resourceList,"CPU_REQUEST",record.get("CPU_REQ"));
            getAndUpdate(resourceList,"MEMORY_LIMIT",record.get("MEM_LIMIT"));
            getAndUpdate(resourceList,"MEMORY_REQUEST",record.get("MEM_REQ"));


//            File newFile = new File(app+"/appenv.json_old");
//            existingfile.renameTo(newFile);
            existingfile.createNewFile();
            MAPPER.writeValue(existingfile,json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void getAndUpdate(List<Resource> resourceList, String key, String value) {
        boolean isNotFound =true;
        if(resourceList.size()>0){
            for(Resource resource : resourceList){
                if(resource != null && resource.getName().equalsIgnoreCase(key)){
                    resource.setValue(value);
                    isNotFound = false;
                }

            }
        }
        if(isNotFound){
            Resource res = new Resource();
            resourceList.add(res);
            res.setName(key);
            res.setValue(value);
        }

    }

    private Iterable<CSVRecord> getValueMap(String csvFileName) {

        try {
            Reader in = new FileReader(csvFileName);
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            return records;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static String encode(String key, String data) throws Exception {
        Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
        sha256_HMAC.init(secret_key);
        byte[] u =sha256_HMAC.doFinal(data.getBytes("UTF-8"));

        return  Base64Utils.encodeToString(u);
    }



    public void updateXmx(String repoLocation,String valueToAdd) {

        File baseDir = new File(repoLocation);
        if(baseDir.isDirectory()){
            System.out.println("inside base Directory " + baseDir.getAbsolutePath());
            for(File module : baseDir.listFiles()){
                System.out.println("Inside Module "+ module.getName());
                if(module.isDirectory()){
                    System.out.println("Is a Directory");
                    for(File app : module.listFiles()){
                        System.out.println("Exploring APP" + app.getName());
                            if(app.isDirectory() && app.getName().contains("Production")){
                                System.out.println("Inside Application " + app.getName());
                                for(File file : app.listFiles()) {
                                    if (file.getName().equalsIgnoreCase("appenv.json")) {
                                        System.out.println("Inside Appenv.json");
                                        try {
                                            AppEnvJson json = MAPPER.readValue(file, AppEnvJson.class);
                                            List<Env> env = json.getEnv();
                                            List<Resource> resource = json.getResource();
                                            String memRequest = getValueFromRes(resource);
                                            String newValue = null;
                                            List<Env> newEnvList = new LinkedList<>();
                                            for(Env e : env){
                                                if(!((e.getName().equalsIgnoreCase("ENVNAME")) || (e.getName().equalsIgnoreCase("PUBSUB_PASSWORD")))){
                                                    if(e.getName().equalsIgnoreCase("JAVA_OPTIONS")) {
                                                        newValue = increaseXmx1(e.getValue(), valueToAdd);

                                                    }
                                                }
                                            }

                                            int xmxVal = Integer.parseInt(newValue.replace("m",""));
                                            int memLimit = Integer.parseInt(memRequest.replace("Mi",""));
                                            if(xmxVal > memLimit){
                                                for(Resource res : resource){
                                                    if(res.getName().equalsIgnoreCase("MEMORY_REQUEST")){
                                                        res.setValue(xmxVal+"Mi");
                                                    }

                                                }
                                            }
                                            for(Env e : env){
                                                if(!((e.getName().equalsIgnoreCase("ENVNAME")) || (e.getName().equalsIgnoreCase("PUBSUB_PASSWORD")))){
                                                    if(e.getName().equalsIgnoreCase("JAVA_OPTIONS")) {
                                                        newValue = increaseXmx(e.getValue(), xmxVal);
                                                        e.setValue(newValue);

                                                    }
                                                }
                                            }
                                            json.setEnv(env);
                                            json.setResource(resource);
//                                            List<Resource> resourceList =json.getResource();
//                                            if(CollectionUtils.isEmpty(resourceList)){
//                                                resourceList = new LinkedList<>();
//                                                json.setResource(resourceList);
//                                            }

                                            file.createNewFile();
                                            MAPPER.writeValue(file,json);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }
                            }
                    }
                }
            }
        }else{
            System.out.println("Doesnt Exist "+ baseDir.getName());
        }

    }

    private String increaseXmx1(String value, String valueToAdd) {
        System.out.println("Updating Java Opts " + value);
        String[] javaOpts = value.split(" ");
        List<String> newJavaOpts = new ArrayList<>();
        for(String val:javaOpts){
            if(!StringUtils.isEmpty(val)){
                if(val.contains("Xmx")){
                    String rrippedVal = val.replace("-Xmx","");
                    return rrippedVal;
                }else{
                    newJavaOpts.add(val);
                }
            }
        }


        return  null;
    }

    private String getValueFromRes(List<Resource> resource) {
        for(Resource res : resource){
            if(res.getName().equalsIgnoreCase("MEMORY_REQUEST")){
                return res.getValue();
            }

        }
        return null;
    }

    private String increaseXmx(String value, int valueToAdd) {
        System.out.println("Updating Java Opts " + value);
            String[] javaOpts = value.split(" ");
            List<String> newJavaOpts = new ArrayList<>();
            for(String val:javaOpts){
                if(!StringUtils.isEmpty(val)){
                    if(val.contains("Xmx")){
                        String rrippedVal = val.replace("-Xmx","");
                        String furtherRipped = rrippedVal.substring(0,rrippedVal.length()-1);
                        try {


                            String newXmx = val.replace("-Xmx"+furtherRipped,"-Xmx"+valueToAdd);
                            String newXms = "-Xms"+valueToAdd+"m";
                            newJavaOpts.add(newXmx);
                            newJavaOpts.add(newXms);
                        } catch (NumberFormatException e) {
                            e.printStackTrace();
                        }

                    }else if(val.contains("Xms")){

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
        System.out.println("Returned Update JavaOpts " + sb.toString());
        return  sb.toString();
    }
}
