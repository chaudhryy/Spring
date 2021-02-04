
package nz.co.spark.openshift.utility.reg.provider.ocp.json.registry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "tag",
    "generation",
    "lookupPolicy",
    "image"
})
public class Item {

    @JsonProperty("metadata")
    private Metadata_ metadata;
    @JsonProperty("tag")
    private Object tag;
    @JsonProperty("generation")
    private Long generation;
    @JsonProperty("lookupPolicy")
    private LookupPolicy lookupPolicy;
    @JsonProperty("image")
    private Image image;

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

    @JsonProperty("tag")
    public Object getTag() {
        return tag;
    }

    @JsonProperty("tag")
    public void setTag(Object tag) {
        this.tag = tag;
    }

    public Item withTag(Object tag) {
        this.tag = tag;
        return this;
    }

    @JsonProperty("generation")
    public Long getGeneration() {
        return generation;
    }

    @JsonProperty("generation")
    public void setGeneration(Long generation) {
        this.generation = generation;
    }

    public Item withGeneration(Long generation) {
        this.generation = generation;
        return this;
    }

    @JsonProperty("lookupPolicy")
    public LookupPolicy getLookupPolicy() {
        return lookupPolicy;
    }

    @JsonProperty("lookupPolicy")
    public void setLookupPolicy(LookupPolicy lookupPolicy) {
        this.lookupPolicy = lookupPolicy;
    }

    public Item withLookupPolicy(LookupPolicy lookupPolicy) {
        this.lookupPolicy = lookupPolicy;
        return this;
    }

    @JsonProperty("image")
    public Image getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(Image image) {
        this.image = image;
    }

    public Item withImage(Image image) {
        this.image = image;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Item.class.getSimpleName() + "[", "]")
                .add("metadata=" + metadata)
                .add("tag=" + tag)
                .add("generation=" + generation)
                .add("lookupPolicy=" + lookupPolicy)
                .add("image=" + image)
                .toString();
    }
}
