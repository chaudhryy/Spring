
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "schema"
})
public class _400 {

    @JsonProperty("description")
    private String description;
    @JsonProperty("schema")
    private Schema_ schema;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public _400 withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("schema")
    public Schema_ getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(Schema_ schema) {
        this.schema = schema;
    }

    public _400 withSchema(Schema_ schema) {
        this.schema = schema;
        return this;
    }

}
