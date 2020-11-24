package io.learnstuff.mvc.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableAutoConfiguration
@SpringBootApplication
@ComponentScan(basePackages = "io.learnstuff")
@EnableWebMvc
@Configuration
public class LearnStuffSpringMVC {

  public static void main(String[] args) {
    SpringApplication.run(LearnStuffSpringMVC.class, args);
  }
}
