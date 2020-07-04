package com.test.persona.service;

import com.test.persona.dto.PersonaDTO;

public interface PersonaService {
	PersonaDTO create(PersonaDTO body);

	PersonaDTO read(int id);

	Boolean update(PersonaDTO body);

	Boolean delete(int id);

}

