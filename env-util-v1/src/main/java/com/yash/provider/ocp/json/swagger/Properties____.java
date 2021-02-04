
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "httpStatusCode",
    "httpStatusDescription",
    "errors"
})
public class Properties____ {

    @JsonProperty("httpStatusCode")
    private HttpStatusCode httpStatusCode;
    @JsonProperty("httpStatusDescription")
    private HttpStatusDescription httpStatusDescription;
    @JsonProperty("errors")
    private Errors errors;

    @JsonProperty("httpStatusCode")
    public HttpStatusCode getHttpStatusCode() {
        return httpStatusCode;
    }

    @JsonProperty("httpStatusCode")
    public void setHttpStatusCode(HttpStatusCode httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public Properties____ withHttpStatusCode(HttpStatusCode httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
        return this;
    }

    @JsonProperty("httpStatusDescription")
    public HttpStatusDescription getHttpStatusDescription() {
        return httpStatusDescription;
    }

    @JsonProperty("httpStatusDescription")
    public void setHttpStatusDescription(HttpStatusDescription httpStatusDescription) {
        this.httpStatusDescription = httpStatusDescription;
    }

    public Properties____ withHttpStatusDescription(HttpStatusDescription httpStatusDescription) {
        this.httpStatusDescription = httpStatusDescription;
        return this;
    }

    @JsonProperty("errors")
    public Errors getErrors() {
        return errors;
    }

    @JsonProperty("errors")
    public void setErrors(Errors errors) {
        this.errors = errors;
    }

    public Properties____ withErrors(Errors errors) {
        this.errors = errors;
        return this;
    }

}
