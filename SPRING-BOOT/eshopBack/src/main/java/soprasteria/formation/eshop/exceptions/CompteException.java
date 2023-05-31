package soprasteria.formation.eshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST)
public class CompteException extends RuntimeException {
	public CompteException() {

	}

	public CompteException(String message) {
		super(message);
	}
}
