
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "items"
})
public class Usages {

    @JsonProperty("type")
    private String type;
    @JsonProperty("items")
    private Items_ items;

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    public Usages withType(String type) {
        this.type = type;
        return this;
    }

    @JsonProperty("items")
    public Items_ getItems() {
        return items;
    }

    @JsonProperty("items")
    public void setItems(Items_ items) {
        this.items = items;
    }

    public Usages withItems(Items_ items) {
        this.items = items;
        return this;
    }

}
