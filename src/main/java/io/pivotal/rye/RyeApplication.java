package io.pivotal.rye;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class RyeApplication {

	public static void main(String[] args) {
		SpringApplication.run(RyeApplication.class, args);
	}
}
