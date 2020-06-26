package com.test.persona.service;

import com.test.persona.dto.PersonaDTO;

public interface PersonaService {
	PersonaDTO create(PersonaDTO body);

	PersonaDTO read(Integer id);

	Boolean update(PersonaDTO body);

	Boolean delete(Integer id);

}

