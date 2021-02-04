package com.yash.cache;

import com.yash.model.Pod;
import org.springframework.shell.table.*;
import org.springframework.stereotype.Component;

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

    public void setPodPropChange(String module_name, String prop) {
        System.out.println("Properties Changed " +  module_name + " " +prop);
        Pod pod = getPod(module_name);

        pod.getConfigDiff().add(prop);
    }

    public void setPodPropAdded(String module_name, String prop) {
        System.out.println("Properties Added " +  module_name + " " +prop);
        Pod pod = getPod(module_name);

        pod.getConfigAdded().add(prop);
    }

    public void setPodPropDeleted(String module_name, String prop) {
        System.out.println("Properties Deleted " +  module_name + " " +prop);
        Pod pod = getPod(module_name);
        pod.getConfigDeleted().add(prop);
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

                for(String prop : pod.getConfigAdded()){
                    System.out.println(" " + prop);
                }
            }

            if (pod.getConfigDiff().size() >0) {
                System.out.println("\n--------------Properties Changed----------------------\n");

                for(String prop : pod.getConfigDiff()){
                    System.out.println(" " + prop);
                }
            }

            if (pod.getConfigDeleted().size() >0) {
                System.out.println("\n--------------Properties Deleted ----------------------\n");

                for(String prop : pod.getConfigDeleted()){
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
}
