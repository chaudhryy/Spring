
package nz.co.spark.openshift.utility.fuse.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "limits",
    "requests"
})
public class Resources_ {

    @JsonProperty("limits")
    private Limits limits;
    @JsonProperty("requests")
    private Requests requests;

    @JsonProperty("limits")
    public Limits getLimits() {
        return limits;
    }

    @JsonProperty("limits")
    public void setLimits(Limits limits) {
        this.limits = limits;
    }

    public Resources_ withLimits(Limits limits) {
        this.limits = limits;
        return this;
    }

    @JsonProperty("requests")
    public Requests getRequests() {
        return requests;
    }

    @JsonProperty("requests")
    public void setRequests(Requests requests) {
        this.requests = requests;
    }

    public Resources_ withRequests(Requests requests) {
        this.requests = requests;
        return this;
    }

}
