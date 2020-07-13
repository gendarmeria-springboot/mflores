package com.test.personaweb.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.personaweb.feign.client.PersonaFeignClient;
import com.test.personaweb.feign.request.PersonaFeignRequest;
import com.test.personaweb.feign.response.PersonaFeignResponse;

@Component
public class PersonaCommand {

	@Autowired
	private PersonaFeignClient personaFeignClient;

	@HystrixCommand
	public PersonaFeignResponse crea(PersonaFeignRequest request) {

		ResponseEntity<PersonaFeignResponse> response = this.personaFeignClient.crea(request);		
		return response.getBody();
	}

}
