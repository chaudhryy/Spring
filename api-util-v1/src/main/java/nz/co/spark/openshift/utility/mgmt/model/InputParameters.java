package nz.co.spark.openshift.utility.mgmt.model;

import org.springframework.stereotype.Component;
import picocli.CommandLine;

import java.io.File;
import java.util.StringJoiner;


@Component
@CommandLine.Command(name = "Execution Variables", mixinStandardHelpOptions = true, version = "Update-Variables 1.0",
        description = "Execute the target API test Cases using the following options")
public class InputParameters {

    @CommandLine.Option(names={"-n","--name"},description = "Unique name for the execution", required = true)
    private String name;

    @CommandLine.Option(names={"-i","--dataFile"},description = "Input CSV data file absolute path", required = true)
    private File dataFile;

    @CommandLine.Option(names={"-t","--templateDirectory"},description="Template Directory ", required = true)
    private File templateDirectory;

//    @CommandLine.Option(names={"-e","--env"},description = "Target Enviornment ,Allowed values : ${COMPLETION-CANDIDATES}", required = true)
//    private EnviornmentEnum enviornment;

    @CommandLine.Option(names={"-u","--targetUrl"},description = " Target Url", required = true)
    private String url;

    @CommandLine.Option(names = {"-r","--rule"},description = "Rule Validation File", required = false)
    private File ruleFile;

    @CommandLine.Option(names = {"-m","--httpMethod"},description = "Http Method ", required = true)
    private String httpMethod;

    @CommandLine.Option(names = {"-c","--contentType"},description = "Content Type ", required = true)
    private String contentType;

    @CommandLine.Option(names = {"-th","--threads"},description = "Number of parallel Threads", required = true)
    private int threads;

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public File getDataFile() {
        return dataFile;
    }

    public int getThreads() {
        return threads;
    }

    public void setThreads(int threads) {
        this.threads = threads;
    }

    public void setDataFile(File dataFile) {
        this.dataFile = dataFile;
    }

    public File getTemplateDirectory() {
        return templateDirectory;
    }

    public void setTemplateDirectory(File templateDirectory) {
        this.templateDirectory = templateDirectory;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public File getRuleFile() {
        return ruleFile;
    }

    public void setRuleFile(File ruleFile) {
        this.ruleFile = ruleFile;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", InputParameters.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("dataFile=" + dataFile)
                .add("templateDirectory=" + templateDirectory)
                .add("url='" + url + "'")
                .add("ruleFile=" + ruleFile)
                .add("httpMethod='" + httpMethod + "'")
                .add("contentType='" + contentType + "'")
                .add("threads=" + threads)
                .toString();
    }
}
