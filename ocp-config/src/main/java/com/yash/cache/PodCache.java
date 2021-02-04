package com.yash.cache;

import com.yash.model.Holder;
import com.yash.model.Pod;
import org.springframework.shell.table.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class PodCache {


    Map<String, Pod> podDiff = new HashMap<>();
    Map<String,Pod> newDeploy = new HashMap<>();

    List<String> buildChange = new ArrayList<>();
    List<String> configChange = new ArrayList<>();
    List<String> bothChange = new ArrayList<>();
    List<String> noChange = new ArrayList<>();

    List<String> soapEndpoint = new ArrayList<>();
    List<String> restEndpoint = new ArrayList<>();

    long preCpuLimit = 0l;
    long preMemLimit = 0l;

    long postCpuLimit = 0l;
    long postMemLimit = 0l;

    public long getPostCpuLimit() {
        return postCpuLimit;
    }

    public void setPostCpuLimit(long postCpuLimit) {
        this.postCpuLimit = postCpuLimit;
    }

    public long getPostMemLimit() {
        return postMemLimit;
    }

    public void setPostMemLimit(long postMemLimit) {
        this.postMemLimit = postMemLimit;
    }

    public long getPreCpuLimit() {
        return preCpuLimit;
    }

    public void setPreCpuLimit(long preCpuLimit) {
        this.preCpuLimit = preCpuLimit;
    }

    public long getPreMemLimit() {
        return preMemLimit;
    }

    public void setPreMemLimit(long preMemLimit) {
        this.preMemLimit = preMemLimit;
    }

    public Map<String, Pod> getNewDeploy() {
        if(newDeploy == null){
            newDeploy = new HashMap<>();
        }
        return newDeploy;
    }

    public Map<String, Pod> getPodDiff() {
        if(podDiff == null){
            podDiff = new HashMap<>();
        }
        return podDiff;
    }

    public void setPodDiff(Map<String, Pod> podDiff) {
        this.podDiff = podDiff;
    }

    public List<String> getBuildChange() {
        return buildChange;
    }

    public void setBuildChange(List<String> buildChange) {
        this.buildChange = buildChange;
    }

    public List<String> getConfigChange() {
        return configChange;
    }

    public void setConfigChange(List<String> configChange) {
        this.configChange = configChange;
    }

    public List<String> getBothChange() {
        return bothChange;
    }

    public void setBothChange(List<String> bothChange) {
        this.bothChange = bothChange;
    }

    public List<String> getNoChange() {
        return noChange;
    }

    public void setNoChange(List<String> noChange) {
        this.noChange = noChange;
    }

    public List<String> getSoapEndpoint() {
        return soapEndpoint;
    }

    public void setSoapEndpoint(List<String> soapEndpoint) {
        this.soapEndpoint = soapEndpoint;
    }

    public List<String> getRestEndpoint() {
        return restEndpoint;
    }

    public void setRestEndpoint(List<String> restEndpoint) {
        this.restEndpoint = restEndpoint;
    }

    public void setPodPropChange(String module_name, String key,String value) {
        System.out.println("Properties Changed " +  module_name + " " +key+"="+value);
        Pod pod = getPod(module_name);

        pod.getConfigDiff().put(key,value);
    }

    public void setPodPropAdded(String module_name, String key,String value) {
        System.out.println("Properties Added " +  module_name + " " +key+"="+value);
        Pod pod = getPod(module_name);

        pod.getConfigAdded().put(key,value);
    }

    public void setPodPropDeleted(String module_name, String key,String value) {
        System.out.println("Properties Deleted " +  module_name + " " +key+"="+value);
        Pod pod = getPod(module_name);
        pod.getConfigDeleted().put(key,value);
    }

    public Table printStatistics(){
        String[][] data = new String[(4)][4];
        TableModel model = new ArrayTableModel(data);
        TableBuilder tableBuilder = new TableBuilder(model);
        data[0][0] = "Total Deploys";
        data[0][1] = (buildChange.size() + configChange.size() + bothChange.size() + noChange.size()) +"" ;

        data[0][2] = " New Deploys ";
        data[0][3] = newDeploy.size()+"";

        data[1][0] = "Config Change";
        data[1][1] = "Build Change" ;

        data[1][2] = "Both";
        data[1][3] = "None";

        data[2][0] = configChange.size()+"";
        data[2][1] = buildChange.size()+"" ;

        data[2][2] = bothChange.size()+"";
        data[2][3] = noChange.size()+"";

        return tableBuilder.addFullBorder(BorderStyle.fancy_light_double_dash).build();
    }

    public void printPropInfo() {
        for(Map.Entry<String, Pod> entry : podDiff.entrySet()){
            Pod pod =entry.getValue();
            System.out.println("\n---------------------------------------------------------");
            System.out.println("Pod Name : " + entry.getKey());
            if (pod.getConfigAdded().size() >0) {
                System.out.println("--------------Properties Added ----------------------\n");

                for(Map.Entry<String, String> pEntry : pod.getConfigAdded().entrySet()){
                    System.out.println(" " + pEntry);
                }
            }

            if (pod.getConfigDiff().size() >0) {
                System.out.println("\n--------------Properties Changed----------------------\n");

                for(Map.Entry<String, String> prop : pod.getConfigDiff().entrySet()){
                    System.out.println(" " + prop);
                }
            }

            if (pod.getConfigDeleted().size() >0) {
                System.out.println("\n--------------Properties Deleted ----------------------\n");

                for(Map.Entry<String, String> prop : pod.getConfigDeleted().entrySet()){
                    System.out.println(" " + prop);
                }
            }
        }
    }

    public Pod getPod(String module_name) {
        Pod pod = podDiff.get(module_name);
        if(pod == null){
            pod =new Pod();
            podDiff.put(module_name,pod);
        }
        return  pod;

    }

    public void calculateCpuMem() {
        for(Pod pod : podDiff.values()){
            {
                Holder holder = pod.getCpuLimit();
                if (holder.getNewVersion() != null) {
                    long newCpuLimit = Long.parseLong(holder.getNewVersion().replace("m", ""));
                    postCpuLimit = postCpuLimit + newCpuLimit;

                }
                if (holder.getPreviousVersion() != null) {
                    long prevCpuLimit = Long.parseLong(holder.getPreviousVersion().replace("m", ""));
                    preCpuLimit = preCpuLimit + prevCpuLimit;

                }
            }
            {
                Holder holder = pod.getMemLimit();


            if (holder.getNewVersion() != null) {
                long newMemLimit = Long.parseLong(getInMb(holder.getNewVersion()));
                postMemLimit = postMemLimit + newMemLimit;

            }
            if (holder.getPreviousVersion() != null) {
                long prevMemLimit = Long.parseLong(getInMb(holder.getPreviousVersion()));
                preMemLimit = preMemLimit + prevMemLimit;

            }
            }
        }

    }

    private String getInMb(String newVersion) {
        if(StringUtils.isEmpty(newVersion)){
            if(newVersion.contains("Mi")){
                return newVersion.replace("Mi","");
            }else if(newVersion.contains("Gi")){
                String newVal = newVersion.replace("Gi","");
                return (Long.parseLong(newVal) * 1024) + "";
            }
        }
        return "0";
    }
}
