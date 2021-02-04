
package nz.co.spark.intg.ocp.utility.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "schema"
})
public class _200_ {

    @JsonProperty("description")
    private String description;
    @JsonProperty("schema")
    private Schema____ schema;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public _200_ withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("schema")
    public Schema____ getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(Schema____ schema) {
        this.schema = schema;
    }

    public _200_ withSchema(Schema____ schema) {
        this.schema = schema;
        return this;
    }

}
