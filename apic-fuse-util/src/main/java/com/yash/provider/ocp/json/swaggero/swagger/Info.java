
package com.yash.provider.ocp.json.swaggero.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "description",
    "version",
    "title",
    "termsOfService",
    "contact",
    "license"
})
public class Info {

    @JsonProperty("description")
    private String description;
    @JsonProperty("version")
    private String version;
    @JsonProperty("title")
    private String title;
    @JsonProperty("termsOfService")
    private String termsOfService;
    @JsonProperty("contact")
    private Contact contact;
    @JsonProperty("license")
    private License license;

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    public Info withDescription(String description) {
        this.description = description;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public Info withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("title")
    public void setTitle(String title) {
        this.title = title;
    }

    public Info withTitle(String title) {
        this.title = title;
        return this;
    }

    @JsonProperty("termsOfService")
    public String getTermsOfService() {
        return termsOfService;
    }

    @JsonProperty("termsOfService")
    public void setTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
    }

    public Info withTermsOfService(String termsOfService) {
        this.termsOfService = termsOfService;
        return this;
    }

    @JsonProperty("contact")
    public Contact getContact() {
        return contact;
    }

    @JsonProperty("contact")
    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Info withContact(Contact contact) {
        this.contact = contact;
        return this;
    }

    @JsonProperty("license")
    public License getLicense() {
        return license;
    }

    @JsonProperty("license")
    public void setLicense(License license) {
        this.license = license;
    }

    public Info withLicense(License license) {
        this.license = license;
        return this;
    }

}
