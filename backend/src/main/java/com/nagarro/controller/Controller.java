package com.nagarro.controller;

import java.util.List;    
import com.nagarro.services.UserService;
import com.nagarro.services.NotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.nagarro.entities.*;
import com.nagarro.dao.NotesRepo;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class Controller {


	@Autowired
	private UserService userService;
	
	@Autowired
	private NotesService notesService;
	
	@Autowired
    private NotesRepo notesRepo;

	@GetMapping("/home")
	public String home() {
		return "this is home page";
	}

	@GetMapping("/users")
	public List<Users> getUser() {

		return this.userService.getUser();
	}

	@GetMapping("/users/{id}")
	public Users getUser(@PathVariable String id) {
		return this.userService.getUser(Long.parseLong(id));
	}

	@PostMapping(path = "/users", consumes = "application/json")
	public Users addUser(@RequestBody Users user) {

		return this.userService.addUser(user);
	}

	@PostMapping(path="/notes", consumes="application/json")
	public Notes addNote(@RequestBody Notes note) {
		return this.notesService.addNote(note);
	}
	
	@GetMapping("/notes/{userId}")
    public List<Notes> getNotesByUserId(@PathVariable String userId) {
        return notesRepo.findByUserIdOrderByIdDesc(userId);
    }
	
	@DeleteMapping("/notes/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		 this.notesService.deleteNote(id);

	}

}
