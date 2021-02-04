
package nz.co.spark.intg.ocp.utility.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "updatePeriodSeconds",
    "intervalSeconds",
    "timeoutSeconds",
    "maxUnavailable",
    "maxSurge"
})
public class RollingParams {

    @JsonProperty("updatePeriodSeconds")
    private Long updatePeriodSeconds;
    @JsonProperty("intervalSeconds")
    private Long intervalSeconds;
    @JsonProperty("timeoutSeconds")
    private Long timeoutSeconds;
    @JsonProperty("maxUnavailable")
    private String maxUnavailable;
    @JsonProperty("maxSurge")
    private String maxSurge;

    @JsonProperty("updatePeriodSeconds")
    public Long getUpdatePeriodSeconds() {
        return updatePeriodSeconds;
    }

    @JsonProperty("updatePeriodSeconds")
    public void setUpdatePeriodSeconds(Long updatePeriodSeconds) {
        this.updatePeriodSeconds = updatePeriodSeconds;
    }

    public RollingParams withUpdatePeriodSeconds(Long updatePeriodSeconds) {
        this.updatePeriodSeconds = updatePeriodSeconds;
        return this;
    }

    @JsonProperty("intervalSeconds")
    public Long getIntervalSeconds() {
        return intervalSeconds;
    }

    @JsonProperty("intervalSeconds")
    public void setIntervalSeconds(Long intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
    }

    public RollingParams withIntervalSeconds(Long intervalSeconds) {
        this.intervalSeconds = intervalSeconds;
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

    public RollingParams withTimeoutSeconds(Long timeoutSeconds) {
        this.timeoutSeconds = timeoutSeconds;
        return this;
    }

    @JsonProperty("maxUnavailable")
    public String getMaxUnavailable() {
        return maxUnavailable;
    }

    @JsonProperty("maxUnavailable")
    public void setMaxUnavailable(String maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
    }

    public RollingParams withMaxUnavailable(String maxUnavailable) {
        this.maxUnavailable = maxUnavailable;
        return this;
    }

    @JsonProperty("maxSurge")
    public String getMaxSurge() {
        return maxSurge;
    }

    @JsonProperty("maxSurge")
    public void setMaxSurge(String maxSurge) {
        this.maxSurge = maxSurge;
    }

    public RollingParams withMaxSurge(String maxSurge) {
        this.maxSurge = maxSurge;
        return this;
    }

}
