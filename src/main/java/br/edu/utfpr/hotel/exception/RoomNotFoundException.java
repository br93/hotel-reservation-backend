package br.edu.utfpr.hotel.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RoomNotFoundException extends Exception {

	public RoomNotFoundException(Long id) {
		super("Room not found with ID " + id);
	}

}
