package com.esspl.payloads;

import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.esspl.models.Role;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class UserDto {

	private int id;
	
	@NotEmpty
	@Size(min = 4,message = "Name should be >4 charecters !")
	private String name;
	
	@Email(message = "Please give a proper email !")
	private String email;
	
	@NotEmpty
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$",message = 
	"It contains at least 8 characters and at most 20 characters."
			+ "It contains at least one digit."
			+ "It contains at least one upper case alphabet."
			+ "It contains at least one lower case alphabet."
			+ "It contains at least one special character which includes !@#$%&*()-+=^."
			+ "It doesn’t contain any white space.")
	private String password;
	
	@NotEmpty
	@Size(min = 10,max = 200,message = "Min 10 and Max 200 !")
	private String about;
	private Set<RoleDto> roles = new HashSet<>();
}
