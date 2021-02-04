//
//package nz.co.spark.openshift.utility.reg.model;
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonPropertyOrder({
//    "activity-log",
//    "invoke"
//})
//public class Execute {
//
//    @JsonProperty("activity-log")
//    private ActivityLog activityLog;
//    @JsonProperty("invoke")
//    private Invoke invoke;
//
//    @JsonProperty("activity-log")
//    public ActivityLog getActivityLog() {
//        return activityLog;
//    }
//
//    @JsonProperty("activity-log")
//    public void setActivityLog(ActivityLog activityLog) {
//        this.activityLog = activityLog;
//    }
//
//    public Execute withActivityLog(ActivityLog activityLog) {
//        this.activityLog = activityLog;
//        return this;
//    }
//
//    @JsonProperty("invoke")
//    public Invoke getInvoke() {
//        return invoke;
//    }
//
//    @JsonProperty("invoke")
//    public void setInvoke(Invoke invoke) {
//        this.invoke = invoke;
//    }
//
//    public Execute withInvoke(Invoke invoke) {
//        this.invoke = invoke;
//        return this;
//    }
//
//}
