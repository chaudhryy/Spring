
package com.yash.provider.ocp.json.dclist;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "image",
    "ports",
    "env",
    "resources",
    "volumeMounts",
    "livenessProbe",
    "readinessProbe",
    "terminationMessagePath",
    "terminationMessagePolicy",
    "imagePullPolicy"
})
public class Container {

    @JsonProperty("name")
    private String name;
    @JsonProperty("image")
    private String image;
    @JsonProperty("ports")
    private List<Port> ports = null;
    @JsonProperty("env")
    private List<Env> env = null;
    @JsonProperty("resources")
    private Resources_ resources;
    @JsonProperty("volumeMounts")
    private List<VolumeMount> volumeMounts = null;
    @JsonProperty("livenessProbe")
    private LivenessProbe livenessProbe;
    @JsonProperty("readinessProbe")
    private ReadinessProbe readinessProbe;
    @JsonProperty("terminationMessagePath")
    private String terminationMessagePath;
    @JsonProperty("terminationMessagePolicy")
    private String terminationMessagePolicy;
    @JsonProperty("imagePullPolicy")
    private String imagePullPolicy;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Container withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    public Container withImage(String image) {
        this.image = image;
        return this;
    }

    @JsonProperty("ports")
    public List<Port> getPorts() {
        return ports;
    }

    @JsonProperty("ports")
    public void setPorts(List<Port> ports) {
        this.ports = ports;
    }

    public Container withPorts(List<Port> ports) {
        this.ports = ports;
        return this;
    }

    @JsonProperty("env")
    public List<Env> getEnv() {
        return env;
    }

    @JsonProperty("env")
    public void setEnv(List<Env> env) {
        this.env = env;
    }

    public Container withEnv(List<Env> env) {
        this.env = env;
        return this;
    }

    @JsonProperty("resources")
    public Resources_ getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(Resources_ resources) {
        this.resources = resources;
    }

    public Container withResources(Resources_ resources) {
        this.resources = resources;
        return this;
    }

    @JsonProperty("volumeMounts")
    public List<VolumeMount> getVolumeMounts() {
        return volumeMounts;
    }

    @JsonProperty("volumeMounts")
    public void setVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
    }

    public Container withVolumeMounts(List<VolumeMount> volumeMounts) {
        this.volumeMounts = volumeMounts;
        return this;
    }

    @JsonProperty("livenessProbe")
    public LivenessProbe getLivenessProbe() {
        return livenessProbe;
    }

    @JsonProperty("livenessProbe")
    public void setLivenessProbe(LivenessProbe livenessProbe) {
        this.livenessProbe = livenessProbe;
    }

    public Container withLivenessProbe(LivenessProbe livenessProbe) {
        this.livenessProbe = livenessProbe;
        return this;
    }

    @JsonProperty("readinessProbe")
    public ReadinessProbe getReadinessProbe() {
        return readinessProbe;
    }

    @JsonProperty("readinessProbe")
    public void setReadinessProbe(ReadinessProbe readinessProbe) {
        this.readinessProbe = readinessProbe;
    }

    public Container withReadinessProbe(ReadinessProbe readinessProbe) {
        this.readinessProbe = readinessProbe;
        return this;
    }

    @JsonProperty("terminationMessagePath")
    public String getTerminationMessagePath() {
        return terminationMessagePath;
    }

    @JsonProperty("terminationMessagePath")
    public void setTerminationMessagePath(String terminationMessagePath) {
        this.terminationMessagePath = terminationMessagePath;
    }

    public Container withTerminationMessagePath(String terminationMessagePath) {
        this.terminationMessagePath = terminationMessagePath;
        return this;
    }

    @JsonProperty("terminationMessagePolicy")
    public String getTerminationMessagePolicy() {
        return terminationMessagePolicy;
    }

    @JsonProperty("terminationMessagePolicy")
    public void setTerminationMessagePolicy(String terminationMessagePolicy) {
        this.terminationMessagePolicy = terminationMessagePolicy;
    }

    public Container withTerminationMessagePolicy(String terminationMessagePolicy) {
        this.terminationMessagePolicy = terminationMessagePolicy;
        return this;
    }

    @JsonProperty("imagePullPolicy")
    public String getImagePullPolicy() {
        return imagePullPolicy;
    }

    @JsonProperty("imagePullPolicy")
    public void setImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
    }

    public Container withImagePullPolicy(String imagePullPolicy) {
        this.imagePullPolicy = imagePullPolicy;
        return this;
    }

}
