package com.test.personaweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class PersonaWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonaWebApplication.class, args);
	}

}