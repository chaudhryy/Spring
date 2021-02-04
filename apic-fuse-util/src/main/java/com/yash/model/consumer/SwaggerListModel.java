
package com.yash.model.consumer;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "organizationName",
    "definitionList"
})
public class SwaggerListModel {

    @JsonProperty("organizationName")
    private String organizationName;
    @JsonProperty("definitionList")
    private List<Definition> definition = null;

    @JsonProperty("organizationName")
    public String getOrganizationName() {
        return organizationName;
    }

    @JsonProperty("organizationName")
    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public SwaggerListModel withOrganizationName(String organizationName) {
        this.organizationName = organizationName;
        return this;
    }

    @JsonProperty("definitionList")
    public List<Definition> getDefinition() {
        return definition;
    }

    @JsonProperty("definitionList")
    public void setDefinition(List<Definition> definition) {
        this.definition = definition;
    }

    public SwaggerListModel withDefinitionList(List<Definition> definition) {
        this.definition = definition;
        return this;
    }

    @Override
    public String toString() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return "";
        }
    }


}
