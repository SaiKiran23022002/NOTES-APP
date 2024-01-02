package com.nagarro.services;

import java.util.ArrayList; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.dao.UsersRepo;
import com.nagarro.entities.Users;

import jakarta.annotation.PostConstruct;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersRepo usersRepo;
	List<Users> list;
	private long nextId = 0;

	public UserServiceImpl() {
		list = new ArrayList<>();
	}
	@Override
	public List<Users> getUser() {
		return (List<Users>) usersRepo.findAll();
	}
	@Override
	public Users getUser(long id) {
		return usersRepo.findById(id).orElse(null);
	}

	@Override
	public Users addUser(Users user) {
		long id = nextId;
		user.setId(id);
		nextId++;
		list.add(user);
		return usersRepo.save(user);
	}

}
