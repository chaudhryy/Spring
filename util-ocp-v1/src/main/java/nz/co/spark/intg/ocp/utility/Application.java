package nz.co.spark.intg.ocp.utility;

import nz.co.spark.intg.ocp.utility.clbeans.DumpData;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.ServletWebServerFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import picocli.CommandLine;

//@EnableJpaRepositories("nz.co.spark.intg.ocp.utility")
@SpringBootApplication(exclude = {WebMvcAutoConfiguration.class, EmbeddedWebServerFactoryCustomizerAutoConfiguration.class, ServletWebServerFactoryAutoConfiguration.class})
//@EntityScan("nz.co.spark.intg.ocp.utility.ocp.db.model")
public class Application implements CommandLineRunner, ExitCodeGenerator {

    private CommandLine.IFactory factory;    // auto-configured to inject PicocliSpringFactory
    private DumpData myCommand; // your @picocli.CommandLine.Command-annotated class
    private int exitCode;

    // constructor injection
    Application(CommandLine.IFactory factory, DumpData myCommand) {
        this.factory = factory;
        this.myCommand = myCommand;
    }

    @Override
    public void run(String... args) {
        // let picocli parse command line args and run the business logic
        exitCode = new CommandLine(myCommand, factory).execute(args);
    }

    @Override
    public int getExitCode() {
        return exitCode;
    }

    public static void main(String[] args) {
        // let Spring instantiate and inject dependencies
        System.exit(SpringApplication.exit(SpringApplication.run(Application.class, args)));
    }


}