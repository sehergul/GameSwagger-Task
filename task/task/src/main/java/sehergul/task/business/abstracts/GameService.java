package sehergul.task.business.abstracts;

import java.util.List;




import sehergul.task.core.utilities.results.DataResult;
import sehergul.task.core.utilities.results.Result;
import sehergul.task.entities.concretes.Game;

public interface GameService {
	
	DataResult<List<Game>> getAll();	
		
	Result add(Game game);
	
	DataResult<Game> getByGameName(String gameName);
	
	DataResult<Game> getByGameNameAndTypeId(String gameName, int typeId);
	
	DataResult<List<Game>> getByGameNameOrTypeId(String gameName, int typeId);
		
	DataResult<List<Game>> getByGameNameContains(String gameName);
	
	DataResult<List<Game>> getByGameNameStartsWith(String gameName);
		
	Result delete(Game game);
		
	Result update(Game game);


	
}
