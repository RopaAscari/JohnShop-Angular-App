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


import exceptions.ResourceNotFoundException;
import database.OrderDb;
import entities.Order;



@RestController
@RequestMapping("/api/order")
public class OrderController {

	OrderDb orderdb = new OrderDb();		
	Logger logger = LogManager.getLogger(OrderController.class);

	
	@GetMapping("/all")
	public List<Order> getAll() {
		return orderdb.selectAll(); 		
	}
	
	@PostMapping("/add")
	public Order create(@Valid @RequestBody Order data) {
		orderdb.add(data);
		return data;
	}

@GetMapping("/{id}")
public Order get(@PathVariable(value="id") int id) 
{
	Order item = new Order();	
	
	item = orderdb.get(id);	 
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
	public Order update(@PathVariable(value = "id") int id,@Valid @RequestBody Order details) {
	

		try
		{		
			Order current = orderdb.get(id);
			orderdb.update(details, id);			
			return current;
		}
		catch(ResourceNotFoundException e ) 
			{
			e.printStackTrace();
			return null;
			}

}		
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable(value = "id") int id) 
	{

	    Order order = orderdb.get(id);	        
	    try
		{		
			 if (order != null)
			 {
				 orderdb.delete(id);
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
