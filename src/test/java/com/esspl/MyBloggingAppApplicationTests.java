package com.esspl;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.esspl.repositories.UserRepo;

@SpringBootTest
class MyBloggingAppApplicationTests {

	@Autowired
	private UserRepo UserRepo;
	
	@Test
	void contextLoads() {
	}
	
	@Test
	 void testRepo() {
		String className=this.UserRepo.getClass().getName();
		String packageName=this.UserRepo.getClass().getPackageName();
		System.out.println(className);
		System.out.println(packageName);
	}

}
