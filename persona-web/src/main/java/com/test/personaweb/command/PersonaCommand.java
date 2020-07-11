package com.test.personaweb.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.personaweb.feign.client.PersonaFeignClient;
import com.test.personaweb.feign.request.PersonaFeignRequest;
import com.test.personaweb.feign.response.PersonaFeignResponse;
import com.test.personaweb.exception.PersonaWebException;
import com.test.personaweb.dto.PersonaDTO;
import com.test.personaweb.factory.Factory;

@Component
public class PersonaCommand {
    @Autowired
    private PersonaFeignClient personaFeignClient;
    
    @HystrixCommand(fallbackMethod = "personaError")
    public PersonaDTO create(PersonaFeignRequest personaFeignRequest) throws PersonaWebException {
  
	    ResponseEntity <PersonaFeignResponse> responseEntity = this.personaFeignClient.create(personaFeignRequest);
	        
	    return Factory.getPersonaDTO(responseEntity.getBody());
    	//return null;
    }
    
    public PersonaDTO personaError(PersonaFeignRequest personaFeignRequest) throws PersonaWebException {
        throw new PersonaWebException("Error en la comunicación con Persona MS", HttpStatus.NOT_FOUND);
    }
}

