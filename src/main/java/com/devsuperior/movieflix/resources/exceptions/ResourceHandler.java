package com.devsuperior.movieflix.resources.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.movieflix.exceptions.DataBaseException;
import com.devsuperior.movieflix.exceptions.ForbiddenException;
import com.devsuperior.movieflix.exceptions.UnauthorizedException;

@ControllerAdvice
public class ResourceHandler {

	@ExceptionHandler(DataBaseException.class)
	public ResponseEntity<StandardError> dataBaseException(HttpServletRequest request, DataBaseException e){
		StandardError error = new StandardError();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Database Error!");
		error.setMessage(e.getMessage());
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> validation(HttpServletRequest request, MethodArgumentNotValidException e){
		ValidationError error = new ValidationError();
		HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;
		error.setTimestamp(Instant.now());
		error.setStatus(status.value());
		error.setError("Validation Error!");
		error.setMessage(e.getMessage());
		
		for(FieldError f: e.getBindingResult().getFieldErrors()) {
			error.addErrors(f.getField(), f.getDefaultMessage());
		}
		
		error.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(error);
	}

	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<OAuthCustomError> unauthorized(UnauthorizedException e, HttpServletRequest request){
		OAuthCustomError error = new OAuthCustomError();
		HttpStatus status = HttpStatus.UNAUTHORIZED;
		error.setError("Unauthorized!");
		error.setErrorDescription(e.getMessage());
		return ResponseEntity.status(status.value()).body(error);
	}

	@ExceptionHandler(ForbiddenException.class)
	public ResponseEntity<OAuthCustomError> forbidden(ForbiddenException e, HttpServletRequest request){
		OAuthCustomError error = new OAuthCustomError();
		HttpStatus status = HttpStatus.FORBIDDEN;
		error.setError("Forbidden Exception!");
		error.setErrorDescription(e.getMessage());
		return ResponseEntity.status(status).body(error);
	}
	
	
	
}
