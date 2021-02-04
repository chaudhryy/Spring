
package nz.co.spark.openshift.utility.reg.provider.ocp.json.registry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "kind",
    "apiVersion",
    "Id",
    "Created",
    "ContainerConfig"
})
public class DockerImageMetadata {

    @JsonProperty("kind")
    private String kind;
    @JsonProperty("apiVersion")
    private String apiVersion;
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Created")
    private Object created;
    @JsonProperty("ContainerConfig")
    private ContainerConfig containerConfig;

    @JsonProperty("kind")
    public String getKind() {
        return kind;
    }

    @JsonProperty("kind")
    public void setKind(String kind) {
        this.kind = kind;
    }

    public DockerImageMetadata withKind(String kind) {
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

    public DockerImageMetadata withApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    @JsonProperty("Id")
    public String getId() {
        return id;
    }

    @JsonProperty("Id")
    public void setId(String id) {
        this.id = id;
    }

    public DockerImageMetadata withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("Created")
    public Object getCreated() {
        return created;
    }

    @JsonProperty("Created")
    public void setCreated(Object created) {
        this.created = created;
    }

    public DockerImageMetadata withCreated(Object created) {
        this.created = created;
        return this;
    }

    @JsonProperty("ContainerConfig")
    public ContainerConfig getContainerConfig() {
        return containerConfig;
    }

    @JsonProperty("ContainerConfig")
    public void setContainerConfig(ContainerConfig containerConfig) {
        this.containerConfig = containerConfig;
    }

    public DockerImageMetadata withContainerConfig(ContainerConfig containerConfig) {
        this.containerConfig = containerConfig;
        return this;
    }

}
