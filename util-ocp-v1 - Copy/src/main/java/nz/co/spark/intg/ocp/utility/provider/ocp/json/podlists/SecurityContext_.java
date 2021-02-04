
package nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "seLinuxOptions",
    "fsGroup"
})
public class SecurityContext_ {

    @JsonProperty("seLinuxOptions")
    private SeLinuxOptions seLinuxOptions;
    @JsonProperty("fsGroup")
    private Long fsGroup;

    @JsonProperty("seLinuxOptions")
    public SeLinuxOptions getSeLinuxOptions() {
        return seLinuxOptions;
    }

    @JsonProperty("seLinuxOptions")
    public void setSeLinuxOptions(SeLinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
    }

    public SecurityContext_ withSeLinuxOptions(SeLinuxOptions seLinuxOptions) {
        this.seLinuxOptions = seLinuxOptions;
        return this;
    }

    @JsonProperty("fsGroup")
    public Long getFsGroup() {
        return fsGroup;
    }

    @JsonProperty("fsGroup")
    public void setFsGroup(Long fsGroup) {
        this.fsGroup = fsGroup;
    }

    public SecurityContext_ withFsGroup(Long fsGroup) {
        this.fsGroup = fsGroup;
        return this;
    }

}
