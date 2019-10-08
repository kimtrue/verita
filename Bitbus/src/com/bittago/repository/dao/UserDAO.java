package com.bittago.repository.dao;

import com.bittago.repository.vo.User;

public interface UserDAO {

	public User selectSignIn(User user);
	
	public String selectFindUser(User user);
	
	public int insertUser(User signUpUser);

	

}
