package br.edu.utfpr.hotel.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class ManagerDTO {

	private Long id;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String firstName;

	@NotEmpty
	@Size(min = 2, max = 50)
	private String lastName;

	@NotEmpty
	private String email;

	@NotEmpty
	@Size(min = 8, max = 64)
	private String password;

	public ManagerDTO() {

	}

	public ManagerDTO(Long id, @NotEmpty @Size(min = 2, max = 50) String firstName,
			@NotEmpty @Size(min = 2, max = 50) String lastName, @NotEmpty String email,
			@NotEmpty @Size(min = 8, max = 64) String password) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
