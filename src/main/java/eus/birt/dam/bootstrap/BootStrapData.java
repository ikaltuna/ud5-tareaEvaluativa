/*
package eus.birt.dam.bootstrap;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import eus.birt.dam.domain.Game;
import eus.birt.dam.repository.GameRepository;


@Component
public class BootStrapData implements CommandLineRunner{
	
	@Autowired
	private GameRepository gameRepository;
	
	
	@Override
	public void run(String... arg0) throws Exception {
		Game game1 = new Game("Grand Theft Auto V",LocalDate.parse("2013-10-17"),"Rockstar");
		gameRepository.save(game1);
		System.out.println("Started in Bootstrap");
        System.out.println("Number of games: " + gameRepository.count());
			
	}
	
}*/