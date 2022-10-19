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

import com.pedrodamasceno.domain.Jobs;
import com.pedrodamasceno.repository.JobsRepository;


@Controller
@RequestMapping("/jobs")
public class JobsController {
	
	private final JobsRepository jobsRepository;
	private final String JOBS_URI = "jobs/";

	public JobsController(JobsRepository jobsRepository) {
		this.jobsRepository = jobsRepository;
	}

	@GetMapping("/")
	public ModelAndView list() {
		Iterable<Jobs> jobs = this.jobsRepository.findAll();
		return new ModelAndView(JOBS_URI + "list","jobs",jobs);
	}

	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Jobs jobs) {
		return new ModelAndView(JOBS_URI + "view","jobs",jobs);
	}

	@GetMapping("/novo")
	public String createForm(@ModelAttribute Jobs jobs) {
		return JOBS_URI + "form";
	}

	@PostMapping(params = "form")
	public ModelAndView create(@Valid Jobs jobs,BindingResult result,RedirectAttributes redirect) {
		if (result.hasErrors()) { return new ModelAndView(JOBS_URI + "form","formErrors",result.getAllErrors()); }
		jobs = this.jobsRepository.save(jobs);
		redirect.addFlashAttribute("globalMessage","Vaga gravada com sucesso");
		return new ModelAndView("redirect:/" + JOBS_URI + "{jobs.id}","jobs.id",jobs.getId());
	}

	@GetMapping(value = "remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id,RedirectAttributes redirect) {
		this.jobsRepository.deleteById(id);
		Iterable<Jobs> jobs = this.jobsRepository.findAll();
		
		ModelAndView mv = new ModelAndView(JOBS_URI + "list","jobs",jobs);
		mv.addObject("globalMessage","Vaga removida com sucesso");
	
		return mv;
	}

	@GetMapping(value = "alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") Jobs jobs) {
		return new ModelAndView(JOBS_URI + "form","jobs",jobs);
	}


}
