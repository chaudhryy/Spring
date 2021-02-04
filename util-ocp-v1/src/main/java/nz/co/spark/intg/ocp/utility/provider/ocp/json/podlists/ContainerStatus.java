
package nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "state",
    "lastState",
    "ready",
    "restartCount",
    "image",
    "imageID",
    "containerID"
})
public class ContainerStatus {

    @JsonProperty("name")
    private String name;
    @JsonProperty("state")
    private State state;
    @JsonProperty("lastState")
    private LastState lastState;
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("restartCount")
    private Long restartCount;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imageID")
    private String imageID;
    @JsonProperty("containerID")
    private String containerID;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public ContainerStatus withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("state")
    public State getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(State state) {
        this.state = state;
    }

    public ContainerStatus withState(State state) {
        this.state = state;
        return this;
    }

    @JsonProperty("lastState")
    public LastState getLastState() {
        return lastState;
    }

    @JsonProperty("lastState")
    public void setLastState(LastState lastState) {
        this.lastState = lastState;
    }

    public ContainerStatus withLastState(LastState lastState) {
        this.lastState = lastState;
        return this;
    }

    @JsonProperty("ready")
    public Boolean getReady() {
        return ready;
    }

    @JsonProperty("ready")
    public void setReady(Boolean ready) {
        this.ready = ready;
    }

    public ContainerStatus withReady(Boolean ready) {
        this.ready = ready;
        return this;
    }

    @JsonProperty("restartCount")
    public Long getRestartCount() {
        return restartCount;
    }

    @JsonProperty("restartCount")
    public void setRestartCount(Long restartCount) {
        this.restartCount = restartCount;
    }

    public ContainerStatus withRestartCount(Long restartCount) {
        this.restartCount = restartCount;
        return this;
    }

    @JsonProperty("image")
    public String getImage() {
        return image;
    }

    @JsonProperty("image")
    public void setImage(String image) {
        this.image = image;
    }

    public ContainerStatus withImage(String image) {
        this.image = image;
        return this;
    }

    @JsonProperty("imageID")
    public String getImageID() {
        return imageID;
    }

    @JsonProperty("imageID")
    public void setImageID(String imageID) {
        this.imageID = imageID;
    }

    public ContainerStatus withImageID(String imageID) {
        this.imageID = imageID;
        return this;
    }

    @JsonProperty("containerID")
    public String getContainerID() {
        return containerID;
    }

    @JsonProperty("containerID")
    public void setContainerID(String containerID) {
        this.containerID = containerID;
    }

    public ContainerStatus withContainerID(String containerID) {
        this.containerID = containerID;
        return this;
    }

}
