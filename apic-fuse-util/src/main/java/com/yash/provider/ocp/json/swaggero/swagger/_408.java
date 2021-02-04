
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "schema"
})
public class _408 {

    @JsonProperty("description")
    private String description;
    @JsonProperty("schema")
    private Schema___ schema;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public _408 withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("schema")
    public Schema___ getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(Schema___ schema) {
        this.schema = schema;
    }

    public _408 withSchema(Schema___ schema) {
        this.schema = schema;
        return this;
    }

}
