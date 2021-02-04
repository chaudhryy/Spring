//
//package nz.co.spark.openshift.utility.reg.model;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "title",
//    "content",
//    "error-content",
//    "version"
//})
//public class ActivityLog {
//
//    @JsonProperty("title")
//    private String title;
//    @JsonProperty("content")
//    private String content;
//    @JsonProperty("error-content")
//    private String errorContent;
//    @JsonProperty("version")
//    private String version;
//
//    @JsonProperty("title")
//    public String getTitle() {
//        return title;
//    }
//
//    @JsonProperty("title")
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public ActivityLog withTitle(String title) {
//        this.title = title;
//        return this;
//    }
//
//    @JsonProperty("content")
//    public String getContent() {
//        return content;
//    }
//
//    @JsonProperty("content")
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public ActivityLog withContent(String content) {
//        this.content = content;
//        return this;
//    }
//
//    @JsonProperty("error-content")
//    public String getErrorContent() {
//        return errorContent;
//    }
//
//    @JsonProperty("error-content")
//    public void setErrorContent(String errorContent) {
//        this.errorContent = errorContent;
//    }
//
//    public ActivityLog withErrorContent(String errorContent) {
//        this.errorContent = errorContent;
//        return this;
//    }
//
//    @JsonProperty("version")
//    public String getVersion() {
//        return version;
//    }
//
//    @JsonProperty("version")
//    public void setVersion(String version) {
//        this.version = version;
//    }
//
//    public ActivityLog withVersion(String version) {
//        this.version = version;
//        return this;
//    }
//
//}
