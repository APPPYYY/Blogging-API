package com.esspl;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.esspl.config.AppConstants;
import com.esspl.models.Role;
import com.esspl.repositories.RoleRepo;

@SpringBootApplication
public class MyBloggingAppApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private RoleRepo roleRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyBloggingAppApplication.class, args);
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(this.passwordEncoder.encode("Arpita"));
		
		
		
		try {
			
			Role role=new Role();
			role.setId(AppConstants.ROLE_ADMIN);
			role.setName("ROLE_ADMIN");
			
			Role role1=new Role();
			role1.setId(AppConstants.ROLE_NORMAL);
			role1.setName("ROLE_NORMAL");
			
			List<Role> roles=List.of(role,role1);
			
			List<Role>results=this.roleRepo.saveAll(roles);
			
			results.forEach(r->{
				System.out.println(r.getName());
			});
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
