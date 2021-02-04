
package nz.co.spark.intg.ocp.utility.provider.ocp.json.projectlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "openshift.io/description",
    "openshift.io/display-name",
    "openshift.io/node-selector",
    "openshift.io/sa.scc.mcs",
    "openshift.io/sa.scc.supplemental-groups",
    "openshift.io/sa.scc.uid-range"
})
public class Annotations {

    @JsonProperty("openshift.io/description")
    private String openshiftIoDescription;
    @JsonProperty("openshift.io/display-name")
    private String openshiftIoDisplayName;
    @JsonProperty("openshift.io/node-selector")
    private String openshiftIoNodeSelector;
    @JsonProperty("openshift.io/sa.scc.mcs")
    private String openshiftIoSaSccMcs;
    @JsonProperty("openshift.io/sa.scc.supplemental-groups")
    private String openshiftIoSaSccSupplementalGroups;
    @JsonProperty("openshift.io/sa.scc.uid-range")
    private String openshiftIoSaSccUidRange;

    @JsonProperty("openshift.io/description")
    public String getOpenshiftIoDescription() {
        return openshiftIoDescription;
    }

    @JsonProperty("openshift.io/description")
    public void setOpenshiftIoDescription(String openshiftIoDescription) {
        this.openshiftIoDescription = openshiftIoDescription;
    }

    public Annotations withOpenshiftIoDescription(String openshiftIoDescription) {
        this.openshiftIoDescription = openshiftIoDescription;
        return this;
    }

    @JsonProperty("openshift.io/display-name")
    public String getOpenshiftIoDisplayName() {
        return openshiftIoDisplayName;
    }

    @JsonProperty("openshift.io/display-name")
    public void setOpenshiftIoDisplayName(String openshiftIoDisplayName) {
        this.openshiftIoDisplayName = openshiftIoDisplayName;
    }

    public Annotations withOpenshiftIoDisplayName(String openshiftIoDisplayName) {
        this.openshiftIoDisplayName = openshiftIoDisplayName;
        return this;
    }

    @JsonProperty("openshift.io/node-selector")
    public String getOpenshiftIoNodeSelector() {
        return openshiftIoNodeSelector;
    }

    @JsonProperty("openshift.io/node-selector")
    public void setOpenshiftIoNodeSelector(String openshiftIoNodeSelector) {
        this.openshiftIoNodeSelector = openshiftIoNodeSelector;
    }

    public Annotations withOpenshiftIoNodeSelector(String openshiftIoNodeSelector) {
        this.openshiftIoNodeSelector = openshiftIoNodeSelector;
        return this;
    }

    @JsonProperty("openshift.io/sa.scc.mcs")
    public String getOpenshiftIoSaSccMcs() {
        return openshiftIoSaSccMcs;
    }

    @JsonProperty("openshift.io/sa.scc.mcs")
    public void setOpenshiftIoSaSccMcs(String openshiftIoSaSccMcs) {
        this.openshiftIoSaSccMcs = openshiftIoSaSccMcs;
    }

    public Annotations withOpenshiftIoSaSccMcs(String openshiftIoSaSccMcs) {
        this.openshiftIoSaSccMcs = openshiftIoSaSccMcs;
        return this;
    }

    @JsonProperty("openshift.io/sa.scc.supplemental-groups")
    public String getOpenshiftIoSaSccSupplementalGroups() {
        return openshiftIoSaSccSupplementalGroups;
    }

    @JsonProperty("openshift.io/sa.scc.supplemental-groups")
    public void setOpenshiftIoSaSccSupplementalGroups(String openshiftIoSaSccSupplementalGroups) {
        this.openshiftIoSaSccSupplementalGroups = openshiftIoSaSccSupplementalGroups;
    }

    public Annotations withOpenshiftIoSaSccSupplementalGroups(String openshiftIoSaSccSupplementalGroups) {
        this.openshiftIoSaSccSupplementalGroups = openshiftIoSaSccSupplementalGroups;
        return this;
    }

    @JsonProperty("openshift.io/sa.scc.uid-range")
    public String getOpenshiftIoSaSccUidRange() {
        return openshiftIoSaSccUidRange;
    }

    @JsonProperty("openshift.io/sa.scc.uid-range")
    public void setOpenshiftIoSaSccUidRange(String openshiftIoSaSccUidRange) {
        this.openshiftIoSaSccUidRange = openshiftIoSaSccUidRange;
    }

    public Annotations withOpenshiftIoSaSccUidRange(String openshiftIoSaSccUidRange) {
        this.openshiftIoSaSccUidRange = openshiftIoSaSccUidRange;
        return this;
    }

}
