package com.test.personaweb.service;

import com.test.personaweb.dto.PersonaDTO;
import com.test.personaweb.exception.PersonaWebException;

public interface PersonaService {
	PersonaDTO create(PersonaDTO body) throws PersonaWebException;

}
