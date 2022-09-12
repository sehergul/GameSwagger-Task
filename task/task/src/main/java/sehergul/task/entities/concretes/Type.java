package sehergul.task.entities.concretes;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "types")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","games"})
public class Type {

	@Id
	@Column(name="type_id")
	private int typeId;
	
	@Column(name="type_name")
	private String typeName;
	
	@OneToMany(mappedBy = "type")
	private List<Game> games;
}
