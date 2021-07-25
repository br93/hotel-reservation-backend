package br.edu.utfpr.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.hotel.dto.request.CustomerDTO;
import br.edu.utfpr.hotel.dto.response.MessageResponseDTO;
import br.edu.utfpr.hotel.exception.CustomerNotFoundException;
import br.edu.utfpr.hotel.mapper.CustomerMapper;

import br.edu.utfpr.hotel.model.Customer;
import br.edu.utfpr.hotel.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;

	public MessageResponseDTO createCustomer(CustomerDTO customerDTO) {
		Customer customerToSave = customerMapper.toModel(customerDTO);

		Customer savedCustomer = customerRepository.save(customerToSave);
		return createMessageResponse(savedCustomer.getId(), "Created room with ID  ");
	}

	public List<CustomerDTO> listAll() {
		List<Customer> allRooms = customerRepository.findAll();
		return allRooms.stream().map(customerMapper::toDTO).collect(Collectors.toList());
	}

	public CustomerDTO findById(Long id) throws CustomerNotFoundException {
		Customer customer = verifyIfExists(id);

		return customerMapper.toDTO(customer);
	}

	public void delete(Long id) throws CustomerNotFoundException {
		verifyIfExists(id);

		customerRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, CustomerDTO customerDTO) throws CustomerNotFoundException {
		verifyIfExists(id);

		Customer customerToUpdate = customerMapper.toModel(customerDTO);

		Customer updatedCustomer = customerRepository.save(customerToUpdate);
		return createMessageResponse(updatedCustomer.getId(), "Updated room with ID ");
	}

	private Customer verifyIfExists(Long id) throws CustomerNotFoundException {
		return customerRepository.findById(id).orElseThrow(() -> new CustomerNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder().message(message + id).build();
	}

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

}
