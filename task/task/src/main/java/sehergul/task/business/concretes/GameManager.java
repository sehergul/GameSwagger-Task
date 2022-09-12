package sehergul.task.business.concretes;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import sehergul.task.core.utilities.results.SuccessDataResult;
import sehergul.task.core.utilities.results.SuccessResult;
import sehergul.task.business.abstracts.GameService;
import sehergul.task.core.utilities.results.DataResult;
import sehergul.task.core.utilities.results.ErrorResult;
import sehergul.task.core.utilities.results.Result;
import sehergul.task.dataAccess.abstracts.GameDao;
import sehergul.task.entities.concretes.Game;

@Service
public class GameManager implements GameService{
	
	private GameDao gameDao;

	@Autowired
	public GameManager(GameDao gameDao) {
		super();
		this.gameDao = gameDao;
	}


	@Override
	public DataResult<List<Game>> getAll() {
		return new SuccessDataResult<List<Game>>
			(this.gameDao.findAll(), "Oyunlar listelendi");
	}


	@Override
	public Result add(Game game) {
		this.gameDao.save(game);
		return new SuccessResult("Oyun basariyla eklendi!");
	}

	@Override
	public DataResult<Game> getByGameName(String gameName) {
		return new SuccessDataResult<Game>
			(this.gameDao.getByGameName(gameName), "Oyunlar listelendi!");
	}

	@Override
	public DataResult<Game> getByGameNameAndTypeId(String gameName, int typeId) {
		return new SuccessDataResult<Game>
			(this.gameDao.getByGameNameAndType_TypeId(gameName, typeId), "Oyunlar listelendi!");
	}

	@Override
	public DataResult<List<Game>> getByGameNameOrTypeId(String gameName, int typeId) {
		return new SuccessDataResult<List<Game>>
			(this.gameDao.getByGameNameOrType_TypeId(gameName, typeId), "Oyunlar listelendi!");
	}



	@Override
	public DataResult<List<Game>> getByGameNameContains(String gameName) {
		return new SuccessDataResult<List<Game>>
			(this.gameDao.getByGameNameContains(gameName), "Oyunlar listelendi!");
}
	
	@Override
	public DataResult<List<Game>> getByGameNameStartsWith(String gameName) {
		return new SuccessDataResult<List<Game>>
			(this.gameDao.getByGameNameStartsWith(gameName), "Oyunlar listelendi!");
}


	@Override
	public Result delete(Game game) {
		this.gameDao.delete(game);
		return new SuccessDataResult("Oyun basariyla silindi!");
	}

	

	@Override
	public Result update(Game game) {
			if(this.gameDao.getByGameName(game.getGameName())==null) {
				return new ErrorResult("Oyun bulunamadi!");
			}else {
				this.gameDao.save(game);
				return new SuccessResult("Oyun bilgileri guncellendi"); 
			}
		
	}


	
	
	

}
