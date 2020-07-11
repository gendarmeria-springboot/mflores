package com.test.personaweb.feign.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaFeignResponse {
	private Integer id;
	private String rut;
	private String nombres;
	private String apellidos;
}

