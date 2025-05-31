package io.learnstuff.rest.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "io.learnstuff")
@EnableWebMvc
@Configuration
public class LearnStuffSpringREST {

    public static void main(String[] args) {
        SpringApplication.run(LearnStuffSpringREST.class, args);
    }
}
