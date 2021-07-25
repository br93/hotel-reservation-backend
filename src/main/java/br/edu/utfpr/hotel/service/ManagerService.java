package br.edu.utfpr.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.hotel.dto.request.ManagerDTO;
import br.edu.utfpr.hotel.dto.response.MessageResponseDTO;
import br.edu.utfpr.hotel.exception.ManagerNotFoundException;
import br.edu.utfpr.hotel.mapper.ManagerMapper;
import br.edu.utfpr.hotel.model.Manager;
import br.edu.utfpr.hotel.repository.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository managerRepository;
	
	private final ManagerMapper managerMapper = ManagerMapper.INSTANCE;
	

	public MessageResponseDTO createManager(ManagerDTO managerDTO) {
		Manager managerToSave = managerMapper.toModel(managerDTO);

		Manager savedManager = managerRepository.save(managerToSave);
		return createMessageResponse(savedManager.getId(), "Created manager with ID  ");
	}

	public List<ManagerDTO> listAll() {
		List<Manager> allmanager = managerRepository.findAll();
		return allmanager.stream().map(managerMapper::toDTO).collect(Collectors.toList());
	}

	public ManagerDTO findById(Long id) throws ManagerNotFoundException {
		Manager manager = verifyIfExists(id);

		return managerMapper.toDTO(manager);
	}

	public void delete(Long id) throws ManagerNotFoundException {
		verifyIfExists(id);

		managerRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, ManagerDTO managerDTO) throws ManagerNotFoundException {
		verifyIfExists(id);

		Manager managerToUpdate = managerMapper.toModel(managerDTO);

		Manager updatedManager = managerRepository.save(managerToUpdate);
		return createMessageResponse(updatedManager.getId(), "Updated manager with ID ");
	}

	private Manager verifyIfExists(Long id) throws ManagerNotFoundException {
		return managerRepository.findById(id).orElseThrow(() -> new ManagerNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder().message(message + id).build();
	}

	@Autowired
	public ManagerService(ManagerRepository managerRepository) {
		this.managerRepository = managerRepository;
	}


}
