
package nz.co.spark.openshift.utility.reg.provider.ocp.json.registry;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "apiVersion",
    "metadata",
    "items"
})
public class ImageStreamTags {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("items")
    private List<Item> items = null;

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    public ImageStreamTags withKind(String kind) {
        this.kind = kind;
        return this;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public ImageStreamTags withApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata metadata) {
        this.metadata = metadata;
    }

    public ImageStreamTags withMetadata(Metadata metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonProperty("items")
    public List<Item> getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(List<Item> items) {
        this.items = items;
    }

    public ImageStreamTags withItems(List<Item> items) {
        this.items = items;
        return this;
    }

}
