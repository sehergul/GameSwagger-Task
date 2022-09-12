package sehergul.task.business.concretes;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import sehergul.task.business.abstracts.UserService;
import sehergul.task.core.entities.User;
import sehergul.task.core.utilities.results.DataResult;
import sehergul.task.core.utilities.results.ErrorResult;
import sehergul.task.core.utilities.results.Result;
import sehergul.task.core.utilities.results.SuccessDataResult;
import sehergul.task.core.utilities.results.SuccessResult;
import sehergul.task.dataAccess.abstracts.UserDao;
import sehergul.task.entities.concretes.Game;

@Service
public class UserManager implements UserService{

	private UserDao userDao;

	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("Kullanici eklendi!");			
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>
			(this.userDao.findByEmail(email));
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessDataResult("Kullanici silindi!");
	}

	@Override
	public Result update(User user) {
		if(this.userDao.findByEmail(user.getEmail())==null) {
			return new ErrorResult("Kullanici bulunamadi!");
		}else {
			this.userDao.save(user);
			return new SuccessResult("Kullanici bilgileri guncellendi");
		}
	}


	@Override
	public DataResult<List<User>> getAll() {
		return new SuccessDataResult<List<User>>
			(this.userDao.findAll(), "Kullanicilar listelendi");
	}
}
