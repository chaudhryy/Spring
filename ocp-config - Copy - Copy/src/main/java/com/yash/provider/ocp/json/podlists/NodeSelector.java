
package com.yash.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "spark-env",
    "spark-role"
})
public class NodeSelector {

    @JsonProperty("spark-env")
    private String sparkEnv;
    @JsonProperty("spark-role")
    private String sparkRole;

    @JsonProperty("spark-env")
    public String getSparkEnv() {
        return sparkEnv;
    }

    @JsonProperty("spark-env")
    public void setSparkEnv(String sparkEnv) {
        this.sparkEnv = sparkEnv;
    }

    public NodeSelector withSparkEnv(String sparkEnv) {
        this.sparkEnv = sparkEnv;
        return this;
    }

    @JsonProperty("spark-role")
    public String getSparkRole() {
        return sparkRole;
    }

    @JsonProperty("spark-role")
    public void setSparkRole(String sparkRole) {
        this.sparkRole = sparkRole;
    }

    public NodeSelector withSparkRole(String sparkRole) {
        this.sparkRole = sparkRole;
        return this;
    }

}
