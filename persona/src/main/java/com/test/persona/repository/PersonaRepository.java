package com.test.persona.repository;

import org.springframework.data.repository.CrudRepository;

import com.test.persona.modelo.PersonaEntity;

public interface PersonaRepository extends CrudRepository<PersonaEntity, Integer> {

}

