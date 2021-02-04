
package nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "key"
})
public class SecretKeyRef {

    @JsonProperty("name")
    private String name;
    @JsonProperty("key")
    private String key;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public SecretKeyRef withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("key")
    public void setKey(String key) {
        this.key = key;
    }

    public SecretKeyRef withKey(String key) {
        this.key = key;
        return this;
    }

}
