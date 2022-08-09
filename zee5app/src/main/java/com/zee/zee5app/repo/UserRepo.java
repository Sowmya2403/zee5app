package com.zee.zee5app.repo;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.exceptions.NoDataFoundException;
import com.zee.zee5app.exceptions.UNableToGenerateIdException;

public interface UserRepo {
	public User insertUser(User user) throws UNableToGenerateIdException;
	public Optional<User> updateUser(String userId, User user);
	public String deleteUser(String userId) throws NoDataFoundException;
	public Optional<List<User>> getAllUsers();
	public Optional<User> getUserById(String userId);
	public String deleteUserById(String userId);
	

}
