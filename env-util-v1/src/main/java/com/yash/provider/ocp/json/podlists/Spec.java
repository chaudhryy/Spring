
package com.yash.provider.ocp.json.podlists;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "volumes",
    "containers",
    "restartPolicy",
    "terminationGracePeriodSeconds",
    "dnsPolicy",
    "nodeSelector",
    "serviceAccountName",
    "serviceAccount",
    "nodeName",
    "securityContext",
    "imagePullSecrets",
    "hostname",
    "subdomain",
    "schedulerName",
    "priority",
    "tolerations"
})
public class Spec {

    @JsonProperty("volumes")
    private List<Volume> volumes = null;
    @JsonProperty("containers")
    private List<Container> containers = null;
    @JsonProperty("restartPolicy")
    private String restartPolicy;
    @JsonProperty("terminationGracePeriodSeconds")
    private Long terminationGracePeriodSeconds;
    @JsonProperty("dnsPolicy")
    private String dnsPolicy;
    @JsonProperty("nodeSelector")
    private NodeSelector nodeSelector;
    @JsonProperty("serviceAccountName")
    private String serviceAccountName;
    @JsonProperty("serviceAccount")
    private String serviceAccount;
    @JsonProperty("nodeName")
    private String nodeName;
    @JsonProperty("securityContext")
    private SecurityContext_ securityContext;
    @JsonProperty("imagePullSecrets")
    private List<ImagePullSecret> imagePullSecrets = null;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("subdomain")
    private String subdomain;
    @JsonProperty("schedulerName")
    private String schedulerName;
    @JsonProperty("priority")
    private Long priority;
    @JsonProperty("tolerations")
    private List<Toleration> tolerations = null;

    @JsonProperty("volumes")
    public List<Volume> getVolumes() {
        return volumes;
    }

    @JsonProperty("volumes")
    public void setVolumes(List<Volume> volumes) {
        this.volumes = volumes;
    }

    public Spec withVolumes(List<Volume> volumes) {
        this.volumes = volumes;
        return this;
    }

    @JsonProperty("containers")
    public List<Container> getContainers() {
        return containers;
    }

    @JsonProperty("containers")
    public void setContainers(List<Container> containers) {
        this.containers = containers;
    }

    public Spec withContainers(List<Container> containers) {
        this.containers = containers;
        return this;
    }

    @JsonProperty("restartPolicy")
    public String getRestartPolicy() {
        return restartPolicy;
    }

    @JsonProperty("restartPolicy")
    public void setRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
    }

    public Spec withRestartPolicy(String restartPolicy) {
        this.restartPolicy = restartPolicy;
        return this;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public Long getTerminationGracePeriodSeconds() {
        return terminationGracePeriodSeconds;
    }

    @JsonProperty("terminationGracePeriodSeconds")
    public void setTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
    }

    public Spec withTerminationGracePeriodSeconds(Long terminationGracePeriodSeconds) {
        this.terminationGracePeriodSeconds = terminationGracePeriodSeconds;
        return this;
    }

    @JsonProperty("dnsPolicy")
    public String getDnsPolicy() {
        return dnsPolicy;
    }

    @JsonProperty("dnsPolicy")
    public void setDnsPolicy(String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
    }

    public Spec withDnsPolicy(String dnsPolicy) {
        this.dnsPolicy = dnsPolicy;
        return this;
    }

    @JsonProperty("nodeSelector")
    public NodeSelector getNodeSelector() {
        return nodeSelector;
    }

    @JsonProperty("nodeSelector")
    public void setNodeSelector(NodeSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
    }

    public Spec withNodeSelector(NodeSelector nodeSelector) {
        this.nodeSelector = nodeSelector;
        return this;
    }

    @JsonProperty("serviceAccountName")
    public String getServiceAccountName() {
        return serviceAccountName;
    }

    @JsonProperty("serviceAccountName")
    public void setServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
    }

    public Spec withServiceAccountName(String serviceAccountName) {
        this.serviceAccountName = serviceAccountName;
        return this;
    }

    @JsonProperty("serviceAccount")
    public String getServiceAccount() {
        return serviceAccount;
    }

    @JsonProperty("serviceAccount")
    public void setServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
    }

    public Spec withServiceAccount(String serviceAccount) {
        this.serviceAccount = serviceAccount;
        return this;
    }

    @JsonProperty("nodeName")
    public String getNodeName() {
        return nodeName;
    }

    @JsonProperty("nodeName")
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Spec withNodeName(String nodeName) {
        this.nodeName = nodeName;
        return this;
    }

    @JsonProperty("securityContext")
    public SecurityContext_ getSecurityContext() {
        return securityContext;
    }

    @JsonProperty("securityContext")
    public void setSecurityContext(SecurityContext_ securityContext) {
        this.securityContext = securityContext;
    }

    public Spec withSecurityContext(SecurityContext_ securityContext) {
        this.securityContext = securityContext;
        return this;
    }

    @JsonProperty("imagePullSecrets")
    public List<ImagePullSecret> getImagePullSecrets() {
        return imagePullSecrets;
    }

    @JsonProperty("imagePullSecrets")
    public void setImagePullSecrets(List<ImagePullSecret> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
    }

    public Spec withImagePullSecrets(List<ImagePullSecret> imagePullSecrets) {
        this.imagePullSecrets = imagePullSecrets;
        return this;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("hostname")
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Spec withHostname(String hostname) {
        this.hostname = hostname;
        return this;
    }

    @JsonProperty("subdomain")
    public String getSubdomain() {
        return subdomain;
    }

    @JsonProperty("subdomain")
    public void setSubdomain(String subdomain) {
        this.subdomain = subdomain;
    }

    public Spec withSubdomain(String subdomain) {
        this.subdomain = subdomain;
        return this;
    }

    @JsonProperty("schedulerName")
    public String getSchedulerName() {
        return schedulerName;
    }

    @JsonProperty("schedulerName")
    public void setSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
    }

    public Spec withSchedulerName(String schedulerName) {
        this.schedulerName = schedulerName;
        return this;
    }

    @JsonProperty("priority")
    public Long getPriority() {
        return priority;
    }

    @JsonProperty("priority")
    public void setPriority(Long priority) {
        this.priority = priority;
    }

    public Spec withPriority(Long priority) {
        this.priority = priority;
        return this;
    }

    @JsonProperty("tolerations")
    public List<Toleration> getTolerations() {
        return tolerations;
    }

    @JsonProperty("tolerations")
    public void setTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
    }

    public Spec withTolerations(List<Toleration> tolerations) {
        this.tolerations = tolerations;
        return this;
    }

}
