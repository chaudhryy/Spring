
package nz.co.spark.intg.ocp.utility.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpGet",
    "initialDelaySeconds",
    "timeoutSeconds",
    "periodSeconds",
    "successThreshold",
    "failureThreshold"
})
public class LivenessProbe {

    @JsonProperty("httpGet")
    private HttpGet httpGet;
    @JsonProperty("initialDelaySeconds")
    private Long initialDelaySeconds;
    @JsonProperty("timeoutSeconds")
    private Long timeoutSeconds;
    @JsonProperty("periodSeconds")
    private Long periodSeconds;
    @JsonProperty("successThreshold")
    private Long successThreshold;
    @JsonProperty("failureThreshold")
    private Long failureThreshold;

    @JsonProperty("httpGet")
    public HttpGet getHttpGet() {
        return httpGet;
    }

    @JsonProperty("httpGet")
    public void setHttpGet(HttpGet httpGet) {
        this.httpGet = httpGet;
    }

    public LivenessProbe withHttpGet(HttpGet httpGet) {
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

    public LivenessProbe withInitialDelaySeconds(Long initialDelaySeconds) {
        this.initialDelaySeconds = initialDelaySeconds;
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

    public LivenessProbe withTimeoutSeconds(Long timeoutSeconds) {
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

    public LivenessProbe withPeriodSeconds(Long periodSeconds) {
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

    public LivenessProbe withSuccessThreshold(Long successThreshold) {
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

    public LivenessProbe withFailureThreshold(Long failureThreshold) {
        this.failureThreshold = failureThreshold;
        return this;
    }

}
