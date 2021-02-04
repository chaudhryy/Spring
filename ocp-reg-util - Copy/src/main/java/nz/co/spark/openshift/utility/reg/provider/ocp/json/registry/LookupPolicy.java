
package nz.co.spark.openshift.utility.reg.provider.ocp.json.registry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "local"
})
public class LookupPolicy {

    @JsonProperty("local")
    private Boolean local;

    @JsonProperty("local")
    public Boolean getLocal() {
        return local;
    }

    @JsonProperty("local")
    public void setLocal(Boolean local) {
        this.local = local;
    }

    public LookupPolicy withLocal(Boolean local) {
        this.local = local;
        return this;
    }

}
