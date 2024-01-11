package identity.services.jwt.Entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private long id;
	    @NotNull(message =  "username shouldn't be null")
	    @NotBlank(message = "username shouldn't be blank")
	    private String name;
	    @NotNull(message = "email shouldn't be null")
	    @NotBlank(message = "email shouldn't be null")
	    @Email(message =  "invalid email address")
	    private String email;
	    @NotNull(message =  "password shouldn't be null")
	    @NotBlank(message = "password shouldn't be blank")
	    private String password;
	    @Column(unique = true)
	    @NotNull(message =  "empId shouldn't be null")
	    @NotBlank(message = "empId shouldn't be blank")
	    private String empId;
	    @Pattern(regexp = "^\\d{10}$",message = "invalid mobile number entered ")
	    private String mobile;

}
