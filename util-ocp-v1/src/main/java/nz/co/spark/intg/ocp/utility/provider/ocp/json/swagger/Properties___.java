
package nz.co.spark.intg.ocp.utility.provider.ocp.json.swagger;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "errorCode",
    "errorDesc"
})
public class Properties___ {

    @JsonProperty("errorCode")
    private ErrorCode errorCode;
    @JsonProperty("errorDesc")
    private ErrorDesc errorDesc;

    @JsonProperty("errorCode")
    public ErrorCode getErrorCode() {
        return errorCode;
    }

    @JsonProperty("errorCode")
    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    public Properties___ withErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    @JsonProperty("errorDesc")
    public ErrorDesc getErrorDesc() {
        return errorDesc;
    }

    @JsonProperty("errorDesc")
    public void setErrorDesc(ErrorDesc errorDesc) {
        this.errorDesc = errorDesc;
    }

    public Properties___ withErrorDesc(ErrorDesc errorDesc) {
        this.errorDesc = errorDesc;
        return this;
    }

}
