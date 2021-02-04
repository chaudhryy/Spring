
package nz.co.spark.intg.ocp.utility.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "get"
})
public class BillinqryV1OrganisationIdBillingoverview {

    @JsonProperty("get")
    private Get get;

    @JsonProperty("get")
    public Get getGet() {
        return get;
    }

    @JsonProperty("get")
    public void setGet(Get get) {
        this.get = get;
    }

    public BillinqryV1OrganisationIdBillingoverview withGet(Get get) {
        this.get = get;
        return this;
    }

}
