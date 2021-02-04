package com.yash;

import com.yash.beans.InputReader;
import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

import static java.lang.System.exit;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class Application implements CommandLineRunner {

    @Autowired
    private InputReader inputReader;

    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication app = new SpringApplication(Application.class);
        app.run(args);
//        SpringApplication.run(Application.class, args);

        //SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("ocp-shell:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
    }

    @Override
    public void run(String... args) throws Exception {
        String username = this.inputReader.prompt("Username");
        String password = this.inputReader.prompt("Password", false);
        System.out.println("Username : " + username + " Password : " + password);

    }
}