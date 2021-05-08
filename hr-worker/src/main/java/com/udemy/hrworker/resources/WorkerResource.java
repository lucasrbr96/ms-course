package com.udemy.hrworker.resources;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.hrworker.entities.Worker;
import com.udemy.hrworker.repositories.WorkerRepository;


@RestController
@RequestMapping("/workers")
public class WorkerResource {
	
	private static Logger logger = LoggerFactory.getLogger(WorkerResource.class);

	@Autowired 
	private Environment env;
	
	@Autowired 
	private WorkerRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Worker>> findAll(){
		return new ResponseEntity<List<Worker>>(repository.findAll(), HttpStatus.OK); 
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Worker> findById(@PathVariable Long id){
		logger.info("PORT = " + env.getProperty("local.server.port"));
		
		Worker worker = repository.findById(id).get();
		return new ResponseEntity<Worker>(worker, HttpStatus.OK); 
	}
}
