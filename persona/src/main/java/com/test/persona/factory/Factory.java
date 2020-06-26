package com.test.persona.factory;

import com.test.persona.dto.PersonaDTO;
import com.test.persona.modelo.PersonaEntity;

public class Factory {
	public static PersonaEntity getPersonaEntity(PersonaDTO body) {
		if (body == null) {
			return null;
		}
		
		PersonaEntity response = new PersonaEntity();
		response.setId(body.getId());
		response.setRut(body.getRut());
		response.setNombres(body.getNombres());
		response.setApellidos(body.getApellidos());
		return response;		
	}
	
	public static PersonaDTO getPersonaDTO(PersonaEntity personaEntity) {
		if (personaEntity == null) {
			return null;
		}
		PersonaDTO response = new PersonaDTO();
		response.setId(personaEntity.getId());
		response.setRut(personaEntity.getRut());
		response.setNombres(personaEntity.getNombres());
		response.setApellidos(personaEntity.getApellidos());
		return response;
	}
}


