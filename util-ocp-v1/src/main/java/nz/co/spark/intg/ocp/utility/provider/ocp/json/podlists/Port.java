
package nz.co.spark.intg.ocp.utility.provider.ocp.json.podlists;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "containerPort",
    "protocol"
})
public class Port {

    @JsonProperty("name")
    private String name;
    @JsonProperty("containerPort")
    private Long containerPort;
    @JsonProperty("protocol")
    private String protocol;

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Port withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("containerPort")
    public Long getContainerPort() {
        return containerPort;
    }

    @JsonProperty("containerPort")
    public void setContainerPort(Long containerPort) {
        this.containerPort = containerPort;
    }

    public Port withContainerPort(Long containerPort) {
        this.containerPort = containerPort;
        return this;
    }

    @JsonProperty("protocol")
    public String getProtocol() {
        return protocol;
    }

    @JsonProperty("protocol")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public Port withProtocol(String protocol) {
        this.protocol = protocol;
        return this;
    }

}
