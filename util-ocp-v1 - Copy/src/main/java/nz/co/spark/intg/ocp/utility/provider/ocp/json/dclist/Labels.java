
package nz.co.spark.intg.ocp.utility.provider.ocp.json.dclist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app"
})
public class Labels {

    @JsonProperty("app")
    private String app;

    @JsonProperty("app")
    public String getApp() {
        return app;
    }

    @JsonProperty("app")
    public void setApp(String app) {
        this.app = app;
    }

    public Labels withApp(String app) {
        this.app = app;
        return this;
    }

}
