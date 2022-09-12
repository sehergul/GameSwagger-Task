package sehergul.task.entities.concretes;


import javax.persistence.Column;




import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="games")
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "game_id")
	private int id;
	
	@Column(name= "game_name")
	private String gameName;
	
	@Column(name= "unit_price")
	private double unitPrice;
	
	@Column(name= "units_in_stock")
	private short unitsInStock;
	
	@ManyToOne()
	@JoinColumn(name = "type_id")
	private Type type;

}
