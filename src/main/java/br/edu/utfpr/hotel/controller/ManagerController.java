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

import br.edu.utfpr.hotel.dto.request.ManagerDTO;
import br.edu.utfpr.hotel.dto.response.MessageResponseDTO;
import br.edu.utfpr.hotel.exception.ManagerNotFoundException;
import br.edu.utfpr.hotel.service.ManagerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/manager")
public class ManagerController {
	

	private ManagerService managerService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createManager(@RequestBody @Valid ManagerDTO managerDTO) {
		return managerService.createManager(managerDTO);
	}

	@GetMapping
	public List<ManagerDTO> listAll() {
		return managerService.listAll();
	}

	@GetMapping("/{id}")
	public ManagerDTO findById(@PathVariable Long id) throws ManagerNotFoundException {
		return managerService.findById(id);
	}

	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid ManagerDTO managerDTO)
			throws ManagerNotFoundException {
		return managerService.updateById(id, managerDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws ManagerNotFoundException {
		managerService.delete(id);
	}

	@Autowired
	public ManagerController(ManagerService managerService) {
		this.managerService = managerService;
	}


}
