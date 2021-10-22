
package nz.co.spark.openshift.utility.fuse.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "value",
    "valueFrom"
})
public class Env {

    @JsonProperty("name")
    private String name;
    @JsonProperty("value")
    private String value;
    @JsonProperty("valueFrom")
    private ValueFrom valueFrom;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Env withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    public Env withValue(String value) {
        this.value = value;
        return this;
    }

    @JsonProperty("valueFrom")
    public ValueFrom getValueFrom() {
        return valueFrom;
    }

    @JsonProperty("valueFrom")
    public void setValueFrom(ValueFrom valueFrom) {
        this.valueFrom = valueFrom;
    }

    public Env withValueFrom(ValueFrom valueFrom) {
        this.valueFrom = valueFrom;
        return this;
    }

}
