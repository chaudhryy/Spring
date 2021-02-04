package nz.co.spark.intg.ocp.utility.model;

import java.util.*;

public class Pod {

    private boolean isRestAdded = false;

    private Map<String,String> configDiff = new LinkedHashMap<>();
    private Map<String,String> configAdded = new LinkedHashMap<>();
    private Map<String,String> configDeleted = new LinkedHashMap<>();

    public Map<String, String> getConfigAdded() {
        return configAdded;
    }

    public boolean isRestAdded() {
        return isRestAdded;
    }

    public void setRestAdded(boolean restAdded) {
        isRestAdded = restAdded;
    }

    public Holder getReplicas() {
        return replicas;
    }

    public void setReplicas(Holder replicas) {
        this.replicas = replicas;
    }

    public Map<String, String> getConfigDeleted() {
        return configDeleted;
    }


    public Holder getHeap() {
        return heap;
    }

    public void setHeap(Holder heap) {
        this.heap = heap;
    }

    private Holder heap = new Holder();

    private Holder build = new Holder();

    private Holder release = new Holder();

    private Holder cpuRequest = new Holder();

    private Holder cpuLimit = new Holder();

    private Holder memRequest= new Holder();

    private Holder memLimit = new Holder();

    private Holder replicas = new Holder();

    public void setConfigAdded(Map<String, String> configAdded) {
        this.configAdded = configAdded;
    }

    public void setConfigDeleted(Map<String, String> configDeleted) {
        this.configDeleted = configDeleted;
    }

    public List<String> getEnvVariablesAdded() {
        return envVariablesAdded;
    }

    public void setEnvVariablesAdded(List<String> envVariablesAdded) {
        this.envVariablesAdded = envVariablesAdded;
    }

    public List<String> getEnvVariablesDeleted() {
        return envVariablesDeleted;
    }

    public void setEnvVariablesDeleted(List<String> envVariablesDeleted) {
        this.envVariablesDeleted = envVariablesDeleted;
    }

    public List<String> getEnvVariablesDiff() {
        return envVariablesDiff;
    }

    public void setEnvVariablesDiff(List<String> envVariablesDiff) {
        this.envVariablesDiff = envVariablesDiff;
    }

    private List<String> envVariablesAdded = new LinkedList<>();
    private List<String> envVariablesDeleted = new LinkedList<>();
    private List<String> envVariablesDiff = new LinkedList<>();

    private Map<String,String> soapListDiff = new LinkedHashMap<>();
    private Map<String,String> soapListAdded = new LinkedHashMap<>();
    private Map<String,String> soapListDeleted = new LinkedHashMap<>();

    private Map<String,String> restListDiff = new LinkedHashMap<>();
    private Map<String,String> restListAdded = new LinkedHashMap<>();
    private Map<String,String> restListDeleted = new LinkedHashMap<>();

    private String SoapHost;

    private String restHost;

    public String getSoapHost() {
        return SoapHost;
    }

    public void setSoapHost(String soapHost) {
        SoapHost = soapHost;
    }

    public String getRestHost() {
        return restHost;
    }

    public void setRestHost(String restHost) {
        this.restHost = restHost;
    }

    public Map<String, String> getConfigDiff() {
        return configDiff;
    }

    public void setConfigDiff(Map<String, String> configDiff) {
        this.configDiff = configDiff;
    }

    public Holder getBuild() {
        return build;
    }

    public void setBuild(Holder build) {
        this.build = build;
    }

    public Holder getRelease() {
        return release;
    }

    public void setRelease(Holder release) {
        this.release = release;
    }

    public Holder getCpuRequest() {
        return cpuRequest;
    }

    public void setCpuRequest(Holder cpuRequest) {
        this.cpuRequest = cpuRequest;
    }

    public Holder getCpuLimit() {
        return cpuLimit;
    }

    public void setCpuLimit(Holder cpuLimit) {
        this.cpuLimit = cpuLimit;
    }

    public Holder getMemRequest() {
        return memRequest;
    }

    public void setMemRequest(Holder memRequest) {
        this.memRequest = memRequest;
    }

    public Holder getMemLimit() {
        return memLimit;
    }

    public void setMemLimit(Holder memLimit) {
        this.memLimit = memLimit;
    }

    public Map<String, String> getSoapListDiff() {
        return soapListDiff;
    }

    public void setSoapListDiff(Map<String, String> soapListDiff) {
        this.soapListDiff = soapListDiff;
    }

    public Map<String, String> getSoapListAdded() {
        return soapListAdded;
    }

    public void setSoapListAdded(Map<String, String> soapListAdded) {
        this.soapListAdded = soapListAdded;
    }

    public Map<String, String> getSoapListDeleted() {
        return soapListDeleted;
    }

    public void setSoapListDeleted(Map<String, String> soapListDeleted) {
        this.soapListDeleted = soapListDeleted;
    }

    public Map<String, String> getRestListDiff() {
        return restListDiff;
    }

    public void setRestListDiff(Map<String, String> restListDiff) {
        this.restListDiff = restListDiff;
    }

    public Map<String, String> getRestListAdded() {
        return restListAdded;
    }

    public void setRestListAdded(Map<String, String> restListAdded) {
        this.restListAdded = restListAdded;
    }

    public Map<String, String> getRestListDeleted() {
        return restListDeleted;
    }

    public void setRestListDeleted(Map<String, String> restListDeleted) {
        this.restListDeleted = restListDeleted;
    }
}
