
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "secretKeyRef"
})
public class ValueFrom {

    @JsonProperty("secretKeyRef")
    private SecretKeyRef secretKeyRef;

    @JsonProperty("secretKeyRef")
    public SecretKeyRef getSecretKeyRef() {
        return secretKeyRef;
    }

    @JsonProperty("secretKeyRef")
    public void setSecretKeyRef(SecretKeyRef secretKeyRef) {
        this.secretKeyRef = secretKeyRef;
    }

    public ValueFrom withSecretKeyRef(SecretKeyRef secretKeyRef) {
        this.secretKeyRef = secretKeyRef;
        return this;
    }

}
