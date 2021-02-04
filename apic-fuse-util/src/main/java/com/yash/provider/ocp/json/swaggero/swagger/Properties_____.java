
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "enabled",
    "dateCreated",
    "organization",
    "selfUri"
})
public class Properties_____ {

    @JsonProperty("id")
    private Id__ id;
    @JsonProperty("enabled")
    private Enabled enabled;
    @JsonProperty("dateCreated")
    private DateCreated dateCreated;
    @JsonProperty("organization")
    private Organization_ organization;
    @JsonProperty("selfUri")
    private SelfUri_ selfUri;

    @JsonProperty("id")
    public Id__ getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id__ id) {
        this.id = id;
    }

    public Properties_____ withId(Id__ id) {
        this.id = id;
        return this;
    }

    @JsonProperty("enabled")
    public Enabled getEnabled() {
        return enabled;
    }

    @JsonProperty("enabled")
    public void setEnabled(Enabled enabled) {
        this.enabled = enabled;
    }

    public Properties_____ withEnabled(Enabled enabled) {
        this.enabled = enabled;
        return this;
    }

    @JsonProperty("dateCreated")
    public DateCreated getDateCreated() {
        return dateCreated;
    }

    @JsonProperty("dateCreated")
    public void setDateCreated(DateCreated dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Properties_____ withDateCreated(DateCreated dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    @JsonProperty("organization")
    public Organization_ getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(Organization_ organization) {
        this.organization = organization;
    }

    public Properties_____ withOrganization(Organization_ organization) {
        this.organization = organization;
        return this;
    }

    @JsonProperty("selfUri")
    public SelfUri_ getSelfUri() {
        return selfUri;
    }

    @JsonProperty("selfUri")
    public void setSelfUri(SelfUri_ selfUri) {
        this.selfUri = selfUri;
    }

    public Properties_____ withSelfUri(SelfUri_ selfUri) {
        this.selfUri = selfUri;
        return this;
    }

}
