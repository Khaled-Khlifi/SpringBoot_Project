package net.javaguides.sms.controller;

import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import net.javaguides.sms.entity.Sign;
import net.javaguides.sms.service.SignService;

@Controller
public class SignController {
	
	private SignService SignService;
	private  HashSet<Sign> set = new HashSet<>();
	

	public SignController(SignService SignService) {
		super();
		this.SignService = SignService;
	}
	
	// handler method to handle list Signs and return mode and view
	
	 /*@GetMapping("/Signs")
	public String listSigns(Model model) {
		model.addAttribute("Signs", SignService.getAllSigns());
		return "Signs";
	}*/
	
	@GetMapping("/Signs/new")
	public String createSignForm(Model model) {
		
		// create Sign object to hold Sign form data
		Sign Sign = new Sign();
		model.addAttribute("Sign", Sign);
		return "Signs";
		
	}
	
	@PostMapping("/Signs")
	public String saveSign(@ModelAttribute("Sign") Sign Sign) {
		SignService.saveSign(Sign);
         String ss=Sign.getPassword();
         String se=Sign.getEmail();
		if (ss.equals("123456789")&&se.equals("khaledkhlifi41@gmail.com"))
		return "redirect:/Products/new";
		return "redirect:/Signs/new";
	}
	
	/*@GetMapping("/Signs/edit/{id}")
	public String editSignForm(@PathVariable Long id, Model model) {
		model.addAttribute("Sign", SignService.getSignById(id));
		return "edit_Sign";
	}*/

	@PostMapping("/Signs/{id}")
	public String updateSign(@PathVariable Long id,
			@ModelAttribute("Sign") Sign Sign,
			Model model) {
		
		// get Sign from database by id
		Sign existingSign = SignService.getSignById(id);
		existingSign.setId(id);
		existingSign.setPassword(Sign.getPassword());
		existingSign.setLastName(Sign.getLastName());
		existingSign.setEmail(Sign.getEmail());
		
		set.add(existingSign);
		// save updated Sign object
		/*SignService.updateSign(existingSign);*/
		return "redirect:/Signs/new";		
	}
	
	// handler method to handle delete Sign request
	/*
	@GetMapping("/Signs/{id}")
	public String deleteSign(@PathVariable Long id) {
		SignService.deleteSignById(id);
		return "redirect:/Signs";
	}
	*/
}
