package io.learnstuff.jms.main;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "io.learnstuff")
@EnableWebMvc
@EnableRabbit
@Configuration
public class LearnStuffSpringJMS {

    public static void main(String[] args) {
        SpringApplication.run(LearnStuffSpringJMS.class, args);
    }
}



