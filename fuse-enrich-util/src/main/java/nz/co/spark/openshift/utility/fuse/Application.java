package nz.co.spark.openshift.utility.fuse;

import nz.co.spark.openshift.utility.fuse.service.FuseBusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static java.lang.System.exit;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    FuseBusinessService service;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(Application.class);
//        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);

    }

    @Override
    public void run(String... args) throws Exception {

        service.execute();
        exit(0);
    }

}