
package nz.co.spark.intg.ocp.utility.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "properties"
})
public class Error {

    @JsonProperty("type")
    private String type;
    @JsonProperty("properties")
    private Properties___ properties;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Error withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("properties")
    public Properties___ getProperties() {
        return properties;
    }

    @JsonProperty("properties")
    public void setProperties(Properties___ properties) {
        this.properties = properties;
    }

    public Error withProperties(Properties___ properties) {
        this.properties = properties;
        return this;
    }

}
