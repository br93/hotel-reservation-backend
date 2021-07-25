package br.edu.utfpr.hotel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.utfpr.hotel.dto.request.ManagerDTO;
import br.edu.utfpr.hotel.model.Manager;

@Mapper
public interface ManagerMapper {

	ManagerMapper INSTANCE = Mappers.getMapper(ManagerMapper.class);

	Manager toModel(ManagerDTO managerDTO);

	ManagerDTO toDTO(Manager manager);
}
