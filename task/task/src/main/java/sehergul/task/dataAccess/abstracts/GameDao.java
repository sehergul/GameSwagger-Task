package sehergul.task.dataAccess.abstracts;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import sehergul.task.entities.concretes.Game;

public interface GameDao extends JpaRepository<Game, Integer>{

	Game getByGameName(String gameName);
	
	Game getByGameNameAndType_TypeId(String gameName, int typeId);
	
	List<Game> getByGameNameOrType_TypeId(String gameName, int typeId);
		
	List<Game> getByGameNameContains(String gameName);
	
	List<Game> getByGameNameStartsWith(String gameName);
	

	
}
