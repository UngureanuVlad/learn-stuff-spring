package io.learnstuff.security.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@ComponentScan(basePackages = "io.learnstuff")
@EnableWebMvc
@EnableTransactionManagement
@EnableSpringDataWebSupport
@EntityScan(basePackages = "io.learnstuff")
@EnableJpaRepositories(basePackages = "io.learnstuff")
@EnableWebSecurity
@Configuration
public class LearnStuffSpringSecurity {

    public static void main(String[] args) {
        SpringApplication.run(LearnStuffSpringSecurity.class, args);
    }
}
