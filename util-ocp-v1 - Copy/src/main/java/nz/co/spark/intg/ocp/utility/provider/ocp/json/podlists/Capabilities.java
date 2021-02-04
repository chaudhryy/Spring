
package nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "drop"
})
public class Capabilities {

    @JsonProperty("drop")
    private List<String> drop = null;

    @JsonProperty("drop")
    public List<String> getDrop() {
        return drop;
    }

    @JsonProperty("drop")
    public void setDrop(List<String> drop) {
        this.drop = drop;
    }

    public Capabilities withDrop(List<String> drop) {
        this.drop = drop;
        return this;
    }

}
