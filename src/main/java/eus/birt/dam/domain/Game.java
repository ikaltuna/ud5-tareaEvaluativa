package eus.birt.dam.domain;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="game")
public class Game {
	@Id
	@SequenceGenerator(name = "col_gen", sequenceName = "col_sqe",schema="videogames")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen")
	private Long id;
	
	private String name;
	
	@Column(name="release_date")
	@DateTimeFormat (pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;
	
	private String developer;
	
	@ManyToOne
	@JoinColumn (name = "console_id")
	private Console console;
	
	public Game(String name, LocalDate releaseDate, String developer) {
		super();
		this.name = name;
		this.releaseDate = releaseDate;
		this.developer = developer;
	}

	
}
