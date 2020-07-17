package com.test.personaweb.factory;

import com.test.personaweb.dto.PersonaDTO;
import com.test.personaweb.feign.request.PersonaFeignRequest;
import com.test.personaweb.feign.response.PersonaFeignResponse;

public class Factory {
	public static PersonaFeignRequest getPersonaFeignRequest(PersonaDTO persona) {
		if (persona == null) {
			return null;
		}
		PersonaFeignRequest response = new PersonaFeignRequest();
		response.setApellidos(persona.getApellidos());
		response.setNombres(persona.getNombres());
		response.setRut(persona.getRut());
		response.setId(persona.getId());
		
		return response;
	}

	public static PersonaFeignResponse getPersonaDTO(PersonaFeignResponse personaFeignResponse) {
		if (personaFeignResponse == null) {
			return null;
		}
		
		PersonaFeignResponse response = new PersonaFeignResponse();
		response.setApellidos(personaFeignResponse.getApellidos());
		response.setNombres(personaFeignResponse.getNombres());
		response.setRut(personaFeignResponse.getRut());
		response.setId(personaFeignResponse.getId());
		
		return response;
	}
}