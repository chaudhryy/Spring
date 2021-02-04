
package nz.co.spark.intg.ocp.utility.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "rollingParams",
    "resources",
    "activeDeadlineSeconds"
})
public class Strategy {

    @JsonProperty("type")
    private String type;
    @JsonProperty("rollingParams")
    private RollingParams rollingParams;
    @JsonProperty("resources")
    private Resources resources;
    @JsonProperty("activeDeadlineSeconds")
    private Long activeDeadlineSeconds;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Strategy withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("rollingParams")
    public RollingParams getRollingParams() {
        return rollingParams;
    }

    @JsonProperty("rollingParams")
    public void setRollingParams(RollingParams rollingParams) {
        this.rollingParams = rollingParams;
    }

    public Strategy withRollingParams(RollingParams rollingParams) {
        this.rollingParams = rollingParams;
        return this;
    }

    @JsonProperty("resources")
    public Resources getResources() {
        return resources;
    }

    @JsonProperty("resources")
    public void setResources(Resources resources) {
        this.resources = resources;
    }

    public Strategy withResources(Resources resources) {
        this.resources = resources;
        return this;
    }

    @JsonProperty("activeDeadlineSeconds")
    public Long getActiveDeadlineSeconds() {
        return activeDeadlineSeconds;
    }

    @JsonProperty("activeDeadlineSeconds")
    public void setActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
    }

    public Strategy withActiveDeadlineSeconds(Long activeDeadlineSeconds) {
        this.activeDeadlineSeconds = activeDeadlineSeconds;
        return this;
    }

}
