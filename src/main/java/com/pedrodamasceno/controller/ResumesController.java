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

import com.pedrodamasceno.domain.Resumes;
import com.pedrodamasceno.repository.ResumesRepository;


@Controller
@RequestMapping("/resumes")
public class ResumesController {
	private final ResumesRepository resumesRepository;
	private final String RESUMES_URI = "resumes/";

	public ResumesController(ResumesRepository resumesRepository) {
		this.resumesRepository = resumesRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Resumes> resumes = this.resumesRepository.findAll();
		return new ModelAndView(RESUMES_URI + "list","resumes",resumes);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Resumes resumes) {
		return new ModelAndView(RESUMES_URI + "view","resumes",resumes);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Resumes resumes) {
		return RESUMES_URI + "form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Resumes resumes,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(RESUMES_URI + "form","formErrors",result.getAllErrors()); }
		resumes = this.resumesRepository.save(resumes);
		redirect.addFlashAttribute("globalMessage","Curriculo gravado com sucesso");
		return new ModelAndView("redirect:/" + RESUMES_URI + "{resumes.id}","resumes.id",resumes.getId());
	}

	@GetMapping(value = "remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
		this.resumesRepository.deleteById(id);
		Iterable<Resumes> resumes = this.resumesRepository.findAll();
		
		ModelAndView mv = new ModelAndView(RESUMES_URI + "list","resumes",resumes);
		mv.addObject("globalMessage","Curriculo removido com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Resumes resumes) {
		return new ModelAndView(RESUMES_URI + "form","resumes",resumes);
	}


}
