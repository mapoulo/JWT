package gateway.service.project.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class MissingAuthorizationHeaderException extends RuntimeException{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1510603950350115838L;

	public MissingAuthorizationHeaderException(String message) {
		super(message);
	}

}
