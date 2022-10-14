package com.pedrodamasceno.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.pedrodamasceno.repository.UsersRepository;

@Controller
public class UsersController {
	
	@Autowired
	private UsersRepository usersRepository;
	
	@GetMapping("/rh/users")
	public String User(Model model){
		model.addAttribute("listaUsers",usersRepository.findAll());
		return "rh/users/index";
		
	}

		
}