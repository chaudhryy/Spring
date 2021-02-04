
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "organization",
    "currency",
    "enabledProducts",
    "subscriptionType",
    "rampPeriodStartDate",
    "rampPeriodEndDate",
    "billingPeriodStartDate",
    "billingPeriodEndDate",
    "usages",
    "contractAmendmentDate",
    "contractEffectiveDate",
    "contractEndDate",
    "inRampPeriod",
    "selfUri"
})
public class Properties__ {

    @JsonProperty("id")
    private Id_ id;
    @JsonProperty("name")
    private Name_ name;
    @JsonProperty("organization")
    private Organization organization;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("enabledProducts")
    private EnabledProducts enabledProducts;
    @JsonProperty("subscriptionType")
    private SubscriptionType subscriptionType;
    @JsonProperty("rampPeriodStartDate")
    private RampPeriodStartDate rampPeriodStartDate;
    @JsonProperty("rampPeriodEndDate")
    private RampPeriodEndDate rampPeriodEndDate;
    @JsonProperty("billingPeriodStartDate")
    private BillingPeriodStartDate billingPeriodStartDate;
    @JsonProperty("billingPeriodEndDate")
    private BillingPeriodEndDate billingPeriodEndDate;
    @JsonProperty("usages")
    private Usages usages;
    @JsonProperty("contractAmendmentDate")
    private ContractAmendmentDate contractAmendmentDate;
    @JsonProperty("contractEffectiveDate")
    private ContractEffectiveDate contractEffectiveDate;
    @JsonProperty("contractEndDate")
    private ContractEndDate contractEndDate;
    @JsonProperty("inRampPeriod")
    private InRampPeriod inRampPeriod;
    @JsonProperty("selfUri")
    private SelfUri selfUri;

