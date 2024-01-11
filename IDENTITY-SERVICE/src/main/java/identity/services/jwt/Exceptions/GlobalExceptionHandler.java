package identity.services.jwt.Exceptions;

import java.time.ZoneId;
import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
		ApiException apiExcetion = new ApiException(ex.getMessage(), HttpStatus.BAD_REQUEST, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiExcetion, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidUserNameOrPassword.class)
	public ResponseEntity<Object> handleInvalidAccessException(InvalidUserNameOrPassword ex) {
		ApiException apiExcetion = new ApiException(ex.getMessage(), HttpStatus.UNAUTHORIZED, ZonedDateTime.now(ZoneId.of("Z")));
		return new ResponseEntity<>(apiExcetion, HttpStatus.UNAUTHORIZED);
	}

}
