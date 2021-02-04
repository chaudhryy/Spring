
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "exec",
    "timeoutSeconds",
    "periodSeconds",
    "successThreshold",
    "failureThreshold",
    "httpGet",
    "initialDelaySeconds"
})
public class ReadinessProbe {

    @JsonProperty("exec")
    private Exec exec;
    @JsonProperty("timeoutSeconds")
    private Long timeoutSeconds;
    @JsonProperty("periodSeconds")
    private Long periodSeconds;
    @JsonProperty("successThreshold")
    private Long successThreshold;
    @JsonProperty("failureThreshold")
    private Long failureThreshold;
    @JsonProperty("httpGet")
    private HttpGet httpGet;
    @JsonProperty("initialDelaySeconds")
    private Long initialDelaySeconds;

    @JsonProperty("exec")
    public Exec getExec() {
        return exec;
    }

    @JsonProperty("exec")
    public void setExec(Exec exec) {
        this.exec = exec;
    }

    public ReadinessProbe withExec(Exec exec) {
        this.exec = exec;
        return this;
    }

    @JsonProperty("timeoutSeconds")
    public Long getTimeoutSeconds() {
        return timeoutSeconds;
    }

    @JsonProperty("timeoutSeconds")
    public void setTimeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
    }

    public ReadinessProbe withTimeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
        return this;
    }

    @JsonProperty("periodSeconds")
    public Long getPeriodSeconds() {
        return periodSeconds;
    }

    @JsonProperty("periodSeconds")
    public void setPeriodSeconds(Long periodSeconds) {
        this.periodSeconds = periodSeconds;
    }

    public ReadinessProbe withPeriodSeconds(Long periodSeconds) {
        this.periodSeconds = periodSeconds;
        return this;
    }

    @JsonProperty("successThreshold")
    public Long getSuccessThreshold() {
        return successThreshold;
    }

    @JsonProperty("successThreshold")
    public void setSuccessThreshold(Long successThreshold) {
        this.successThreshold = successThreshold;
    }

    public ReadinessProbe withSuccessThreshold(Long successThreshold) {
        this.successThreshold = successThreshold;
        return this;
    }

    @JsonProperty("failureThreshold")
    public Long getFailureThreshold() {
        return failureThreshold;
    }

    @JsonProperty("failureThreshold")
    public void setFailureThreshold(Long failureThreshold) {
        this.failureThreshold = failureThreshold;
    }

    public ReadinessProbe withFailureThreshold(Long failureThreshold) {
        this.failureThreshold = failureThreshold;
        return this;
    }

    @JsonProperty("httpGet")
    public HttpGet getHttpGet() {
        return httpGet;
    }

    @JsonProperty("httpGet")
    public void setHttpGet(HttpGet httpGet) {
        this.httpGet = httpGet;
    }

    public ReadinessProbe withHttpGet(HttpGet httpGet) {
        this.httpGet = httpGet;
        return this;
    }

    @JsonProperty("initialDelaySeconds")
    public Long getInitialDelaySeconds() {
        return initialDelaySeconds;
    }

    @JsonProperty("initialDelaySeconds")
    public void setInitialDelaySeconds(Long initialDelaySeconds) {
        this.initialDelaySeconds = initialDelaySeconds;
    }

    public ReadinessProbe withInitialDelaySeconds(Long initialDelaySeconds) {
        this.initialDelaySeconds = initialDelaySeconds;
        return this;
    }

}
