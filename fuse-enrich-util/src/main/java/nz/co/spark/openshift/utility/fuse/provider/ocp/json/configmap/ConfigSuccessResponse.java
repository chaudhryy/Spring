package nz.co.spark.openshift.utility.fuse.provider.ocp.json.configmap;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "apiVersion",
    "metadata",
    "data"
})
public class ConfigSuccessResponse {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("metadata")
    private Metadata metadata;
    @JsonProperty("data")
    private Data data;

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    @JsonProperty("apiVersion")
    public String getApiVersion() {
        return apiVersion;
    }

    @JsonProperty("apiVersion")
    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    @JsonProperty("metadata")
    public Metadata getMetadata() {
        return metadata;
    }

//    @JsonProperty("metadata")
//    public void setMetadata(Metadata metadata) {
//        this.metadata = metadata;
//    }

    @JsonProperty("data")
    public Data getData() {
        return data;
    }
//
//    @JsonProperty("data")
//    public void setData(Data data) {
//        this.data = data;
//    }


}
