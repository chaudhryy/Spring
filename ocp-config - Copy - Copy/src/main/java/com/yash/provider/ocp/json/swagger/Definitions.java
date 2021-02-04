
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "Entity",
    "SubscriptionOverviewUsage",
    "TrusteeBillingOverview",
    "Error",
    "ErrorResponse",
    "Trustor",
    "Organization",
    "TrustorEntityListing"
})
public class Definitions {

    @JsonProperty("Entity")
    private Entity entity;
    @JsonProperty("SubscriptionOverviewUsage")
    private SubscriptionOverviewUsage subscriptionOverviewUsage;
    @JsonProperty("TrusteeBillingOverview")
    private TrusteeBillingOverview trusteeBillingOverview;
    @JsonProperty("Error")
    private Error error;
    @JsonProperty("ErrorResponse")
    private ErrorResponse errorResponse;
    @JsonProperty("Trustor")
    private Trustor trustor;
    @JsonProperty("Organization")
    private Organization__ organization;
    @JsonProperty("TrustorEntityListing")
    private TrustorEntityListing trustorEntityListing;

    @JsonProperty("Entity")
    public Entity getEntity() {
        return entity;
    }

    @JsonProperty("Entity")
    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public Definitions withEntity(Entity entity) {
        this.entity = entity;
        return this;
    }

    @JsonProperty("SubscriptionOverviewUsage")
    public SubscriptionOverviewUsage getSubscriptionOverviewUsage() {
        return subscriptionOverviewUsage;
    }

    @JsonProperty("SubscriptionOverviewUsage")
    public void setSubscriptionOverviewUsage(SubscriptionOverviewUsage subscriptionOverviewUsage) {
        this.subscriptionOverviewUsage = subscriptionOverviewUsage;
    }

    public Definitions withSubscriptionOverviewUsage(SubscriptionOverviewUsage subscriptionOverviewUsage) {
        this.subscriptionOverviewUsage = subscriptionOverviewUsage;
        return this;
    }

    @JsonProperty("TrusteeBillingOverview")
    public TrusteeBillingOverview getTrusteeBillingOverview() {
        return trusteeBillingOverview;
    }

    @JsonProperty("TrusteeBillingOverview")
    public void setTrusteeBillingOverview(TrusteeBillingOverview trusteeBillingOverview) {
        this.trusteeBillingOverview = trusteeBillingOverview;
    }

    public Definitions withTrusteeBillingOverview(TrusteeBillingOverview trusteeBillingOverview) {
        this.trusteeBillingOverview = trusteeBillingOverview;
        return this;
    }

    @JsonProperty("Error")
    public Error getError() {
        return error;
    }

    @JsonProperty("Error")
    public void setError(Error error) {
        this.error = error;
    }

    public Definitions withError(Error error) {
        this.error = error;
        return this;
    }

    @JsonProperty("ErrorResponse")
    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }

    @JsonProperty("ErrorResponse")
    public void setErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
    }

    public Definitions withErrorResponse(ErrorResponse errorResponse) {
        this.errorResponse = errorResponse;
        return this;
    }

    @JsonProperty("Trustor")
    public Trustor getTrustor() {
        return trustor;
    }

    @JsonProperty("Trustor")
    public void setTrustor(Trustor trustor) {
        this.trustor = trustor;
    }

    public Definitions withTrustor(Trustor trustor) {
        this.trustor = trustor;
        return this;
    }

    @JsonProperty("Organization")
    public Organization__ getOrganization() {
        return organization;
    }

    @JsonProperty("Organization")
    public void setOrganization(Organization__ organization) {
        this.organization = organization;
    }

    public Definitions withOrganization(Organization__ organization) {
        this.organization = organization;
        return this;
    }

    @JsonProperty("TrustorEntityListing")
    public TrustorEntityListing getTrustorEntityListing() {
        return trustorEntityListing;
    }

    @JsonProperty("TrustorEntityListing")
    public void setTrustorEntityListing(TrustorEntityListing trustorEntityListing) {
        this.trustorEntityListing = trustorEntityListing;
    }

    public Definitions withTrustorEntityListing(TrustorEntityListing trustorEntityListing) {
        this.trustorEntityListing = trustorEntityListing;
        return this;
    }

}
