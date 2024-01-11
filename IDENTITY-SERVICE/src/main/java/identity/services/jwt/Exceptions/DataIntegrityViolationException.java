package identity.services.jwt.Exceptions;

public class DataIntegrityViolationException extends RuntimeException{

	public DataIntegrityViolationException(String message) {
		super(message);
	}
}
