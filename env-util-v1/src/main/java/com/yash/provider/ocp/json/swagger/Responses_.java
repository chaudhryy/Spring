
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
public class Responses_ {

    @JsonProperty("200")
    private _200_ _200;
    @JsonProperty("400")
    private _400_ _400;
    @JsonProperty("500")
    private _500_ _500;
    @JsonProperty("408")
    private _408_ _408;

    @JsonProperty("200")
    public _200_ get200() {
        return _200;
    }

    @JsonProperty("200")
    public void set200(_200_ _200) {
        this._200 = _200;
    }

    public Responses_ with200(_200_ _200) {
        this._200 = _200;
        return this;
    }

    @JsonProperty("400")
    public _400_ get400() {
        return _400;
    }

    @JsonProperty("400")
    public void set400(_400_ _400) {
        this._400 = _400;
    }

    public Responses_ with400(_400_ _400) {
        this._400 = _400;
        return this;
    }

    @JsonProperty("500")
    public _500_ get500() {
        return _500;
    }

    @JsonProperty("500")
    public void set500(_500_ _500) {
        this._500 = _500;
    }

    public Responses_ with500(_500_ _500) {
        this._500 = _500;
        return this;
    }

    @JsonProperty("408")
    public _408_ get408() {
        return _408;
    }

    @JsonProperty("408")
    public void set408(_408_ _408) {
        this._408 = _408;
    }

    public Responses_ with408(_408_ _408) {
        this._408 = _408;
        return this;
    }

}
