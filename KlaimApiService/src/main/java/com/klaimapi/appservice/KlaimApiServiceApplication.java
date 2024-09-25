package com.klaimapi.appservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.klaimapi.common")
public class KlaimApiServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(KlaimApiServiceApplication.class, args);
	}

}
