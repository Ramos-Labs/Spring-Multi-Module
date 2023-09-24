package me.ramos.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
        scanBasePackages = { "me.ramos.api", "me.ramos.commons" }
)
@EntityScan("me.ramos.commons.domain")
@EnableJpaRepositories(basePackages = "me.ramos.commons.domain.repository")
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

}
