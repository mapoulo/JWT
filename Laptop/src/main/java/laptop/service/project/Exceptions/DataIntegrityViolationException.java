package laptop.service.project.Exceptions;

public class DataIntegrityViolationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8581161252046064195L;

	public DataIntegrityViolationException(String message) {
		super(message);
	}
}
