package nz.co.spark.openshift.utility.mgmt;

import nz.co.spark.openshift.utility.mgmt.model.InputParameters;
import nz.co.spark.openshift.utility.mgmt.service.ApiAutomationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

import static java.lang.System.exit;

@SpringBootApplication
public class Application implements CommandLineRunner {


   private static Logger logger = LoggerFactory.getLogger("Application");


    @Autowired
    ApiAutomationService service;

    @Autowired
    InputParameters parameters;

    public static void main(String[] args) throws Exception {
        logger.debug("Initializing API Automation tool .......");
        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(Application.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        if( execute(args) == 0 ) {
            service.execute(parameters);
            logger.debug("Exiting API Automation tool gracefully");
            exit(0);
        }else{
            logger.debug("Exiting API Automation tool ungracefully");
            exit(-1);
        }

    }


    public int execute(String... args) {
        int returnCode = 0;
        CommandLine commandLine = new CommandLine(parameters);
        try {
            commandLine.parseArgs(args);
        } catch (CommandLine.ParameterException ex) {
            try {
                commandLine.getParameterExceptionHandler().handleParseException(ex, args);
            } catch (Exception ex2) {
                ex2.printStackTrace();
            }
            returnCode =1;
        }
        return  returnCode;

    }
}