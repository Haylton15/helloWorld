package com.haylton.devmedia.DevMedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages= {
    "com.haylton.devmedia.model"
})
@EnableJpaRepositories(basePackages = {
    "com.haylton.devmedia.repository"
})
public class DevMediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevMediaApplication.class, args);
	}
}
