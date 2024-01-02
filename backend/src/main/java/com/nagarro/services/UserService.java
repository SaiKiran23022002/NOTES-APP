package com.nagarro.services;

import java.util.List; 
import com.nagarro.entities.Users;

public interface UserService {

	public List<Users> getUser();

	public Users getUser(long id);

	public Users addUser(Users user);

}
