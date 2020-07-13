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
import com.test.personaweb.service.PersonaService;

@RestController
@RequestMapping(value = "/persona")
@CrossOrigin("*")
public class PersonaController {

	@Autowired
	private PersonaService personaService;

	@PostMapping(value = "/crea", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PersonaDTO> crea(@RequestBody PersonaDTO body){ //throws ChallengeWebException {
		PersonaDTO persona = this.personaService.crea(body);
		return ResponseEntity.ok(persona);
	}
}
