package com.test.personaweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaDTO {
	private Integer id;
	private String run;
	private String nombres;
	private String apellidos;	
}

