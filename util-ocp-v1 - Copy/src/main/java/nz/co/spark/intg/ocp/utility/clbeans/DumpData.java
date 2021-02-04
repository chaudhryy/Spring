package nz.co.spark.intg.ocp.utility.clbeans;

import nz.co.spark.intg.ocp.utility.model.EnvType;
import org.springframework.stereotype.Component;
import picocli.CommandLine;

@Component
@CommandLine.Command(name="ocpReportingUtil",version = "Scala picocli demo v4.0",mixinStandardHelpOptions = true ,description = "@|bold Spark-Util|@@| underline OCP | @ example")
public class DumpData {

    private  final static String OCP_LABEL ="OCP";

    @CommandLine.Parameters(description = "Environment  Type",paramLabel = OCP_LABEL)
    EnvType envType;


}
