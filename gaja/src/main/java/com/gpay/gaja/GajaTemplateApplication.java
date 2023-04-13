package com.gpay.gaja;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.gpay.gaja.model.domain"})
@ComponentScan(basePackages = {"com.gpay.*"})
@EnableJpaRepositories(basePackages = {"com.gpay.gaja.model.repository"})
public class GajaTemplateApplication {

	public static void main(String[] args) {
		SpringApplication.run(GajaTemplateApplication.class, args);
	}

}
