package com.esspl.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogController {

	@RequestMapping("/signin")
	public String Login() {
		System.out.println("inside signin");
		return "login2";
	}
}
