
package com.yash.provider.ocp.json.swagger;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "tags",
    "summary",
    "operationId",
    "consumes",
    "produces",
    "parameters",
    "responses"
})
public class Get {

    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonProperty("summary")
    private String summary;
    @JsonProperty("operationId")
    private String operationId;
    @JsonProperty("consumes")
    private List<String> consumes = null;
    @JsonProperty("produces")
    private List<String> produces = null;
    @JsonProperty("parameters")
    private List<Parameter> parameters = null;
    @JsonProperty("responses")
    private Responses responses;

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Get withTags(List<String> tags) {
        this.tags = tags;
        return this;
    }

    @JsonProperty("summary")
    public String getSummary() {
        return summary;
    }

    @JsonProperty("summary")
    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Get withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    @JsonProperty("operationId")
    public String getOperationId() {
        return operationId;
    }

    @JsonProperty("operationId")
    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public Get withOperationId(String operationId) {
        this.operationId = operationId;
        return this;
    }

    @JsonProperty("consumes")
    public List<String> getConsumes() {
        return consumes;
    }

    @JsonProperty("consumes")
    public void setConsumes(List<String> consumes) {
        this.consumes = consumes;
    }

    public Get withConsumes(List<String> consumes) {
        this.consumes = consumes;
        return this;
    }

    @JsonProperty("produces")
    public List<String> getProduces() {
        return produces;
    }

    @JsonProperty("produces")
    public void setProduces(List<String> produces) {
        this.produces = produces;
    }

    public Get withProduces(List<String> produces) {
        this.produces = produces;
        return this;
    }

    @JsonProperty("parameters")
    public List<Parameter> getParameters() {
        return parameters;
    }

    @JsonProperty("parameters")
    public void setParameters(List<Parameter> parameters) {
        this.parameters = parameters;
    }

    public Get withParameters(List<Parameter> parameters) {
        this.parameters = parameters;
        return this;
    }

    @JsonProperty("responses")
    public Responses getResponses() {
        return responses;
    }

    @JsonProperty("responses")
    public void setResponses(Responses responses) {
        this.responses = responses;
    }

    public Get withResponses(Responses responses) {
        this.responses = responses;
        return this;
    }

}
