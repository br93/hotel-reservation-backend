package br.edu.utfpr.hotel.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import br.edu.utfpr.hotel.model.Phone;
import br.edu.utfpr.hotel.model.Room;

public class CustomerDTO {

	private Long id;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String lastName;

	@NotEmpty
	private LocalDate birthDate;

	@NotEmpty
	@CPF
	private String cpf;

	@NotEmpty
	private String email;

	@Valid
	@NotEmpty
	private List<Phone> phones;

	@NotEmpty
	private String address;

	@NotEmpty
	@Size(min = 8, max = 64)
	private String password;

	@NotEmpty
	private double bill;

	private Room room;

	public CustomerDTO() {

	}

	public CustomerDTO(Long id, @NotEmpty @Size(min = 2, max = 50) String firstName,
			@NotEmpty @Size(min = 2, max = 50) String lastName, @NotEmpty LocalDate birthDate,
			@NotEmpty @CPF String cpf, @NotEmpty String email, @Valid @NotEmpty List<Phone> phones,
			@NotEmpty String address, @NotEmpty @Size(min = 8, max = 64) String password, @NotEmpty double bill,
			Room room) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.cpf = cpf;
		this.email = email;
		this.phones = phones;
		this.address = address;
		this.password = password;
		this.bill = bill;
		this.room = room;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Phone> getPhones() {
		return phones;
	}

	public void setPhones(List<Phone> phones) {
		this.phones = phones;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBill() {
		return bill;
	}

	public void setBill(double bill) {
		this.bill = bill;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

}
