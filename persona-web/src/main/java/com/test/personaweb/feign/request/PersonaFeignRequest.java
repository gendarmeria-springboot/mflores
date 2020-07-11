package com.test.personaweb.feign.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaFeignRequest {
	private Integer id;
	private String rut;
	private String nombres;
	private String apellidos;
}
