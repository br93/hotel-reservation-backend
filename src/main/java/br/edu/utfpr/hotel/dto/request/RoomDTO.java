package br.edu.utfpr.hotel.dto.request;

import javax.validation.constraints.NotEmpty;

import br.edu.utfpr.hotel.model.Customer;

public class RoomDTO {

	private Long id;

	@NotEmpty
	private int number;

	@NotEmpty
	private String type;

	@NotEmpty
	private boolean available;

	private Customer customer;

	public RoomDTO() {

	}

	public RoomDTO(Long id, @NotEmpty int number, @NotEmpty String type, @NotEmpty boolean available,
			Customer customer) {
		this.id = id;
		this.number = number;
		this.type = type;
		this.available = available;
		this.customer = customer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
