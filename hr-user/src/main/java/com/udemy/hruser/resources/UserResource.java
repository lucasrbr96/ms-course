package com.udemy.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.hruser.entities.User;
import com.udemy.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired 
	private UserRepository repository;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		User user = repository.findById(id).get();
		return new ResponseEntity<User>(user, HttpStatus.OK); 
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findByEmail(@RequestParam String email){
		User user = repository.findByEmail(email);
		return new ResponseEntity<User>(user, HttpStatus.OK); 
	}
}
