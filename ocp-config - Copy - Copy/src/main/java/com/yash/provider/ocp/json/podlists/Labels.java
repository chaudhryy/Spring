
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app",
    "application",
    "controller-revision-hash",
    "deploymentConfig",
    "statefulset.kubernetes.io/pod-name",
    "deployment",
    "deploymentconfig"
})
public class Labels {

    @JsonProperty("app")
    private String app;
    @JsonProperty("application")
    private String application;
    @JsonProperty("controller-revision-hash")
    private String controllerRevisionHash;
    @JsonProperty("deploymentConfig")
    private String deploymentConfig;
    @JsonProperty("statefulset.kubernetes.io/pod-name")
    private String statefulsetKubernetesIoPodName;
    @JsonProperty("deployment")
    private String deployment;
    @JsonProperty("deploymentconfig")
    private String deploymentconfig;

    @JsonProperty("app")
    public String getApp() {
        return app;
    }

    @JsonProperty("app")
    public void setApp(String app) {
        this.app = app;
    }

    public Labels withApp(String app) {
        this.app = app;
        return this;
    }

    @JsonProperty("application")
    public String getApplication() {
        return application;
    }

    @JsonProperty("application")
    public void setApplication(String application) {
        this.application = application;
    }

    public Labels withApplication(String application) {
        this.application = application;
        return this;
    }

    @JsonProperty("controller-revision-hash")
    public String getControllerRevisionHash() {
        return controllerRevisionHash;
    }

    @JsonProperty("controller-revision-hash")
    public void setControllerRevisionHash(String controllerRevisionHash) {
        this.controllerRevisionHash = controllerRevisionHash;
    }

    public Labels withControllerRevisionHash(String controllerRevisionHash) {
        this.controllerRevisionHash = controllerRevisionHash;
        return this;
    }

    @JsonProperty("deploymentConfig")
    public String getDeploymentConfig() {
        return deploymentConfig;
    }

    @JsonProperty("deploymentConfig")
    public void setDeploymentConfig(String deploymentConfig) {
        this.deploymentConfig = deploymentConfig;
    }

    public Labels withDeploymentConfig(String deploymentConfig) {
        this.deploymentConfig = deploymentConfig;
        return this;
    }

    @JsonProperty("statefulset.kubernetes.io/pod-name")
    public String getStatefulsetKubernetesIoPodName() {
        return statefulsetKubernetesIoPodName;
    }

    @JsonProperty("statefulset.kubernetes.io/pod-name")
    public void setStatefulsetKubernetesIoPodName(String statefulsetKubernetesIoPodName) {
        this.statefulsetKubernetesIoPodName = statefulsetKubernetesIoPodName;
    }

    public Labels withStatefulsetKubernetesIoPodName(String statefulsetKubernetesIoPodName) {
        this.statefulsetKubernetesIoPodName = statefulsetKubernetesIoPodName;
        return this;
    }

    @JsonProperty("deployment")
    public String getDeployment() {
        return deployment;
    }

    @JsonProperty("deployment")
    public void setDeployment(String deployment) {
        this.deployment = deployment;
    }

    public Labels withDeployment(String deployment) {
        this.deployment = deployment;
        return this;
    }

    @JsonProperty("deploymentconfig")
    public String getDeploymentconfig() {
        return deploymentconfig;
    }

    @JsonProperty("deploymentconfig")
    public void setDeploymentconfig(String deploymentconfig) {
        this.deploymentconfig = deploymentconfig;
    }

    public Labels withDeploymentconfig(String deploymentconfig) {
        this.deploymentconfig = deploymentconfig;
        return this;
    }

}
