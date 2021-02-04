
package nz.co.spark.openshift.utility.reg.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "cpu",
    "memory"
})
public class Limits {

    @JsonProperty("cpu")
    private String cpu;
    @JsonProperty("memory")
    private String memory;

    @JsonProperty("cpu")
    public String getCpu() {
        return cpu;
    }

    @JsonProperty("cpu")
    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public Limits withCpu(String cpu) {
        this.cpu = cpu;
        return this;
    }

    @JsonProperty("memory")
    public String getMemory() {
        return memory;
    }

    @JsonProperty("memory")
    public void setMemory(String memory) {
        this.memory = memory;
    }

    public Limits withMemory(String memory) {
        this.memory = memory;
        return this;
    }

}
