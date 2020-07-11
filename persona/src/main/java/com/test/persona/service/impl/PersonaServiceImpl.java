package com.test.persona.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.persona.dto.PersonaDTO;
import com.test.persona.factory.Factory;
import com.test.persona.modelo.PersonaEntity;
import com.test.persona.repository.PersonaRepository;
import com.test.persona.service.PersonaService;

@Service

public class PersonaServiceImpl implements PersonaService {
	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public PersonaDTO create(PersonaDTO body) {
		PersonaEntity personaEntityNew = Factory.getPersonaEntity(body);
		PersonaEntity personaEntity = this.personaRepository.save(personaEntityNew);
		return Factory.getPersonaDTO(personaEntity);
	}
	
	@Override
    public PersonaDTO read(int id) {
        Optional<PersonaEntity> personaEntity = this.personaRepository.findById(id);  
       
        return  Factory.getPersonaDTO(personaEntity.get());
    }
		
	@Override
	public Boolean update(PersonaDTO body) {
		PersonaEntity entity = Factory.getPersonaEntity(body);
		PersonaEntity personaEntity = this.personaRepository.save(entity);
		if (personaEntity == null) {
			return false;
		}
		return true;
	} 

	@Override
	public Boolean delete(int id) {
		this.personaRepository.deleteById(id);
		return true;
	}

}

