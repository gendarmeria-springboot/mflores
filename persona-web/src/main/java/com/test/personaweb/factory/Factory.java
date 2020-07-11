package com.test.personaweb.factory;

import com.test.personaweb.dto.LoginDTO;
import com.test.personaweb.dto.PersonaDTO;
import com.test.personaweb.dto.TokenDTO;
import com.test.personaweb.feign.request.LoginFeignRequest;
import com.test.personaweb.feign.request.PersonaFeignRequest;
import com.test.personaweb.feign.response.PersonaFeignResponse;
import com.test.personaweb.feign.response.TokenFeignResponse;


public class Factory {

	public static PersonaFeignRequest getPersonaFeignRequest(PersonaDTO personadto) {
		if (personadto == null) {
			return null;
		}
		
		PersonaFeignRequest response = new PersonaFeignRequest();
		response.setId(personadto.getId());
		response.setRut(personadto.getRun());
		response.setNombres(personadto.getNombres());
		response.setApellidos(personadto.getApellidos());		
		return response;
	}
	
	public static PersonaDTO getPersonaDTO(PersonaFeignResponse personadto) {
		if (personadto == null) {
			return null;
		}
		
		PersonaDTO response = new PersonaDTO();
		response.setId(personadto.getId());
		response.setRun(personadto.getRut());
		response.setNombres(personadto.getNombres());
		response.setApellidos(personadto.getApellidos());		
		return response;
	}
	
	public static LoginFeignRequest getLoginFeignRequest(LoginDTO login) {
		if (login == null) {
			return null;
		}
		LoginFeignRequest response = new LoginFeignRequest();
		response.setPassword(login.getPassword());
		response.setUserName(login.getUserName());
		return response;
	}

	public static TokenDTO getTokenDTO(TokenFeignResponse token) {
		if (token == null) {
			return null;
		}
		TokenDTO response = new TokenDTO();
		response.setToken(token.getToken());
		return response;
	}

}

