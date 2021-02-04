
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "get"
})
public class BillinqryV1OrganisationList {

    @JsonProperty("get")
    private Get_ get;

    @JsonProperty("get")
    public Get_ getGet() {
        return get;
    }

    @JsonProperty("get")
    public void setGet(Get_ get) {
        this.get = get;
    }

    public BillinqryV1OrganisationList withGet(Get_ get) {
        this.get = get;
        return this;
    }

}
