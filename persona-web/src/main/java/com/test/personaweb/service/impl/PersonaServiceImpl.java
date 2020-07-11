package com.test.personaweb.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.personaweb.command.PersonaCommand;
import com.test.personaweb.dto.PersonaDTO;
import com.test.personaweb.exception.PersonaWebException;
import com.test.personaweb.factory.Factory;
import com.test.personaweb.feign.request.PersonaFeignRequest;
import com.test.personaweb.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaCommand personaCommand;

	@Override
	public PersonaDTO create(PersonaDTO body) throws PersonaWebException {

		// Mapeo a DTO del MS de destino (LoginDTO(ms challenge-web) -> LoginDTO(ms
		// auth)
		PersonaFeignRequest personaFeignRequest = Factory.getPersonaFeignRequest(body);

		// Invocando al MS AUTH a través de HystrixCommand
		PersonaDTO response = this.personaCommand.create(personaFeignRequest);

		// retorno al controlador
		return response;
	}
}
