
package com.yash.provider.ocp.json.routelist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ingress"
})
public class Status {

    @JsonProperty("ingress")
    private List<Ingress> ingress = null;

    @JsonProperty("ingress")
    public List<Ingress> getIngress() {
        return ingress;
    }

    @JsonProperty("ingress")
    public void setIngress(List<Ingress> ingress) {
        this.ingress = ingress;
    }

    public Status withIngress(List<Ingress> ingress) {
        this.ingress = ingress;
        return this;
    }

}
