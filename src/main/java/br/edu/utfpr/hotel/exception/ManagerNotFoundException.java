package br.edu.utfpr.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ManagerNotFoundException extends Exception {

	public ManagerNotFoundException(Long id) {
		super("Manager not found with ID " + id);
	}

}
