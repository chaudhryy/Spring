
package nz.co.spark.intg.ocp.utility.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "mountPath"
})
public class VolumeMount {

    @JsonProperty("name")
    private String name;
    @JsonProperty("mountPath")
    private String mountPath;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public VolumeMount withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("mountPath")
    public String getMountPath() {
        return mountPath;
    }

    @JsonProperty("mountPath")
    public void setMountPath(String mountPath) {
        this.mountPath = mountPath;
    }

    public VolumeMount withMountPath(String mountPath) {
        this.mountPath = mountPath;
        return this;
    }

}
