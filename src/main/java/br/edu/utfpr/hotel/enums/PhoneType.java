package br.edu.utfpr.hotel.enums;

//@Getter
//@AllArgsConstructor
public enum PhoneType {

	HOME("Home"), MOBILE("Mobile"), COMMERCIAL("Commercial");

	private final String description;

	/**
	 * 
	 * Constructor of the class PhoneType.
	 * 
	 * @param description
	 */
	private PhoneType(String description) {
		this.description = description;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

}
