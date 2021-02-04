//
//package nz.co.spark.openshift.utility.reg.model;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "value",
//    "description",
//    "encoded"
//})
//public class FuseEndpoint {
//
//    @JsonProperty("value")
//    private String value;
//    @JsonProperty("description")
//    private String description;
//    @JsonProperty("encoded")
//    private Boolean encoded;
//
//    @JsonProperty("value")
//    public String getValue() {
//        return value;
//    }
//
//    @JsonProperty("value")
//    public void setValue(String value) {
//        this.value = value;
//    }
//
//    public FuseEndpoint withValue(String value) {
//        this.value = value;
//        return this;
//    }
//
//    @JsonProperty("description")
//    public String getDescription() {
//        return description;
//    }
//
//    @JsonProperty("description")
//    public void setDescription(String description) {
//        this.description = description;
//    }
//
//    public FuseEndpoint withDescription(String description) {
//        this.description = description;
//        return this;
//    }
//
//    @JsonProperty("encoded")
//    public Boolean getEncoded() {
//        return encoded;
//    }
//
//    @JsonProperty("encoded")
//    public void setEncoded(Boolean encoded) {
//        this.encoded = encoded;
//    }
//
//    public FuseEndpoint withEncoded(Boolean encoded) {
//        this.encoded = encoded;
//        return this;
//    }
//
//}
