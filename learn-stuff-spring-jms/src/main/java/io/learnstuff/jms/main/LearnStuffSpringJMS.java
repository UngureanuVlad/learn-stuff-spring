package io.learnstuff.jms.main;

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
public class LearnStuffSpringJMS {

  public static void main(String[] args) {
    SpringApplication.run(LearnStuffSpringJMS.class, args);
  }
}
