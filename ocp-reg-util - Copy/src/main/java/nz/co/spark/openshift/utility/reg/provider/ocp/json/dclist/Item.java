
package nz.co.spark.openshift.utility.reg.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "spec",
    "status"
})
public class Item {

    @JsonProperty("metadata")
    private Metadata_ metadata;
    @JsonProperty("spec")
    private Spec spec;
    @JsonProperty("status")
    private Status status;

    @JsonProperty("metadata")
    public Metadata_ getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata_ metadata) {
        this.metadata = metadata;
    }

    public Item withMetadata(Metadata_ metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonProperty("spec")
    public Spec getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(Spec spec) {
        this.spec = spec;
    }

    public Item withSpec(Spec spec) {
        this.spec = spec;
        return this;
    }

    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    public Item withStatus(Status status) {
        this.status = status;
        return this;
    }

}
