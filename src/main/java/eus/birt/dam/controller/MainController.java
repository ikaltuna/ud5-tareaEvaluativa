package eus.birt.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import eus.birt.dam.repository.GameRepository;
import eus.birt.dam.repository.ConsoleRepository;


@Controller
	public class MainController {
	
	@Autowired
   	private GameRepository gameRepository;
	@Autowired
   	private ConsoleRepository consoleRepository;
	
	@GetMapping ({"/","/welcome"})
	public String welcome() {
		return "index";
	}
	
	@GetMapping ({"/games"})
	public String getGames(Model model) {
		model.addAttribute("games", gameRepository.findAll());
		return "games";
	}
	
	@GetMapping ({"/consoles"})
	public String getConsoles(Model model) {
		model.addAttribute("consoles", consoleRepository.findAll());
		return "consoles";
	}
}
	

