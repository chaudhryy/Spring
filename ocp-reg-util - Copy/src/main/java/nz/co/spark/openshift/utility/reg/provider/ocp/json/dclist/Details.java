
package nz.co.spark.openshift.utility.reg.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "message",
    "causes"
})
public class Details {

    @JsonProperty("message")
    private String message;
    @JsonProperty("causes")
    private List<Cause> causes = null;

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
    }

    public Details withMessage(String message) {
        this.message = message;
        return this;
    }

    @JsonProperty("causes")
    public List<Cause> getCauses() {
        return causes;
    }

    @JsonProperty("causes")
    public void setCauses(List<Cause> causes) {
        this.causes = causes;
    }

    public Details withCauses(List<Cause> causes) {
        this.causes = causes;
        return this;
    }

}
