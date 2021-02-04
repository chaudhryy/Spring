
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "200",
    "400",
    "500",
    "408"
})
public class Responses {

    @JsonProperty("200")
    private com.yash.provider.ocp.json.swagger._200 _200;
    @JsonProperty("400")
    private com.yash.provider.ocp.json.swagger._400 _400;
    @JsonProperty("500")
    private com.yash.provider.ocp.json.swagger._500 _500;
    @JsonProperty("408")
    private com.yash.provider.ocp.json.swagger._408 _408;

    @JsonProperty("200")
    public com.yash.provider.ocp.json.swagger._200 get200() {
        return _200;
    }

    @JsonProperty("200")
    public void set200(com.yash.provider.ocp.json.swagger._200 _200) {
        this._200 = _200;
    }

    public Responses with200(com.yash.provider.ocp.json.swagger._200 _200) {
        this._200 = _200;
        return this;
    }

    @JsonProperty("400")
    public com.yash.provider.ocp.json.swagger._400 get400() {
        return _400;
    }

    @JsonProperty("400")
    public void set400(com.yash.provider.ocp.json.swagger._400 _400) {
        this._400 = _400;
    }

    public Responses with400(com.yash.provider.ocp.json.swagger._400 _400) {
        this._400 = _400;
        return this;
    }

    @JsonProperty("500")
    public com.yash.provider.ocp.json.swagger._500 get500() {
        return _500;
    }

    @JsonProperty("500")
    public void set500(com.yash.provider.ocp.json.swagger._500 _500) {
        this._500 = _500;
    }

    public Responses with500(com.yash.provider.ocp.json.swagger._500 _500) {
        this._500 = _500;
        return this;
    }

    @JsonProperty("408")
    public com.yash.provider.ocp.json.swagger._408 get408() {
        return _408;
    }

    @JsonProperty("408")
    public void set408(com.yash.provider.ocp.json.swagger._408 _408) {
        this._408 = _408;
    }

    public Responses with408(com.yash.provider.ocp.json.swagger._408 _408) {
        this._408 = _408;
        return this;
    }

}
