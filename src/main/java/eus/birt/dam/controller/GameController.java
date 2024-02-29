package eus.birt.dam.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import eus.birt.dam.domain.Game;
import eus.birt.dam.repository.GameRepository;
import eus.birt.dam.repository.ConsoleRepository;

@Controller
@RequestMapping ("/games")
public class GameController {

	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	ConsoleRepository consoleRepository;
	
	
	@GetMapping("/delete/{id}")
	public String initDelete(@PathVariable("id") Long id) {
		gameRepository.deleteById(id);
		return "redirect:/games";
	}
	
	@GetMapping("/new")
	public String initCreationForm(Model model) {
		Game game = new Game();
		model.addAttribute("game", game);
		model.addAttribute("console", consoleRepository.findAll());
		return "gameForm";
	}
	
	@PostMapping("/new/submit")
	public String submitCreationForm(@ModelAttribute Game game) {
		gameRepository.save(game);
		return "redirect:/games";
	}
	
	@GetMapping("/edit/{id}")
	public String initEditForm(@PathVariable("id") Long id, Model model) {	
		model.addAttribute("game", gameRepository.findById(id));
		model.addAttribute("console", consoleRepository.findAll());
		return "gameForm";
	}
}