package br.edu.utfpr.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.hotel.dto.request.CustomerDTO;
import br.edu.utfpr.hotel.dto.response.MessageResponseDTO;
import br.edu.utfpr.hotel.exception.CustomerNotFoundException;
import br.edu.utfpr.hotel.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	private CustomerService customerService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
		return customerService.createCustomer(customerDTO);
	}

	@GetMapping
	public List<CustomerDTO> listAll() {
		return customerService.listAll();
	}

	@GetMapping("/{id}")
	public CustomerDTO findById(@PathVariable Long id) throws CustomerNotFoundException {
		return customerService.findById(id);
	}

	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid CustomerDTO customerDTO)
			throws CustomerNotFoundException {
		return customerService.updateById(id, customerDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws CustomerNotFoundException {
		customerService.delete(id);
	}

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}


}
