package com.yash.model;

import java.util.LinkedList;
import java.util.List;

public class Pod {

    private boolean isRestAdded = false;

    private List<String> configDiff = new LinkedList<>();
    private List<String> configAdded = new LinkedList<>();
    private List<String> configDeleted = new LinkedList<>();

    public List<String> getConfigAdded() {
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

    public List<String> getConfigDeleted() {
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

    public void setConfigAdded(List<String> configAdded) {
        this.configAdded = configAdded;
    }

    public void setConfigDeleted(List<String> configDeleted) {
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

    private List<String> soapListDiff = new LinkedList<>();
    private List<String> soapListAdded = new LinkedList<>();
    private List<String> soapListDeleted = new LinkedList<>();

    private List<String> restListDiff = new LinkedList<>();
    private List<String> restListAdded = new LinkedList<>();
    private List<String> restListDeleted = new LinkedList<>();

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

    public List<String> getConfigDiff() {
        return configDiff;
    }

    public void setConfigDiff(List<String> configDiff) {
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

    public List<String> getSoapListDiff() {
        return soapListDiff;
    }

    public void setSoapListDiff(List<String> soapListDiff) {
        this.soapListDiff = soapListDiff;
    }

    public List<String> getSoapListAdded() {
        return soapListAdded;
    }

    public void setSoapListAdded(List<String> soapListAdded) {
        this.soapListAdded = soapListAdded;
    }

    public List<String> getSoapListDeleted() {
        return soapListDeleted;
    }

    public void setSoapListDeleted(List<String> soapListDeleted) {
        this.soapListDeleted = soapListDeleted;
    }

    public List<String> getRestListDiff() {
        return restListDiff;
    }

    public void setRestListDiff(List<String> restListDiff) {
        this.restListDiff = restListDiff;
    }

    public List<String> getRestListAdded() {
        return restListAdded;
    }

    public void setRestListAdded(List<String> restListAdded) {
        this.restListAdded = restListAdded;
    }

    public List<String> getRestListDeleted() {
        return restListDeleted;
    }

    public void setRestListDeleted(List<String> restListDeleted) {
        this.restListDeleted = restListDeleted;
    }
}
