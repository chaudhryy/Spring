
package nz.co.spark.openshift.utility.fuse.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "openshift.io/generated-by"
})
public class Annotations_ {

    @JsonProperty("openshift.io/generated-by")
    private String openshiftIoGeneratedBy;

    @JsonProperty("openshift.io/generated-by")
    public String getOpenshiftIoGeneratedBy() {
        return openshiftIoGeneratedBy;
    }

    @JsonProperty("openshift.io/generated-by")
    public void setOpenshiftIoGeneratedBy(String openshiftIoGeneratedBy) {
        this.openshiftIoGeneratedBy = openshiftIoGeneratedBy;
    }

    public Annotations_ withOpenshiftIoGeneratedBy(String openshiftIoGeneratedBy) {
        this.openshiftIoGeneratedBy = openshiftIoGeneratedBy;
        return this;
    }

}
