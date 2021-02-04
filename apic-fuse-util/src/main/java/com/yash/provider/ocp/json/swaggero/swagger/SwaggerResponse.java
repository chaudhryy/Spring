
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "swagger",
    "info",
    "host",
    "tags",
    "schemes",
    "paths",
    "definitions"
})
public class SwaggerResponse {

    @JsonProperty("swagger")
    private String swagger;
    @JsonProperty("info")
    private Info info;
    @JsonProperty("host")
    private String host;
    @JsonProperty("tags")
    private List<Tag> tags = null;
    @JsonProperty("schemes")
    private List<String> schemes = null;
    @JsonProperty("paths")
    private Paths paths;
    @JsonProperty("definitions")
    private Definitions definitions;

    @JsonProperty("swagger")
    public String getSwagger() {
        return swagger;
    }

    @JsonProperty("swagger")
    public void setSwagger(String swagger) {
        this.swagger = swagger;
    }

    public SwaggerResponse withSwagger(String swagger) {
        this.swagger = swagger;
        return this;
    }

    @JsonProperty("info")
    public Info getInfo() {
        return info;
    }

    @JsonProperty("info")
    public void setInfo(Info info) {
        this.info = info;
    }

    public SwaggerResponse withInfo(Info info) {
        this.info = info;
        return this;
    }

    @JsonProperty("host")
    public String getHost() {
        return host;
    }

    @JsonProperty("host")
    public void setHost(String host) {
        this.host = host;
    }

    public SwaggerResponse withHost(String host) {
        this.host = host;
        return this;
    }

    @JsonProperty("tags")
    public List<Tag> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public SwaggerResponse withTags(List<Tag> tags) {
        this.tags = tags;
        return this;
    }

    @JsonProperty("schemes")
    public List<String> getSchemes() {
        return schemes;
    }

    @JsonProperty("schemes")
    public void setSchemes(List<String> schemes) {
        this.schemes = schemes;
    }

    public SwaggerResponse withSchemes(List<String> schemes) {
        this.schemes = schemes;
        return this;
    }

    @JsonProperty("paths")
    public Paths getPaths() {
        return paths;
    }

    @JsonProperty("paths")
    public void setPaths(Paths paths) {
        this.paths = paths;
    }

    public SwaggerResponse withPaths(Paths paths) {
        this.paths = paths;
        return this;
    }

    @JsonProperty("definitions")
    public Definitions getDefinitions() {
        return definitions;
    }

    @JsonProperty("definitions")
    public void setDefinitions(Definitions definitions) {
        this.definitions = definitions;
    }

    public SwaggerResponse withDefinitions(Definitions definitions) {
        this.definitions = definitions;
        return this;
    }

}
