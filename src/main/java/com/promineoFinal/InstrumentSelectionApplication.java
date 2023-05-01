package com.promineoFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("com.promineoFinal.model")
public class InstrumentSelectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstrumentSelectionApplication.class, args);
	}

}

