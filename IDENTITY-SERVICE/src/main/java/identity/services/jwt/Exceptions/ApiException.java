package identity.services.jwt.Exceptions;

import java.time.ZonedDateTime;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiException {
	
	private String message;
	private HttpStatus status;
	private ZonedDateTime dateTime;
	
}
