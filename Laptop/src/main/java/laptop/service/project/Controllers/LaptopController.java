package laptop.service.project.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import laptop.service.project.Dto.LaptopDto;
import laptop.service.project.Entities.Laptop;
import laptop.service.project.Exceptions.UnAuthorizedException;
import laptop.service.project.Services.LaptopService;
import laptop.service.project.Utils.JwtUtil;



@RestController
@RequestMapping("/laptop")
public class LaptopController {
	
	
	@Autowired
	private LaptopService laptopService;
	@Autowired
	private JwtUtil jwtUtil;
	
	
	
	
	
	
	
	@Operation(summary = "Save Laptop", description = "Save a Laptop", tags = "Post")
	@ApiResponses(
			value = {@ApiResponse(responseCode = "200", description = "Laptop Saved Successfully", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Laptop.class))}),
					@ApiResponse(responseCode = "404", description = "Laptops Not Saved", content = @Content)}
			)
	@PostMapping("/saveLaptop")
	public Laptop saveLaptop(@RequestBody LaptopDto laptop, @RequestHeader("Token") String token)throws org.springframework.web.bind.MissingRequestHeaderException {
		System.out.println("The user name is : "+ token);
		Laptop myLaptop = null;
		try {
			jwtUtil.validateToken(token);
			myLaptop =  laptopService.saveLaptop(new Laptop(0,laptop.getName()));
		} catch (Exception e) {
			throw new UnAuthorizedException("Invalid Token: "+e);
		}
			return myLaptop;
			
	}
	
	
	
	
	
	
	
	
	@Operation(summary = "Get Laptops", description = "Get list of laptops", tags = "Get")
	@ApiResponses(
			value = {@ApiResponse(responseCode = "200", description = "Found Laptops", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Laptop.class))}),
					@ApiResponse(responseCode = "404", description = "Laptops Not Fouond", content = @Content)}
			)
	@GetMapping("/")
	public List<Laptop> getAllLaptops(@RequestHeader("Token") String token){
		System.out.println("The user name is : "+ token);
		List<Laptop> laptops = null;
		try {
			jwtUtil.validateToken(token);
			laptops = laptopService.getAllLaptops();
		} catch (Exception e) {
			throw new UnAuthorizedException("Invalid Token: "+e);
		}
		return laptops;
	}
	
	
	@Operation(summary = "Get Laptops", description = "Get list of laptops", tags = "Get")
	@ApiResponses(
			value = {@ApiResponse(responseCode = "200", description = "Found Laptops", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = Laptop.class))}),
					@ApiResponse(responseCode = "404", description = "Laptops Not Fouond", content = @Content)}
			)
	@GetMapping("/hi")
	public String sayHi() {
		return "Hello there suckers";
	}

}
