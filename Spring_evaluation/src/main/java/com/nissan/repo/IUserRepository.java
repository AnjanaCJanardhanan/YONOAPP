package com.nissan.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.nissan.model.User;



public interface IUserRepository extends CrudRepository<User,Integer>{
	@Query("from User WHERE userName=?1 AND password=?2 AND roleId=1")
	public User findUserByNameAndPasswordAdmin(String userName, String password);
	
	
	@Query("from User WHERE userName=?1 AND password=?2 AND roleId=2")
	public User findUserByNameAndPasswordCustomer(String userName1, String password1);
}
