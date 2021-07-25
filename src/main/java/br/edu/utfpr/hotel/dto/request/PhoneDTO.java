package br.edu.utfpr.hotel.dto.request;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import br.edu.utfpr.hotel.enums.PhoneType;

public class PhoneDTO {

	private Long id;

	@Enumerated(EnumType.STRING)
	private PhoneType type;

	@NotEmpty
	@Size(min = 13, max = 14)
	private String number;

	public PhoneDTO() {

	}

	public PhoneDTO(Long id, PhoneType type, @NotEmpty @Size(min = 13, max = 14) String number) {
		this.setId(id);
		this.type = type;
		this.number = number;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public PhoneType getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(PhoneType type) {
		this.type = type;
	}

	/**
	 * @return the number
	 */
	public String getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(String number) {
		this.number = number;
	}


}
