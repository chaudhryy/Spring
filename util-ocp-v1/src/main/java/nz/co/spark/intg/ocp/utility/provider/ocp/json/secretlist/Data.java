
package nz.co.spark.intg.ocp.utility.provider.ocp.json.secretlist;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "password",
    "username",
    "ALM_DB_PWD",
    "ALM_DB_UID",
    "AMQ_PASSWORD",
    "AMQ_USERNAME"
})
public class Data {

    @JsonProperty("password")
    private String password;
    @JsonProperty("username")
    private String username;
    @JsonProperty("ALM_DB_PWD")
    private String aLMDBPWD;
    @JsonProperty("ALM_DB_UID")
    private String aLMDBUID;
    @JsonProperty("AMQ_PASSWORD")
    private String aMQPASSWORD;
    @JsonProperty("AMQ_USERNAME")
    private String aMQUSERNAME;

    @JsonProperty("password")
    public String getPassword() {
        return password;
    }

    @JsonProperty("password")
    public void setPassword(String password) {
        this.password = password;
    }

    public Data withPassword(String password) {
        this.password = password;
        return this;
    }

    @JsonProperty("username")
    public String getUsername() {
        return username;
    }

    @JsonProperty("username")
    public void setUsername(String username) {
        this.username = username;
    }

    public Data withUsername(String username) {
        this.username = username;
        return this;
    }

    @JsonProperty("ALM_DB_PWD")
    public String getALMDBPWD() {
        return aLMDBPWD;
    }

    @JsonProperty("ALM_DB_PWD")
    public void setALMDBPWD(String aLMDBPWD) {
        this.aLMDBPWD = aLMDBPWD;
    }

    public Data withALMDBPWD(String aLMDBPWD) {
        this.aLMDBPWD = aLMDBPWD;
        return this;
    }

    @JsonProperty("ALM_DB_UID")
    public String getALMDBUID() {
        return aLMDBUID;
    }

    @JsonProperty("ALM_DB_UID")
    public void setALMDBUID(String aLMDBUID) {
        this.aLMDBUID = aLMDBUID;
    }

    public Data withALMDBUID(String aLMDBUID) {
        this.aLMDBUID = aLMDBUID;
        return this;
    }

    @JsonProperty("AMQ_PASSWORD")
    public String getAMQPASSWORD() {
        return aMQPASSWORD;
    }

    @JsonProperty("AMQ_PASSWORD")
    public void setAMQPASSWORD(String aMQPASSWORD) {
        this.aMQPASSWORD = aMQPASSWORD;
    }

    public Data withAMQPASSWORD(String aMQPASSWORD) {
        this.aMQPASSWORD = aMQPASSWORD;
        return this;
    }

    @JsonProperty("AMQ_USERNAME")
    public String getAMQUSERNAME() {
        return aMQUSERNAME;
    }

    @JsonProperty("AMQ_USERNAME")
    public void setAMQUSERNAME(String aMQUSERNAME) {
        this.aMQUSERNAME = aMQUSERNAME;
    }

    public Data withAMQUSERNAME(String aMQUSERNAME) {
        this.aMQUSERNAME = aMQUSERNAME;
        return this;
    }

}
