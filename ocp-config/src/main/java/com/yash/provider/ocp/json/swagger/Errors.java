
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "items"
})
public class Errors {

    @JsonProperty("type")
    private String type;
    @JsonProperty("items")
    private Items__ items;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Errors withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("items")
    public Items__ getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Items__ items) {
        this.items = items;
    }

    public Errors withItems(Items__ items) {
        this.items = items;
        return this;
    }

}
