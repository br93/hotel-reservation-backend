package br.edu.utfpr.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

	public CustomerNotFoundException(Long id) {
		super("Customer not found with ID " + id);
	}

}
