
package nz.co.spark.openshift.utility.reg.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "configMap"
})
public class Volume {

    @JsonProperty("name")
    private String name;
    @JsonProperty("configMap")
    private ConfigMap configMap;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Volume withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("configMap")
    public ConfigMap getConfigMap() {
        return configMap;
    }

    @JsonProperty("configMap")
    public void setConfigMap(ConfigMap configMap) {
        this.configMap = configMap;
    }

    public Volume withConfigMap(ConfigMap configMap) {
        this.configMap = configMap;
        return this;
    }

}
