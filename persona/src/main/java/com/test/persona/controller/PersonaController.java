package com.test.persona.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.persona.dto.PersonaDTO;
import com.test.persona.service.PersonaService;


@RestController
@RequestMapping(value = "/persona")
@CrossOrigin("*")

public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@PostMapping(value="/crea",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PersonaDTO> create(@RequestBody PersonaDTO body) {
        PersonaDTO response = this.personaService.create(body);
        return new ResponseEntity<PersonaDTO>(response, HttpStatus.CREATED);
    }
	
	/*@GetMapping(value="/lista", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<InmateDTO>> read() {
        List<InmateDTO> response = this.inmateService.read();
        
        return new ResponseEntity<List<InmateDTO>>(response, HttpStatus.OK);
    }
    
    @DeleteMapping(value="/eliminar/{idParam}", produces = MediaType.APPLICATION_JSON_VALUE )
    public ResponseEntity<String> eliminar( @PathVariable(required = false) int idParam) {
        try {
            this.inmateService.delete(idParam);
        } catch(EmptyResultDataAccessException e) {
            return new ResponseEntity<String>("{status:\"Registro no existe\"}", HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<String>("{status:\"SUCCESS\"}", HttpStatus.OK);
    }*/
	
}
