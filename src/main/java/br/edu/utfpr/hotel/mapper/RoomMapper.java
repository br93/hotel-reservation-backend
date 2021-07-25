package br.edu.utfpr.hotel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.utfpr.hotel.dto.request.RoomDTO;
import br.edu.utfpr.hotel.model.Room;

@Mapper
public interface RoomMapper {

	RoomMapper INSTANCE = Mappers.getMapper(RoomMapper.class);

	Room toModel(RoomDTO managerDTO);

	RoomDTO toDTO(Room manager);

}
