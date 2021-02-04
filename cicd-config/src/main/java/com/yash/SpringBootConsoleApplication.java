package com.yash;

import com.yash.service.AppEnvService;
import com.yash.service.CicdApplicationEnviornmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import picocli.CommandLine;

import static java.lang.System.exit;

@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {

//    @Autowired
//    private AppEnvService appEnvService;

    @Autowired
    private CicdApplicationEnviornmentService appEnvService;
    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(SpringBootConsoleApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

        //SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        int exitCode = new CommandLine(appEnvService).execute(args);
//        if (args.length<3){
//            System.out.println("Updating XMX");
//            appEnvService.updateXmx(args[0],args[1]);
//
//        }else  {
//            appEnvService.prepareConfig(args[0],args[1],args[2]);
//        }

        exit(0);
    }
}