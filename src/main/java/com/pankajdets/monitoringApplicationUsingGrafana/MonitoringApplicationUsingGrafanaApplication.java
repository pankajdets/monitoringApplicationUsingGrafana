package com.pankajdets.monitoringApplicationUsingGrafana;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info= @Info(
				title = "API Documentation for Employee Management System",
				description = "Springboot Application for Employee Management System.",
				version= "v1.0.0"
		)
)
@SpringBootApplication
public class MonitoringApplicationUsingGrafanaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitoringApplicationUsingGrafanaApplication.class, args);
	}

}
