package com.test.personaweb.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.personaweb.command.PersonaCommand;
import com.test.personaweb.dto.PersonaDTO;
import com.test.personaweb.feign.request.PersonaFeignRequest;
import com.test.personaweb.feign.response.PersonaFeignResponse;
import com.test.personaweb.service.PersonaService;

@Service
public class PersonaServiceImpl implements PersonaService{

	@Autowired
	private PersonaCommand personaCommand;

	@Override
	public PersonaDTO crea(PersonaDTO body) {

		PersonaFeignRequest request = new PersonaFeignRequest();
		request.setApellidos(body.getApellidos());
		request.setNombres(body.getNombres());
		request.setRut(body.getRut());
		request.setId(body.getId());
		
		PersonaFeignResponse response = this.personaCommand.crea(request);
		
		PersonaDTO persona = new PersonaDTO();
		persona.setApellidos(response.getApellidos());
		persona.setNombres(response.getNombres());
		persona.setRut(response.getRut());
		persona.setId(response.getId());
		
		return persona;
	}

}
