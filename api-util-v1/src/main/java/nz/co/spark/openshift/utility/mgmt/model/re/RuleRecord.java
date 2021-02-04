package nz.co.spark.openshift.utility.mgmt.model.re;

import java.util.StringJoiner;

public class RuleRecord {

    private String name;

    private String useCase;

    private String path;

    private String assertion;

    private String errorMessage;

    private boolean isSuccess;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUseCase() {
        return useCase;
    }

    public void setUseCase(String useCase) {
        this.useCase = useCase;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getAssertion() {
        return assertion;
    }

    public void setAssertion(String assertion) {
        this.assertion = assertion;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", RuleRecord.class.getSimpleName() + " [ ", " ]")
                .add("name='" + name + "'")
                .add("useCase='" + useCase + "'")
                .add("path='" + path + "'")
                .add("assertion='" + assertion + "'")
                .add("errorMessage='" + errorMessage + "'")
                .add("isSuccess=" + isSuccess)
                .toString();
    }
}
