package com.api.safectech.publicationservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@OpenAPIDefinition
@SpringBootApplication
@EnableJpaAuditing
@EnableEurekaClient
public class PublicationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicationserviceApplication.class, args);
	}

}
