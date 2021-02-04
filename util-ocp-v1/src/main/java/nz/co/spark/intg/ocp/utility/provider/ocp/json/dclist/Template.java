
package nz.co.spark.intg.ocp.utility.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "spec"
})
public class Template {

    @JsonProperty("metadata")
    private Metadata__ metadata;
    @JsonProperty("spec")
    private Spec_ spec;

    @JsonProperty("metadata")
    public Metadata__ getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata__ metadata) {
        this.metadata = metadata;
    }

    public Template withMetadata(Metadata__ metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonProperty("spec")
    public Spec_ getSpec() {
        return spec;
    }

    @JsonProperty("spec")
    public void setSpec(Spec_ spec) {
        this.spec = spec;
    }

    public Template withSpec(Spec_ spec) {
        this.spec = spec;
        return this;
    }

}
