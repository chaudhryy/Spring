
package nz.co.spark.intg.ocp.utility.provider.ocp.json.projectlist;

import java.util.List;
import java.util.StringJoiner;

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
public class ProjectResponseList {

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

    public ProjectResponseList withKind(String kind) {
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

    public ProjectResponseList withApiVersion(String apiVersion) {
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

    public ProjectResponseList withMetadata(Metadata metadata) {
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

    public ProjectResponseList withItems(List<Item> items) {
        this.items = items;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ProjectResponseList.class.getSimpleName() + "[", "]")
                .add("kind='" + kind + "'")
                .add("apiVersion='" + apiVersion + "'")
                .add("metadata=" + metadata)
                .add("items=" + items)
                .toString();
    }
}
