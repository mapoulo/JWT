package identity.services.jwt.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import identity.services.jwt.Config.AuthConfig;
import identity.services.jwt.Entity.User;
import identity.services.jwt.Exceptions.DataIntegrityViolationException;
import identity.services.jwt.Repositories.UserRepo;
import jakarta.transaction.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Autowired
	private JwtService jwtService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional
	public User saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		User myUser = null;
		try {
			myUser = userRepo.save(user);
		} catch (Exception e) {
			throw new DataIntegrityViolationException("Data integrity violation: " + e.getMessage());
		}
		
		return myUser;
	}
	
	
	public String generateToken(String username) {
		return jwtService.generateToken(username);
	}
	
	
	public void validateToken(String toke) {
		jwtService.validateToken(toke);
	}
	
	
	
	

}
