package com.nagarro.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository; 
import org.springframework.stereotype.Repository;


import com.nagarro.entities.*;

@Repository
public interface NotesRepo extends CrudRepository<Notes, Long> {
	List<Notes> findByUserIdOrderByIdDesc(String userId);
	 @Query(value = "SELECT * FROM notes ORDER BY id DESC LIMIT 10", nativeQuery = true)
	 List<Notes> findLast10RecentNotes();
	 
}
