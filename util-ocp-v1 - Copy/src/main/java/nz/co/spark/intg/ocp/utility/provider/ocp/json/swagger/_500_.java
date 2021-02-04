
package nz.co.spark.intg.ocp.utility.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "schema"
})
public class _500_ {

    @JsonProperty("description")
    private String description;
    @JsonProperty("schema")
    private Schema______ schema;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public _500_ withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("schema")
    public Schema______ getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(Schema______ schema) {
        this.schema = schema;
    }

    public _500_ withSchema(Schema______ schema) {
        this.schema = schema;
        return this;
    }

}
