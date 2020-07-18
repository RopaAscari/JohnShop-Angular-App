package com.JohnApp.JohnShop.Controllers;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import database.StudentDb;
import entities.Student;
import exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	Logger logger = LogManager.getLogger(StudentController.class);
	private StudentDb studb = new StudentDb();
		
	@GetMapping("/all")
	public List<Student> getAll() {
		return studb.selectAll(); 		
	}
	
	@PostMapping("/add")
	public Student create(@Valid @RequestBody Student data) {
		studb.add(data);
		return data;
	}
	
	@GetMapping("/{id}")
	public Student get(@PathVariable(value="id")  int id) {
				
		Student item = new Student();	
		
		item = studb.get(id);	 
		try 
		{		
			if (item != null )	
			{
				logger.info("item exits");				
			}	
			return item;
			
		}
	catch(ResourceNotFoundException e ) 
		{
		e.printStackTrace();
		return null;
		}
	}
	
	// Update a Note
	@PutMapping("/{id}")
	public Student update(@PathVariable(value = "id") int id,@Valid @RequestBody Student details) {
	    
   
		try
		{		
			Student current = studb.get(id);
			studb.update(details, id);			
			return current;
		}
		catch(ResourceNotFoundException e ) 
			{
			e.printStackTrace();
			return null;
			}

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id) {
		
	    Student student = studb.get(id);	        
	    try
		{		
			 if (student != null)
			 {
				 studb.delete(id);
			 }
			   return ResponseEntity.ok().build();
		}
		catch(ResourceNotFoundException e )
		{
			e.printStackTrace();
			return null;
		}
	}
}
