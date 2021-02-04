
package com.yash.provider.ocp.json.routelist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "openshift.io/host.generated",
    "haproxy.router.openshift.io/balance",
    "haproxy.router.openshift.io/disable_cookies",
    "haproxy.router.openshift.io/timeout"
})
public class Annotations {

    @JsonProperty("openshift.io/host.generated")
    private String openshiftIoHostGenerated;
    @JsonProperty("haproxy.router.openshift.io/balance")
    private String haproxyRouterOpenshiftIoBalance;
    @JsonProperty("haproxy.router.openshift.io/disable_cookies")
    private String haproxyRouterOpenshiftIoDisableCookies;
    @JsonProperty("haproxy.router.openshift.io/timeout")
    private String haproxyRouterOpenshiftIoTimeout;

    @JsonProperty("openshift.io/host.generated")
    public String getOpenshiftIoHostGenerated() {
        return openshiftIoHostGenerated;
    }

    @JsonProperty("openshift.io/host.generated")
    public void setOpenshiftIoHostGenerated(String openshiftIoHostGenerated) {
        this.openshiftIoHostGenerated = openshiftIoHostGenerated;
    }

    public Annotations withOpenshiftIoHostGenerated(String openshiftIoHostGenerated) {
        this.openshiftIoHostGenerated = openshiftIoHostGenerated;
        return this;
    }

    @JsonProperty("haproxy.router.openshift.io/balance")
    public String getHaproxyRouterOpenshiftIoBalance() {
        return haproxyRouterOpenshiftIoBalance;
    }

    @JsonProperty("haproxy.router.openshift.io/balance")
    public void setHaproxyRouterOpenshiftIoBalance(String haproxyRouterOpenshiftIoBalance) {
        this.haproxyRouterOpenshiftIoBalance = haproxyRouterOpenshiftIoBalance;
    }

    public Annotations withHaproxyRouterOpenshiftIoBalance(String haproxyRouterOpenshiftIoBalance) {
        this.haproxyRouterOpenshiftIoBalance = haproxyRouterOpenshiftIoBalance;
        return this;
    }

    @JsonProperty("haproxy.router.openshift.io/disable_cookies")
    public String getHaproxyRouterOpenshiftIoDisableCookies() {
        return haproxyRouterOpenshiftIoDisableCookies;
    }

    @JsonProperty("haproxy.router.openshift.io/disable_cookies")
    public void setHaproxyRouterOpenshiftIoDisableCookies(String haproxyRouterOpenshiftIoDisableCookies) {
        this.haproxyRouterOpenshiftIoDisableCookies = haproxyRouterOpenshiftIoDisableCookies;
    }

    public Annotations withHaproxyRouterOpenshiftIoDisableCookies(String haproxyRouterOpenshiftIoDisableCookies) {
        this.haproxyRouterOpenshiftIoDisableCookies = haproxyRouterOpenshiftIoDisableCookies;
        return this;
    }

    @JsonProperty("haproxy.router.openshift.io/timeout")
    public String getHaproxyRouterOpenshiftIoTimeout() {
        return haproxyRouterOpenshiftIoTimeout;
    }

    @JsonProperty("haproxy.router.openshift.io/timeout")
    public void setHaproxyRouterOpenshiftIoTimeout(String haproxyRouterOpenshiftIoTimeout) {
        this.haproxyRouterOpenshiftIoTimeout = haproxyRouterOpenshiftIoTimeout;
    }

    public Annotations withHaproxyRouterOpenshiftIoTimeout(String haproxyRouterOpenshiftIoTimeout) {
        this.haproxyRouterOpenshiftIoTimeout = haproxyRouterOpenshiftIoTimeout;
        return this;
    }

}
