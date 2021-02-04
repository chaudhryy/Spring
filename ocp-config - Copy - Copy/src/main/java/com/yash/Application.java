package com.yash;

import org.jline.utils.AttributedString;
import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.shell.jline.PromptProvider;

@SpringBootApplication(exclude = WebMvcAutoConfiguration.class)
public class Application {


    public static void main(String[] args) throws Exception {

        //disabled banner, don't want to see the spring logo
        SpringApplication.run(Application.class, args);

        //SpringApplication.run(SpringBootConsoleApplication.class, args);
    }

    @Bean
    public PromptProvider myPromptProvider() {
        return () -> new AttributedString("ocp-shell:>",
                AttributedStyle.DEFAULT.foreground(AttributedStyle.RED));
    }
}