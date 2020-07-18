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

import database.InventoryDb;
import entities.Inventory;
import exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

	private InventoryDb invendb = new InventoryDb();
	Logger logger = LogManager.getLogger(InventoryController.class);
	
	@GetMapping("/all")
	public List<Inventory> getAll() {
		return invendb.selectAll(); 		
	}
	
	@PostMapping("/add")
	public Inventory create(@Valid @RequestBody Inventory data) {
		invendb.add(data);
		return data;
	}
	
	@GetMapping("/{id}")
	public Inventory get(@PathVariable(value="id")  int id) {
		
		
		
		Inventory item = new Inventory();	
		
		item = invendb.get(id);	 	
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
	public Inventory update(@PathVariable(value = "id") int id,@Valid @RequestBody Inventory details) {
	
		

		try
		{		
			Inventory current = invendb.get(id);
			invendb.update(details, id);			
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

	Inventory inventory = invendb.get(id);	        
    try
	{		
		 if (inventory != null)
		 {
			 invendb.delete(id);
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
