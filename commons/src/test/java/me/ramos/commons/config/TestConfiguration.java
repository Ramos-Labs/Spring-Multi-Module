package me.ramos.commons.config;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "me.ramos.commons.domain")
@EnableJpaRepositories(basePackages = "me.ramos.commons.domain.repository")
public class TestConfiguration {

}
