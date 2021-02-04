
package com.yash.provider.ocp.json.routelist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "host",
    "to",
    "port",
    "wildcardPolicy"
})
public class Spec {

    @JsonProperty("host")
    private String host;
    @JsonProperty("to")
    private To to;
    @JsonProperty("port")
    private Port port;
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

    public Spec withHost(String host) {
        this.host = host;
        return this;
    }

    @JsonProperty("to")
    public To getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(To to) {
        this.to = to;
    }

    public Spec withTo(To to) {
        this.to = to;
        return this;
    }

    @JsonProperty("port")
    public Port getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Port port) {
        this.port = port;
    }

    public Spec withPort(Port port) {
        this.port = port;
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

    public Spec withWildcardPolicy(String wildcardPolicy) {
        this.wildcardPolicy = wildcardPolicy;
        return this;
    }

}
