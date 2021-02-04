package nz.co.spark.intg.ocp.utility.model;

import picocli.CommandLine;
@CommandLine.Command(name="login")
public class InputParams {

    private  final static String OCP_LABEL ="OCP";

    @CommandLine.Option(names = "-a",description=" Describes the Execution Type",paramLabel = OCP_LABEL)
    ExecutionTypeEnum executionTypeName;

    @CommandLine.Parameters(description = "Environment  Type",paramLabel = OCP_LABEL)
    EnvType envType;

    @CommandLine.Option(names="-d" ,description = "Working Directory temp DB",paramLabel = OCP_LABEL)
    String operationDirectory;

//    String
}
