package com.test.personaweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.personaweb.dto.PersonaDTO;
import com.test.personaweb.exception.PersonaWebException;
import com.test.personaweb.service.PersonaService;
@RestController
@RequestMapping(value = "/persona")
@CrossOrigin("*")
public class PersonaController {
	@Autowired
	private PersonaService personaService;
	
	//http://localhost:10000/auth/login : -> body {userName:<username>, password: <password>}
	@PostMapping(value = "/crea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonaDTO> create(@RequestBody PersonaDTO body) throws PersonaWebException {
		PersonaDTO persona = this.personaService.create(body);
		return ResponseEntity.ok(persona);
	}
}


