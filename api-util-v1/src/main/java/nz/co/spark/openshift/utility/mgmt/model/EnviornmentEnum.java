package nz.co.spark.openshift.utility.mgmt.model;

public enum EnviornmentEnum {

    STG("STG","integration.stg.url"),
    INT02("INT02","integration.int02.url");

    private String urlProperty;
    private String envTag;

    EnviornmentEnum(String envTag, String urlProperty){
        this.envTag = envTag;
        this.urlProperty = urlProperty;
    }

}
