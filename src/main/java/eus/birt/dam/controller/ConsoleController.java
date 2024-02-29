package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Console;
import eus.birt.dam.repository.ConsoleRepository;

@Controller
@RequestMapping ("/consoles")
public class ConsoleController {

	@Autowired
	ConsoleRepository consoleRepository;
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		consoleRepository.deleteById(id);
	return "redirect:/consoles";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Console console = new Console();
		model.addAttribute("console", console);
		return "consoleForm";
	}
	
	@PostMapping("/new/submit")
	public String processCreationForm(@ModelAttribute Console console) {
		consoleRepository.save(console);
		return "redirect:/consoles";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("console", consoleRepository.findById(id));
		return "consoleForm";
	}
}
