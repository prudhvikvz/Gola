package com.example.vt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class VtApplication {

	public static void main(String[] args) {
		SpringApplication.run(VtApplication.class, args);
	}

}
