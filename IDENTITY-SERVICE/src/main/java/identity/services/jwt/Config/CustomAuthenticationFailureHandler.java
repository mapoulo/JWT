package identity.services.jwt.Config;

import java.io.IOException;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	
	 @Override
	    public void onAuthenticationFailure(
	            HttpServletRequest request,
	            HttpServletResponse response,
	            AuthenticationException exception
	    ) throws IOException, ServletException {
	        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Set the response status to 401
	        super.onAuthenticationFailure(request, response, exception);
	    }
	 
}
