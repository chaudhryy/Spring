
package com.yash.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "/billinqry/v1/organisation/{id}/billingoverview",
    "/billinqry/v1/organisation/list"
})
public class Paths {

    @JsonProperty("/billinqry/v1/organisation/{id}/billingoverview")
    private BillinqryV1OrganisationIdBillingoverview billinqryV1OrganisationIdBillingoverview;
    @JsonProperty("/billinqry/v1/organisation/list")
    private BillinqryV1OrganisationList billinqryV1OrganisationList;

    @JsonProperty("/billinqry/v1/organisation/{id}/billingoverview")
    public BillinqryV1OrganisationIdBillingoverview getBillinqryV1OrganisationIdBillingoverview() {
        return billinqryV1OrganisationIdBillingoverview;
    }

    @JsonProperty("/billinqry/v1/organisation/{id}/billingoverview")
    public void setBillinqryV1OrganisationIdBillingoverview(BillinqryV1OrganisationIdBillingoverview billinqryV1OrganisationIdBillingoverview) {
        this.billinqryV1OrganisationIdBillingoverview = billinqryV1OrganisationIdBillingoverview;
    }

    public Paths withBillinqryV1OrganisationIdBillingoverview(BillinqryV1OrganisationIdBillingoverview billinqryV1OrganisationIdBillingoverview) {
        this.billinqryV1OrganisationIdBillingoverview = billinqryV1OrganisationIdBillingoverview;
        return this;
    }

    @JsonProperty("/billinqry/v1/organisation/list")
    public BillinqryV1OrganisationList getBillinqryV1OrganisationList() {
        return billinqryV1OrganisationList;
    }

    @JsonProperty("/billinqry/v1/organisation/list")
    public void setBillinqryV1OrganisationList(BillinqryV1OrganisationList billinqryV1OrganisationList) {
        this.billinqryV1OrganisationList = billinqryV1OrganisationList;
    }

    public Paths withBillinqryV1OrganisationList(BillinqryV1OrganisationList billinqryV1OrganisationList) {
        this.billinqryV1OrganisationList = billinqryV1OrganisationList;
        return this;
    }

}
