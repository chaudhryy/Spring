
package com.yash.provider.ocp.json.routelist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "app",
    "application",
    "xpaas"
})
public class Labels {

    @JsonProperty("app")
    private String app;
    @JsonProperty("application")
    private String application;
    @JsonProperty("xpaas")
    private String xpaas;

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

    @JsonProperty("application")
    public String getApplication() {
        return application;
    }

    @JsonProperty("application")
    public void setApplication(String application) {
        this.application = application;
    }

    public Labels withApplication(String application) {
        this.application = application;
        return this;
    }

    @JsonProperty("xpaas")
    public String getXpaas() {
        return xpaas;
    }

    @JsonProperty("xpaas")
    public void setXpaas(String xpaas) {
        this.xpaas = xpaas;
    }

    public Labels withXpaas(String xpaas) {
        this.xpaas = xpaas;
        return this;
    }

}
