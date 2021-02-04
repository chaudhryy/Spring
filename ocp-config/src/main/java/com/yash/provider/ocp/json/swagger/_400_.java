
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "schema"
})
public class _400_ {

    @JsonProperty("description")
    private String description;
    @JsonProperty("schema")
    private Schema_____ schema;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public _400_ withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("schema")
    public Schema_____ getSchema() {
        return schema;
    }

    @JsonProperty("schema")
    public void setSchema(Schema_____ schema) {
        this.schema = schema;
    }

    public _400_ withSchema(Schema_____ schema) {
        this.schema = schema;
        return this;
    }

}
