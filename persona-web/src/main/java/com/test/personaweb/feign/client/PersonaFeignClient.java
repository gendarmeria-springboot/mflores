package com.test.personaweb.feign.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.personaweb.feign.request.PersonaFeignRequest;
import com.test.personaweb.feign.response.PersonaFeignResponse;

@FeignClient(name = "persona")
public interface PersonaFeignClient {
	// Llamando al endpoint login del controlador auth del ms auth.
	@PostMapping(value = "/persona/crea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonaFeignResponse> create(@RequestBody PersonaFeignRequest body);


}