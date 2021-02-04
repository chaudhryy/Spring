
package nz.co.spark.intg.ocp.utility.provider.ocp.json.projectlist;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "finalizers"
})
public class Spec {

    @JsonProperty("finalizers")
    private List<String> finalizers = null;

    @JsonProperty("finalizers")
    public List<String> getFinalizers() {
        return finalizers;
    }

    @JsonProperty("finalizers")
    public void setFinalizers(List<String> finalizers) {
        this.finalizers = finalizers;
    }

    public Spec withFinalizers(List<String> finalizers) {
        this.finalizers = finalizers;
        return this;
    }

}
