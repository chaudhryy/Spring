
package com.yash.provider.ocp.json.routelist;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "host",
    "routerName",
    "conditions",
    "wildcardPolicy"
})
public class Ingress {

    @JsonProperty("host")
    private String host;
    @JsonProperty("routerName")
    private String routerName;
    @JsonProperty("conditions")
    private List<Condition> conditions = null;
    @JsonProperty("wildcardPolicy")
    private String wildcardPolicy;

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    public Ingress withHost(String host) {
        this.host = host;
        return this;
    }

    @JsonProperty("routerName")
    public String getRouterName() {
        return routerName;
    }

    @JsonProperty("routerName")
    public void setRouterName(String routerName) {
        this.routerName = routerName;
    }

    public Ingress withRouterName(String routerName) {
        this.routerName = routerName;
        return this;
    }

    @JsonProperty("conditions")
    public List<Condition> getConditions() {
        return conditions;
    }

    @JsonProperty("conditions")
    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public Ingress withConditions(List<Condition> conditions) {
        this.conditions = conditions;
        return this;
    }

    @JsonProperty("wildcardPolicy")
    public String getWildcardPolicy() {
        return wildcardPolicy;
    }

    @JsonProperty("wildcardPolicy")
    public void setWildcardPolicy(String wildcardPolicy) {
        this.wildcardPolicy = wildcardPolicy;
    }

    public Ingress withWildcardPolicy(String wildcardPolicy) {
        this.wildcardPolicy = wildcardPolicy;
        return this;
    }

}
