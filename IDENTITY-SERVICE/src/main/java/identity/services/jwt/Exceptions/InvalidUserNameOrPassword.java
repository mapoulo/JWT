package identity.services.jwt.Exceptions;

//@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class InvalidUserNameOrPassword  extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2169659033807998279L;
	
	public InvalidUserNameOrPassword(String message) {
		super(message);
	}

}
