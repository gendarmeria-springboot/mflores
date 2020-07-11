package com.test.personaweb.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.personaweb.command.AuthCommand;
import com.test.personaweb.dto.LoginDTO;
import com.test.personaweb.dto.ProfileDTO;
import com.test.personaweb.dto.TokenDTO;
import com.test.personaweb.exception.PersonaWebException;
import com.test.personaweb.factory.Factory;
import com.test.personaweb.feign.request.LoginFeignRequest;
import com.test.personaweb.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService {
	@Autowired
	private AuthCommand authCommand;

	@Override
	public TokenDTO login(LoginDTO body) throws PersonaWebException {

		// Mapeo a DTO del MS de destino (LoginDTO(ms challenge-web) -> LoginDTO(ms
		// auth)
		LoginFeignRequest loginFeignRequest = Factory.getLoginFeignRequest(body);

		// Invocando al MS AUTH a través de HystrixCommand
		TokenDTO response = this.authCommand.login(loginFeignRequest);

		// retorno al controlador
		return response;
	}

	@Override
	public List<ProfileDTO> getProfiles(String token) {
		// TODO Auto-generated method stub
		return null;
	}
}

