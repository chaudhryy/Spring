
package nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "secretName",
    "defaultMode"
})
public class Secret {

    @JsonProperty("secretName")
    private String secretName;
    @JsonProperty("defaultMode")
    private Long defaultMode;

    @JsonProperty("secretName")
    public String getSecretName() {
        return secretName;
    }

    @JsonProperty("secretName")
    public void setSecretName(String secretName) {
        this.secretName = secretName;
    }

    public Secret withSecretName(String secretName) {
        this.secretName = secretName;
        return this;
    }

    @JsonProperty("defaultMode")
    public Long getDefaultMode() {
        return defaultMode;
    }

    @JsonProperty("defaultMode")
    public void setDefaultMode(Long defaultMode) {
        this.defaultMode = defaultMode;
    }

    public Secret withDefaultMode(Long defaultMode) {
        this.defaultMode = defaultMode;
        return this;
    }

}
