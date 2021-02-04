
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "openshift.io/scc",
    "openshift.io/deployment-config.latest-version",
    "openshift.io/deployment-config.name",
    "openshift.io/deployment.name",
    "openshift.io/generated-by"
})
public class Annotations {

    @JsonProperty("openshift.io/scc")
    private String openshiftIoScc;
    @JsonProperty("openshift.io/deployment-config.latest-version")
    private String openshiftIoDeploymentConfigLatestVersion;
    @JsonProperty("openshift.io/deployment-config.name")
    private String openshiftIoDeploymentConfigName;
    @JsonProperty("openshift.io/deployment.name")
    private String openshiftIoDeploymentName;
    @JsonProperty("openshift.io/generated-by")
    private String openshiftIoGeneratedBy;

    @JsonProperty("openshift.io/scc")
    public String getOpenshiftIoScc() {
        return openshiftIoScc;
    }

    @JsonProperty("openshift.io/scc")
    public void setOpenshiftIoScc(String openshiftIoScc) {
        this.openshiftIoScc = openshiftIoScc;
    }

    public Annotations withOpenshiftIoScc(String openshiftIoScc) {
        this.openshiftIoScc = openshiftIoScc;
        return this;
    }

    @JsonProperty("openshift.io/deployment-config.latest-version")
    public String getOpenshiftIoDeploymentConfigLatestVersion() {
        return openshiftIoDeploymentConfigLatestVersion;
    }

    @JsonProperty("openshift.io/deployment-config.latest-version")
    public void setOpenshiftIoDeploymentConfigLatestVersion(String openshiftIoDeploymentConfigLatestVersion) {
        this.openshiftIoDeploymentConfigLatestVersion = openshiftIoDeploymentConfigLatestVersion;
    }

    public Annotations withOpenshiftIoDeploymentConfigLatestVersion(String openshiftIoDeploymentConfigLatestVersion) {
        this.openshiftIoDeploymentConfigLatestVersion = openshiftIoDeploymentConfigLatestVersion;
        return this;
    }

    @JsonProperty("openshift.io/deployment-config.name")
    public String getOpenshiftIoDeploymentConfigName() {
        return openshiftIoDeploymentConfigName;
    }

    @JsonProperty("openshift.io/deployment-config.name")
    public void setOpenshiftIoDeploymentConfigName(String openshiftIoDeploymentConfigName) {
        this.openshiftIoDeploymentConfigName = openshiftIoDeploymentConfigName;
    }

    public Annotations withOpenshiftIoDeploymentConfigName(String openshiftIoDeploymentConfigName) {
        this.openshiftIoDeploymentConfigName = openshiftIoDeploymentConfigName;
        return this;
    }

    @JsonProperty("openshift.io/deployment.name")
    public String getOpenshiftIoDeploymentName() {
        return openshiftIoDeploymentName;
    }

    @JsonProperty("openshift.io/deployment.name")
    public void setOpenshiftIoDeploymentName(String openshiftIoDeploymentName) {
        this.openshiftIoDeploymentName = openshiftIoDeploymentName;
    }

    public Annotations withOpenshiftIoDeploymentName(String openshiftIoDeploymentName) {
        this.openshiftIoDeploymentName = openshiftIoDeploymentName;
        return this;
    }

    @JsonProperty("openshift.io/generated-by")
    public String getOpenshiftIoGeneratedBy() {
        return openshiftIoGeneratedBy;
    }

    @JsonProperty("openshift.io/generated-by")
    public void setOpenshiftIoGeneratedBy(String openshiftIoGeneratedBy) {
        this.openshiftIoGeneratedBy = openshiftIoGeneratedBy;
    }

    public Annotations withOpenshiftIoGeneratedBy(String openshiftIoGeneratedBy) {
        this.openshiftIoGeneratedBy = openshiftIoGeneratedBy;
        return this;
    }

}
