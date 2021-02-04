//
//package nz.co.spark.openshift.utility.reg.model;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "Staging",
//    "Development"
//})
//public class Catalogs {
//
//    @JsonProperty("Staging")
//    private Staging staging;
//
//    @JsonProperty("Development")
//    private Development development;
//
//    @JsonProperty("Development")
//    public Development getDevelopment() {
//        return development;
//    }
//
//    @JsonProperty("Development")
//    public void setDevelopment(Development development) {
//        this.development = development;
//    }
//
//    @JsonProperty("Staging")
//    public Staging getStaging() {
//        return staging;
//    }
//
//    @JsonProperty("Staging")
//    public void setStaging(Staging staging) {
//        this.staging = staging;
//    }
//
//    public Catalogs withStaging(Staging staging) {
//        this.staging = staging;
//        return this;
//    }
//
//}
