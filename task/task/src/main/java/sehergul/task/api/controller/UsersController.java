package sehergul.task.api.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import sehergul.task.business.abstracts.UserService;
import sehergul.task.core.entities.User;
import sehergul.task.core.utilities.results.DataResult;
import sehergul.task.core.utilities.results.ErrorDataResult;
import sehergul.task.core.utilities.results.Result;
import sehergul.task.core.utilities.results.SuccessResult;
import sehergul.task.entities.concretes.Game;

@RestController
@RequestMapping("/api/users/")
public class UsersController {

	private UserService userService;

	@Autowired
	public UsersController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	@GetMapping(value="getByEmail")
	public DataResult<User> findByEmail(String email){
		return this.userService.findByEmail(email);
	}
	
	@GetMapping("getAll")
	public DataResult<List<User>> getAll(){
		return this.userService.getAll();
	}
	
	@PostMapping(value = "add")
	public ResponseEntity<?> add(@Valid @RequestBody User user){
		return ResponseEntity.ok(this.userService.add(user));	
	}
	
	@DeleteMapping("delete")
	public Result delete(@RequestBody User user) {
		return this.userService.delete(user);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(@Valid @RequestBody User user){
		return ResponseEntity.ok(this.userService.update(user));	
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDataResult<Object> handleValidationException
		(MethodArgumentNotValidException exceptions){
		
		Map<String, String> validationErrors = new HashMap<String, String>();
		for(FieldError fieldError : exceptions.getBindingResult().getFieldErrors()) {
			validationErrors.put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		ErrorDataResult<Object> errors = new ErrorDataResult<Object>
			(validationErrors, "Dogrulama hatalari");
		return errors;
	}
	
}
