
package nz.co.spark.openshift.utility.fuse.provider.ocp.json.registry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "creationTimestamp"
})
public class Metadata__ {

    @JsonProperty("name")
    private String name;
    @JsonProperty("creationTimestamp")
    private Object creationTimestamp;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Metadata__ withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("creationTimestamp")
    public Object getCreationTimestamp() {
        return creationTimestamp;
    }

    @JsonProperty("creationTimestamp")
    public void setCreationTimestamp(Object creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public Metadata__ withCreationTimestamp(Object creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
        return this;
    }

}
