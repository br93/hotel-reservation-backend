package br.edu.utfpr.hotel.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.utfpr.hotel.dto.request.RoomDTO;
import br.edu.utfpr.hotel.dto.response.MessageResponseDTO;
import br.edu.utfpr.hotel.exception.RoomNotFoundException;
import br.edu.utfpr.hotel.mapper.RoomMapper;
import br.edu.utfpr.hotel.model.Room;
import br.edu.utfpr.hotel.repository.RoomRepository;

@Service
public class RoomService {

	@Autowired
	private RoomRepository roomRepository;

	private final RoomMapper roomMapper = RoomMapper.INSTANCE;

	public MessageResponseDTO createRoom(RoomDTO roomDTO) {
		Room roomToSave = roomMapper.toModel(roomDTO);

		Room savedRoom = roomRepository.save(roomToSave);
		return createMessageResponse(savedRoom.getId(), "Created room with ID  ");
	}

	public List<RoomDTO> listAll() {
		List<Room> allRooms = roomRepository.findAll();
		return allRooms.stream().map(roomMapper::toDTO).collect(Collectors.toList());
	}

	public RoomDTO findById(Long id) throws RoomNotFoundException {
		Room room = verifyIfExists(id);

		return roomMapper.toDTO(room);
	}

	public void delete(Long id) throws RoomNotFoundException {
		verifyIfExists(id);

		roomRepository.deleteById(id);
	}

	public MessageResponseDTO updateById(Long id, RoomDTO roomDTO) throws RoomNotFoundException {
		verifyIfExists(id);

		Room roomToUpdate = roomMapper.toModel(roomDTO);

		Room updatedRoom = roomRepository.save(roomToUpdate);
		return createMessageResponse(updatedRoom.getId(), "Updated room with ID ");
	}

	private Room verifyIfExists(Long id) throws RoomNotFoundException {
		return roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder().message(message + id).build();
	}

	@Autowired
	public RoomService(RoomRepository roomRepository) {
		this.roomRepository = roomRepository;
	}

}
