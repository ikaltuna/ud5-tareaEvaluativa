package eus.birt.dam.domain;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="console")
public class Console {
	@Id
	@SequenceGenerator(name = "col_gen2", sequenceName = "col_sqe2",schema="videogames")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "col_gen2")
	private Long id;
	
	private String name;
	
	private String model;
	
	private String nationality;
	
	private String company;
	
	
	@OneToMany (mappedBy = "console",cascade = CascadeType.ALL)
	List <Game> games = new ArrayList<>();

	public Console(String name, String model, String nationality, String company) {
		super();
		this.name = name;
		this.model = model;
		this.nationality = nationality;
		this.company = company;
	}


}
