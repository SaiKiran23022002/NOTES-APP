package com.nagarro.dao;

import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository;

import com.nagarro.entities.*;

@Repository
public interface UsersRepo extends CrudRepository<Users, Long> {

}
