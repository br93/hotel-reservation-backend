package br.edu.utfpr.hotel.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
	
	@RequestMapping("/status")
	public String viewStatus() {
		return "online";
	}

}