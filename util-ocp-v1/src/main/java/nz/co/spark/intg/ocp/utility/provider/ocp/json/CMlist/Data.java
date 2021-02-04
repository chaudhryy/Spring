
package nz.co.spark.intg.ocp.utility.provider.ocp.json.CMlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "application.properties"
})
public class Data {

    @JsonProperty("application.properties")
    private String applicationProperties;

    @JsonProperty("application.properties")
    public String getApplicationProperties() {
        return applicationProperties;
    }

    @JsonProperty("application.properties")
    public void setApplicationProperties(String applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    public Data withApplicationProperties(String applicationProperties) {
        this.applicationProperties = applicationProperties;
        return this;
    }

}
