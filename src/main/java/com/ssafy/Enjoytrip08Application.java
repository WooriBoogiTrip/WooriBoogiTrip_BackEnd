package com.ssafy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Enjoytrip08Application {

	public static void main(String[] args) {
		SpringApplication.run(Enjoytrip08Application.class, args);
	}

}
