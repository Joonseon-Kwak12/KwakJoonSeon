package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping({"/home/main", "/main", "/", ""})
	public String showMain() {
		
		return "/usr/home/main";
	}
	
	@GetMapping("/th")
	public String th() {
		return "templates/temp";
	}
}
