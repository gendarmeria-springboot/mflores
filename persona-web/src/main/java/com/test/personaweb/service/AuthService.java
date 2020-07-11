package com.test.personaweb.service;

import java.util.List;

import com.test.personaweb.dto.LoginDTO;
import com.test.personaweb.dto.ProfileDTO;
import com.test.personaweb.dto.TokenDTO;
import com.test.personaweb.exception.PersonaWebException;

public interface AuthService {
	TokenDTO login(LoginDTO body) throws PersonaWebException;

	List<ProfileDTO> getProfiles(String token);
}
