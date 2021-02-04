
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name"
})
public class Properties______ {

    @JsonProperty("id")
    private Id___ id;
    @JsonProperty("name")
    private Name__ name;

    @JsonProperty("id")
    public Id___ getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id___ id) {
        this.id = id;
    }

    public Properties______ withId(Id___ id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public Name__ getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name__ name) {
        this.name = name;
    }

    public Properties______ withName(Name__ name) {
        this.name = name;
        return this;
    }

}
