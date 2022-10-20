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

import com.pedrodamasceno.domain.Recruiter;
import com.pedrodamasceno.repository.RecruiterRepository;

@Controller
@RequestMapping("/recruiter")
public class RecruiterController {
	
	private final RecruiterRepository recruiterRepository;
	private final String RECRUITER_URI = "recruiter/";

	public RecruiterController(RecruiterRepository recruiterRepository) {
		this.recruiterRepository = recruiterRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Recruiter> recruiter = this.recruiterRepository.findAll();
		return new ModelAndView(RECRUITER_URI + "list","recruiter",recruiter);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Recruiter recruiter) {
		return new ModelAndView(RECRUITER_URI + "view","recruiter",recruiter);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Recruiter recruiter) {
		return RECRUITER_URI + "form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Recruiter recruiter,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(RECRUITER_URI + "form","formErrors",result.getAllErrors()); }
		recruiter = this.recruiterRepository.save(recruiter);
		redirect.addFlashAttribute("globalMessage","Recruitador gravado com sucesso");
		return new ModelAndView("redirect:/" + RECRUITER_URI + "{recruiter.id}","recruiter.id",recruiter.getId());
	}

	@GetMapping(value = "remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
		this.recruiterRepository.deleteById(id);
		Iterable<Recruiter> recruiter = this.recruiterRepository.findAll();
		
		ModelAndView mv = new ModelAndView(RECRUITER_URI + "list","recruiter",recruiter);
		mv.addObject("globalMessage","Recrutador removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Recruiter recruiter) {
		return new ModelAndView(RECRUITER_URI + "form","recruiter",recruiter);
	}


}