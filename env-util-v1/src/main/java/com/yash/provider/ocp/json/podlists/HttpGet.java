
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "path",
    "port",
    "scheme"
})
public class HttpGet {

    @JsonProperty("path")
    private String path;
    @JsonProperty("port")
    private Long port;
    @JsonProperty("scheme")
    private String scheme;

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    @JsonProperty("path")
    public void setPath(String path) {
        this.path = path;
    }

    public HttpGet withPath(String path) {
        this.path = path;
        return this;
    }

    @JsonProperty("port")
    public Long getPort() {
        return port;
    }

    @JsonProperty("port")
    public void setPort(Long port) {
        this.port = port;
    }

    public HttpGet withPort(Long port) {
        this.port = port;
        return this;
    }

    @JsonProperty("scheme")
    public String getScheme() {
        return scheme;
    }

    @JsonProperty("scheme")
    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public HttpGet withScheme(String scheme) {
        this.scheme = scheme;
        return this;
    }

}
