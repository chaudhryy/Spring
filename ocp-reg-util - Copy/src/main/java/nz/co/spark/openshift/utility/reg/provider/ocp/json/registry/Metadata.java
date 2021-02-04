
package nz.co.spark.openshift.utility.reg.provider.ocp.json.registry;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "selfLink"
})
public class Metadata {

    @JsonProperty("selfLink")
    private String selfLink;

    @JsonProperty("selfLink")
    public String getSelfLink() {
        return selfLink;
    }

    @JsonProperty("selfLink")
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

    public Metadata withSelfLink(String selfLink) {
        this.selfLink = selfLink;
        return this;
    }

}
