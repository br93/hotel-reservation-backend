package br.edu.utfpr.hotel.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.utfpr.hotel.dto.request.RoomDTO;
import br.edu.utfpr.hotel.dto.response.MessageResponseDTO;
import br.edu.utfpr.hotel.exception.RoomNotFoundException;
import br.edu.utfpr.hotel.service.RoomService;

@RestController
@RequestMapping("/room")
public class RoomController {

	private RoomService roomService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createRoom(@RequestBody @Valid RoomDTO roomDTO) {
		return roomService.createRoom(roomDTO);
	}

	@GetMapping
	public List<RoomDTO> listAll() {
		return roomService.listAll();
	}

	@GetMapping("/{id}")
	public RoomDTO findById(@PathVariable Long id) throws RoomNotFoundException {
		return roomService.findById(id);
	}

	@PutMapping("/{id}")
	public MessageResponseDTO updateById(@PathVariable Long id, @RequestBody @Valid RoomDTO roomDTO)
			throws RoomNotFoundException {
		return roomService.updateById(id, roomDTO);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws RoomNotFoundException {
		roomService.delete(id);
	}

	@Autowired
	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}

}
