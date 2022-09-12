package sehergul.task.business.abstracts;

import java.util.List;


import sehergul.task.core.entities.User;
import sehergul.task.core.utilities.results.DataResult;
import sehergul.task.core.utilities.results.Result;

public interface UserService {

	Result add(User user);
	
	Result delete(User user);
	
	Result update(User user);
	
	DataResult<User> findByEmail(String email);
	
	DataResult<List<User>> getAll();	

}
