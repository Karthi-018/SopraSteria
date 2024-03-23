package edu.training.DiscoveryServices1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServices1Application {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServices1Application.class, args);
	}

}
