package sehergul.task.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import sehergul.task.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer>{

	User findByEmail(String email);

	
	
}
