
package nz.co.spark.intg.ocp.utility.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "in",
    "description",
    "required",
    "type",
    "x-example"
})
public class Parameter {

    @JsonProperty("name")
    private String name;
    @JsonProperty("in")
    private String in;
    @JsonProperty("description")
    private String description;
    @JsonProperty("required")
    private Boolean required;
    @JsonProperty("type")
    private String type;
    @JsonProperty("x-example")
    private String xExample;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Parameter withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("in")
    public String getIn() {
        return in;
    }

    @JsonProperty("in")
    public void setIn(String in) {
        this.in = in;
    }

    public Parameter withIn(String in) {
        this.in = in;
        return this;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Parameter withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("required")
    public Boolean getRequired() {
        return required;
    }

    @JsonProperty("required")
    public void setRequired(Boolean required) {
        this.required = required;
    }

    public Parameter withRequired(Boolean required) {
        this.required = required;
        return this;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Parameter withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("x-example")
    public String getXExample() {
        return xExample;
    }

    @JsonProperty("x-example")
    public void setXExample(String xExample) {
        this.xExample = xExample;
    }

    public Parameter withXExample(String xExample) {
        this.xExample = xExample;
        return this;
    }

}
