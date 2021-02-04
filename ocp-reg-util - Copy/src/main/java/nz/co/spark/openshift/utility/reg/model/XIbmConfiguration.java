//
//package nz.co.spark.openshift.utility.reg.model;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "testable",
//    "enforced",
//    "cors",
//    "assembly",
//    "phase",
//    "properties",
//    "catalogs"
//})
//public class XIbmConfiguration {
//
//    @JsonProperty("testable")
//    private Boolean testable;
//    @JsonProperty("enforced")
//    private Boolean enforced;
//    @JsonProperty("cors")
//    private Cors cors;
//    @JsonProperty("assembly")
//    private Assembly assembly;
//    @JsonProperty("phase")
//    private String phase;
//    @JsonProperty("properties")
//    private Properties properties;
//    @JsonProperty("catalogs")
//    private Catalogs catalogs;
//
//    @JsonProperty("testable")
//    public Boolean getTestable() {
//        return testable;
//    }
//
//    @JsonProperty("testable")
//    public void setTestable(Boolean testable) {
//        this.testable = testable;
//    }
//
//    public XIbmConfiguration withTestable(Boolean testable) {
//        this.testable = testable;
//        return this;
//    }
//
//    @JsonProperty("enforced")
//    public Boolean getEnforced() {
//        return enforced;
//    }
//
//    @JsonProperty("enforced")
//    public void setEnforced(Boolean enforced) {
//        this.enforced = enforced;
//    }
//
//    public XIbmConfiguration withEnforced(Boolean enforced) {
//        this.enforced = enforced;
//        return this;
//    }
//
//    @JsonProperty("cors")
//    public Cors getCors() {
//        return cors;
//    }
//
//    @JsonProperty("cors")
//    public void setCors(Cors cors) {
//        this.cors = cors;
//    }
//
//    public XIbmConfiguration withCors(Cors cors) {
//        this.cors = cors;
//        return this;
//    }
//
//    @JsonProperty("assembly")
//    public Assembly getAssembly() {
//        return assembly;
//    }
//
//    @JsonProperty("assembly")
//    public void setAssembly(Assembly assembly) {
//        this.assembly = assembly;
//    }
//
//    public XIbmConfiguration withAssembly(Assembly assembly) {
//        this.assembly = assembly;
//        return this;
//    }
//
//    @JsonProperty("phase")
//    public String getPhase() {
//        return phase;
//    }
//
//    @JsonProperty("phase")
//    public void setPhase(String phase) {
//        this.phase = phase;
//    }
//
//    public XIbmConfiguration withPhase(String phase) {
//        this.phase = phase;
//        return this;
//    }
//
//    @JsonProperty("properties")
//    public Properties getProperties() {
//        return properties;
//    }
//
//    @JsonProperty("properties")
//    public void setProperties(Properties properties) {
//        this.properties = properties;
//    }
//
//    public XIbmConfiguration withProperties(Properties properties) {
//        this.properties = properties;
//        return this;
//    }
//
//    @JsonProperty("catalogs")
//    public Catalogs getCatalogs() {
//        return catalogs;
//    }
//
//    @JsonProperty("catalogs")
//    public void setCatalogs(Catalogs catalogs) {
//        this.catalogs = catalogs;
//    }
//
//    public XIbmConfiguration withCatalogs(Catalogs catalogs) {
//        this.catalogs = catalogs;
//        return this;
//    }
//
//}
