package sehergul.task.api.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sehergul.task.business.abstracts.GameService;
import sehergul.task.core.utilities.results.DataResult;
import sehergul.task.core.utilities.results.Result;
import sehergul.task.entities.concretes.Game;

@RestController
@RequestMapping("/api/games/")
public class GamesController {

	private GameService gameService;

	@Autowired
	public GamesController(GameService gameService) {
		super();
		this.gameService = gameService;
	}
	
	
	@GetMapping("getAll")
	public DataResult<List<Game>> getAll(){
		return this.gameService.getAll();
	}

	
	@PostMapping("add")
	public Result add(@RequestBody Game game){
		return this.gameService.add(game);
	}
	

	@PutMapping("update")
	public Result update(@RequestBody Game game) {
		return this.gameService.update(game);
	}
	
	@GetMapping("getByGameName")
	public DataResult<Game> getByGameName(String gameName){
		return this.gameService.getByGameName(gameName);
	}
	
	@GetMapping("getByGameNameAndTypeId")
	public DataResult<Game> getByGameNameAndTypeId(String gameName, int typeId){
		return this.gameService.getByGameNameAndTypeId(gameName, typeId);
	}
	
	@GetMapping("getByGameNameOrTypeId")
	public DataResult<List<Game>> getByGameNameOrTypeId(String gameName, int typeId){
		return this.gameService.getByGameNameOrTypeId(gameName, typeId);
	}

	
	@GetMapping("getByGameNameContains")
	public DataResult<List<Game>> getByGameNameContains(String gameName){
		return this.gameService.getByGameNameContains(gameName);
	}
	
	@GetMapping("getByGameNameStartsWith")
	public DataResult<List<Game>> getByGameNameStartsWith(String gameName){
		return this.gameService.getByGameNameStartsWith(gameName);
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody Game game){
		return this.gameService.delete(game);
	}

}
