
package nz.co.spark.openshift.utility.reg.provider.ocp.json.registry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.StringJoiner;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "metadata",
    "dockerImageReference",
    "dockerImageMetadata",
    "dockerImageMetadataVersion",
    "dockerImageLayers"
})
public class Image {

    @JsonProperty("metadata")
    private Metadata__ metadata;
    @JsonProperty("dockerImageReference")
    private String dockerImageReference;
    @JsonProperty("dockerImageMetadata")
    private DockerImageMetadata dockerImageMetadata;
    @JsonProperty("dockerImageMetadataVersion")
    private String dockerImageMetadataVersion;
    @JsonProperty("dockerImageLayers")
    private Object dockerImageLayers;

    @JsonProperty("metadata")
    public Metadata__ getMetadata() {
        return metadata;
    }

    @JsonProperty("metadata")
    public void setMetadata(Metadata__ metadata) {
        this.metadata = metadata;
    }

    public Image withMetadata(Metadata__ metadata) {
        this.metadata = metadata;
        return this;
    }

    @JsonProperty("dockerImageReference")
    public String getDockerImageReference() {
        return dockerImageReference;
    }

    @JsonProperty("dockerImageReference")
    public void setDockerImageReference(String dockerImageReference) {
        this.dockerImageReference = dockerImageReference;
    }

    public Image withDockerImageReference(String dockerImageReference) {
        this.dockerImageReference = dockerImageReference;
        return this;
    }

    @JsonProperty("dockerImageMetadata")
    public DockerImageMetadata getDockerImageMetadata() {
        return dockerImageMetadata;
    }

    @JsonProperty("dockerImageMetadata")
    public void setDockerImageMetadata(DockerImageMetadata dockerImageMetadata) {
        this.dockerImageMetadata = dockerImageMetadata;
    }

    public Image withDockerImageMetadata(DockerImageMetadata dockerImageMetadata) {
        this.dockerImageMetadata = dockerImageMetadata;
        return this;
    }

    @JsonProperty("dockerImageMetadataVersion")
    public String getDockerImageMetadataVersion() {
        return dockerImageMetadataVersion;
    }

    @JsonProperty("dockerImageMetadataVersion")
    public void setDockerImageMetadataVersion(String dockerImageMetadataVersion) {
        this.dockerImageMetadataVersion = dockerImageMetadataVersion;
    }

    public Image withDockerImageMetadataVersion(String dockerImageMetadataVersion) {
        this.dockerImageMetadataVersion = dockerImageMetadataVersion;
        return this;
    }

    @JsonProperty("dockerImageLayers")
    public Object getDockerImageLayers() {
        return dockerImageLayers;
    }

    @JsonProperty("dockerImageLayers")
    public void setDockerImageLayers(Object dockerImageLayers) {
        this.dockerImageLayers = dockerImageLayers;
    }

    public Image withDockerImageLayers(Object dockerImageLayers) {
        this.dockerImageLayers = dockerImageLayers;
        return this;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Image.class.getSimpleName() + "[", "]")
                .add("metadata=" + metadata)
                .add("dockerImageReference='" + dockerImageReference + "'")
                .add("dockerImageMetadata=" + dockerImageMetadata)
                .add("dockerImageMetadataVersion='" + dockerImageMetadataVersion + "'")
                .add("dockerImageLayers=" + dockerImageLayers)
                .toString();
    }
}
