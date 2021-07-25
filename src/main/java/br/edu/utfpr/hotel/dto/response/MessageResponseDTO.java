package br.edu.utfpr.hotel.dto.response;

public class MessageResponseDTO {

	private final String message;

	/**
	 * Constructor for MessageResponseDTO
	 *
	 * @param messageResponseDTOBuilder
	 */
	private MessageResponseDTO(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	public static class Builder {

		private String message;

		public Builder message(String message) {
			this.message = message;
			return this;
		}

		public Builder withMessage(String message) {
			this.message = message;
			return this;
		}

		public MessageResponseDTO build() {
			return new MessageResponseDTO(message);
		}

	}

	public static Builder builder() {
		return new Builder();
	}

}
