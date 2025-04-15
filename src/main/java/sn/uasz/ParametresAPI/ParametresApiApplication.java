package sn.uasz.ParametresAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJpaRepositories("sn.uasz.ParametresAPI.repository")
 // <-- Ajoute ceci
public class ParametresApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParametresApiApplication.class, args);
	}

}
