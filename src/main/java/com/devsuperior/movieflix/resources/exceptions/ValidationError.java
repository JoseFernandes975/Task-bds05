package com.devsuperior.movieflix.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError{
	
	private static final long serialVersionUID = 1L;
	private List<FieldMessage> erros = new ArrayList<>();
	
	public ValidationError() {
	}

	public List<FieldMessage> getErros() {
		return erros;
	}
	
	public void addErrors(String fieldMessage, String message) {
		erros.add(new FieldMessage(fieldMessage, message));
	}
}
