package br.edu.utfpr.hotel.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.utfpr.hotel.dto.request.CustomerDTO;
import br.edu.utfpr.hotel.model.Customer;

@Mapper
public interface CustomerMapper {

	CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

	Customer toModel(CustomerDTO managerDTO);

	CustomerDTO toDTO(Customer manager);

}
