package com.pedrodamasceno.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.pedrodamasceno.domain.Users;
import com.pedrodamasceno.repository.UsersRepository;

@Controller
@RequestMapping("/users")
public class UsersController {

	private final UsersRepository usersRepository;
	private final String USERS_URI = "users/";

	public UsersController(UsersRepository usersRepository) {
		this.usersRepository = usersRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Users> users = this.usersRepository.findAll();
		return new ModelAndView(USERS_URI + "list","users",users);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Users users) {
		return new ModelAndView(USERS_URI + "view","users",users);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Users users) {
		return USERS_URI + "form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Users users,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(USERS_URI + "form","formErrors",result.getAllErrors()); }
		users = this.usersRepository.save(users);
		redirect.addFlashAttribute("globalMessage","Usuario gravado com sucesso");
		return new ModelAndView("redirect:/" + USERS_URI + "{users.id}","users.id",users.getId());
	}

	@GetMapping(value = "remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
		this.usersRepository.deleteById(id);
		Iterable<Users> users = this.usersRepository.findAll();
		
		ModelAndView mv = new ModelAndView(USERS_URI + "list","users",users);
		mv.addObject("globalMessage","Usuario removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Users users) {
		return new ModelAndView(USERS_URI + "form","users",users);
	}

}