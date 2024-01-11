package identity.services.jwt.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import identity.services.jwt.DTO.UserDto;
import identity.services.jwt.Entity.User;
import identity.services.jwt.Exceptions.InvalidUserNameOrPassword;
import identity.services.jwt.Services.UserService;

@RestController
@RequestMapping("/auth")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationManager authenticationManager;

	
	
	@PostMapping("/register")
	public ResponseEntity<Object> registerUser(@RequestBody User user) {
			userService.saveUser(user);
			return ResponseEntity.ok("Entity created successfully");	
	}

	
	@PostMapping("/requestToken")
	public String requestToken(@RequestBody UserDto user) {
		Authentication auth = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(user.getName(), user.getPassword()));		
			if (auth.isAuthenticated()) {
				return userService.generateToken(user.getName());
			} else {
				throw new InvalidUserNameOrPassword("Invalid Username or Password");
			}

	}

	
	
	@GetMapping("/validateToken")
	public String validateToken(@RequestParam("token") String token) {
		userService.validateToken(token);
		return "Token is Valid";
	}
	
	
	
	
	
	
	

}
