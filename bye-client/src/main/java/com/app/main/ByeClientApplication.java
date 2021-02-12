package com.app.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

@SpringBootApplication
@ComponentScan("com.app")
@EntityScan("com.app.modal")
@EnableJpaRepositories("com.app.repository")
public class ByeClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ByeClientApplication.class, args);
	}

}