    @JsonProperty("id")
    public Id_ getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id_ id) {
        this.id = id;
    }

    public Properties__ withId(Id_ id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public Name_ getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(Name_ name) {
        this.name = name;
    }

    public Properties__ withName(Name_ name) {
        this.name = name;
        return this;
    }

    @JsonProperty("organization")
    public Organization getOrganization() {
        return organization;
    }

    @JsonProperty("organization")
    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Properties__ withOrganization(Organization organization) {
        this.organization = organization;
        return this;
    }

    @JsonProperty("currency")
    public Currency getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Properties__ withCurrency(Currency currency) {
        this.currency = currency;
        return this;
    }

    @JsonProperty("enabledProducts")
    public EnabledProducts getEnabledProducts() {
        return enabledProducts;
    }

    @JsonProperty("enabledProducts")
    public void setEnabledProducts(EnabledProducts enabledProducts) {
        this.enabledProducts = enabledProducts;
    }

    public Properties__ withEnabledProducts(EnabledProducts enabledProducts) {
        this.enabledProducts = enabledProducts;
        return this;
    }

    @JsonProperty("subscriptionType")
    public SubscriptionType getSubscriptionType() {
        return subscriptionType;
    }

    @JsonProperty("subscriptionType")
    public void setSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
    }

    public Properties__ withSubscriptionType(SubscriptionType subscriptionType) {
        this.subscriptionType = subscriptionType;
        return this;
    }

    @JsonProperty("rampPeriodStartDate")
    public RampPeriodStartDate getRampPeriodStartDate() {
        return rampPeriodStartDate;
    }

    @JsonProperty("rampPeriodStartDate")
    public void setRampPeriodStartDate(RampPeriodStartDate rampPeriodStartDate) {
        this.rampPeriodStartDate = rampPeriodStartDate;
    }

    public Properties__ withRampPeriodStartDate(RampPeriodStartDate rampPeriodStartDate) {
        this.rampPeriodStartDate = rampPeriodStartDate;
        return this;
    }

    @JsonProperty("rampPeriodEndDate")
    public RampPeriodEndDate getRampPeriodEndDate() {
        return rampPeriodEndDate;
    }

    @JsonProperty("rampPeriodEndDate")
    public void setRampPeriodEndDate(RampPeriodEndDate rampPeriodEndDate) {
        this.rampPeriodEndDate = rampPeriodEndDate;
    }

    public Properties__ withRampPeriodEndDate(RampPeriodEndDate rampPeriodEndDate) {
        this.rampPeriodEndDate = rampPeriodEndDate;
        return this;
    }

    @JsonProperty("billingPeriodStartDate")
    public BillingPeriodStartDate getBillingPeriodStartDate() {
        return billingPeriodStartDate;
    }

    @JsonProperty("billingPeriodStartDate")
    public void setBillingPeriodStartDate(BillingPeriodStartDate billingPeriodStartDate) {
        this.billingPeriodStartDate = billingPeriodStartDate;
    }

    public Properties__ withBillingPeriodStartDate(BillingPeriodStartDate billingPeriodStartDate) {
        this.billingPeriodStartDate = billingPeriodStartDate;
        return this;
    }

    @JsonProperty("billingPeriodEndDate")
    public BillingPeriodEndDate getBillingPeriodEndDate() {
        return billingPeriodEndDate;
    }

    @JsonProperty("billingPeriodEndDate")
    public void setBillingPeriodEndDate(BillingPeriodEndDate billingPeriodEndDate) {
        this.billingPeriodEndDate = billingPeriodEndDate;
    }

    public Properties__ withBillingPeriodEndDate(BillingPeriodEndDate billingPeriodEndDate) {
        this.billingPeriodEndDate = billingPeriodEndDate;
        return this;
    }

    @JsonProperty("usages")
    public Usages getUsages() {
        return usages;
    }

    @JsonProperty("usages")
    public void setUsages(Usages usages) {
        this.usages = usages;
    }

    public Properties__ withUsages(Usages usages) {
        this.usages = usages;
        return this;
    }

    @JsonProperty("contractAmendmentDate")
    public ContractAmendmentDate getContractAmendmentDate() {
        return contractAmendmentDate;
    }

    @JsonProperty("contractAmendmentDate")
    public void setContractAmendmentDate(ContractAmendmentDate contractAmendmentDate) {
        this.contractAmendmentDate = contractAmendmentDate;
    }

    public Properties__ withContractAmendmentDate(ContractAmendmentDate contractAmendmentDate) {
        this.contractAmendmentDate = contractAmendmentDate;
        return this;
    }

    @JsonProperty("contractEffectiveDate")
    public ContractEffectiveDate getContractEffectiveDate() {
        return contractEffectiveDate;
    }

    @JsonProperty("contractEffectiveDate")
    public void setContractEffectiveDate(ContractEffectiveDate contractEffectiveDate) {
        this.contractEffectiveDate = contractEffectiveDate;
    }

    public Properties__ withContractEffectiveDate(ContractEffectiveDate contractEffectiveDate) {
        this.contractEffectiveDate = contractEffectiveDate;
        return this;
    }

    @JsonProperty("contractEndDate")
    public ContractEndDate getContractEndDate() {
        return contractEndDate;
    }

    @JsonProperty("contractEndDate")
    public void setContractEndDate(ContractEndDate contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Properties__ withContractEndDate(ContractEndDate contractEndDate) {
        this.contractEndDate = contractEndDate;
        return this;
    }

    @JsonProperty("inRampPeriod")
    public InRampPeriod getInRampPeriod() {
        return inRampPeriod;
    }

    @JsonProperty("inRampPeriod")
    public void setInRampPeriod(InRampPeriod inRampPeriod) {
        this.inRampPeriod = inRampPeriod;
    }

    public Properties__ withInRampPeriod(InRampPeriod inRampPeriod) {
        this.inRampPeriod = inRampPeriod;
        return this;
    }

    @JsonProperty("selfUri")
    public SelfUri getSelfUri() {
        return selfUri;
    }

    @JsonProperty("selfUri")
    public void setSelfUri(SelfUri selfUri) {
        this.selfUri = selfUri;
    }

    public Properties__ withSelfUri(SelfUri selfUri) {
        this.selfUri = selfUri;
        return this;
    }

}
