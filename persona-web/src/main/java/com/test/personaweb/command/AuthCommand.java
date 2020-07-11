package com.test.personaweb.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.test.personaweb.dto.TokenDTO;
import com.test.personaweb.exception.PersonaWebException;
import com.test.personaweb.factory.Factory;
import com.test.personaweb.feign.client.AuthFeignClient;
import com.test.personaweb.feign.request.LoginFeignRequest;
import com.test.personaweb.feign.response.TokenFeignResponse;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class AuthCommand {
	@Autowired
	private AuthFeignClient authFeignClient;

	//@HystrixCommand(fallbackMethod = "loginError")
	public TokenDTO login(LoginFeignRequest loginFeignRequest) throws PersonaWebException {

		// Invocando al end point auth/login -> (ms auth)
		ResponseEntity<TokenFeignResponse> responseEntity = this.authFeignClient.login(loginFeignRequest);

		// Obteniendo el json de respuesta (DTO) del endpoint auth/login -> (ms auth)
		TokenFeignResponse tokenFeingResponse = responseEntity.getBody();

		// Retorno del mapeo de respuesta al service.
		return Factory.getTokenDTO(tokenFeingResponse);
	}

	public TokenDTO loginError(LoginFeignRequest loginFeignRequest) throws PersonaWebException {
		throw new PersonaWebException("Error en la comunicación con Auth MS", HttpStatus.NOT_FOUND);
	}
}

