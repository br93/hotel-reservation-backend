package br.edu.utfpr.hotel.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.edu.utfpr.hotel.enums.PhoneType;

@Entity
@Table(name = "phone")
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private PhoneType type;

	@Column(nullable = false)
	private String number;

	/**
	 * Constructor for Phone.java
	 */
	public Phone() {

	}

	/**
	 * Constructor for Phone.java
	 *
	 * @param id
	 * @param type
	 * @param number
	 */
	public Phone(Long id, PhoneType type, String number) {
		this.id = id;
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
