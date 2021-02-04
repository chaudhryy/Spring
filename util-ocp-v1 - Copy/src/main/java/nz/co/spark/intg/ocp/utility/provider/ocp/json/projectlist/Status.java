
package nz.co.spark.intg.ocp.utility.provider.ocp.json.projectlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "phase"
})
public class Status {

    @JsonProperty("phase")
    private String phase;

    @JsonProperty("phase")
    public String getPhase() {
        return phase;
    }

    @JsonProperty("phase")
    public void setPhase(String phase) {
        this.phase = phase;
    }

    public Status withPhase(String phase) {
        this.phase = phase;
        return this;
    }

}
