package com.devsuperior.movieflix.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.exceptions.ForbiddenException;
import com.devsuperior.movieflix.exceptions.UnauthorizedException;
import com.devsuperior.movieflix.repositories.UserRepository;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository repositoryUser;

	public User authenticated() {
		try {
		String userLog = SecurityContextHolder.getContext().getAuthentication().getName();
	    User user = repositoryUser.findByEmail(userLog);
	    System.out.println("USER ID:" +user.getId());
	    return user;
		}catch(Exception e) {
			throw new UnauthorizedException("Unauthorizaded  "+e.getMessage());
		}
	}
	
	
	public void validateUserIsMemberAndSelf(Long id) {
		User user = authenticated();
		if(!user.getId().equals(id) &&  !user.hasRole("ROLE_MEMBER")) {
			throw new ForbiddenException("Forbidden Exception! Not permission!");
		}
	}
	
}
