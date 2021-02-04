package nz.co.spark.openshift.utility.reg.model;

import java.util.Calendar;
import java.util.StringJoiner;

public class ResponseOCPAuthToken {

    private String accessToken;

    private Calendar expiresIn;

    private String tokenType;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Calendar getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        Integer val = Integer.parseInt(expiresIn);
        Calendar newExpiresIn = Calendar.getInstance();
        newExpiresIn.add(Calendar.SECOND,val);

        this.expiresIn = newExpiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", ResponseOCPAuthToken.class.getSimpleName() + "[", "]")
                .add("accessToken='" + accessToken + "'")
                .add("expiresIn=" + expiresIn)
                .add("tokenType='" + tokenType + "'")
                .toString();
    }
}
