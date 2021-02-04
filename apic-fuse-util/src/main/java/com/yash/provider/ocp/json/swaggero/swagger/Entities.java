
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "items"
})
public class Entities {

    @JsonProperty("type")
    private String type;
    @JsonProperty("items")
    private Items___ items;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Entities withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("items")
    public Items___ getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Items___ items) {
        this.items = items;
    }

    public Entities withItems(Items___ items) {
        this.items = items;
        return this;
    }

}
