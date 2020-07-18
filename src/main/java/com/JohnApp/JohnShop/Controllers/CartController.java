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

import database.CartDb;
import entities.Cart;
import exceptions.ResourceNotFoundException;

@RestController
@RequestMapping("/api/cart")
public class CartController {

	private CartDb cartdb = new CartDb();
	Logger logger = LogManager.getLogger(CartController.class);
	
	@GetMapping("/all")
	public List<Cart> getAll() {
		return cartdb.selectAll(); 		
	}
	
	@PostMapping("/add")
	public Cart create(@Valid @RequestBody Cart data) {
		cartdb.add(data);
		return data;
	}
	
	/*@PostMapping("/{id}")
	public Cart create(@PathVariable(value = "id") int id,@Valid @RequestBody Cart data) {
		cartdb.add(data);
		return data;
	}
	*/
	@GetMapping("/{id}")
	public Cart get(@PathVariable(value="id")  int id) {
		
		
		
		Cart item = new Cart();	
		
		item = cartdb.get(id);	 	
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
	public Cart update(@PathVariable(value = "id") int id,@Valid @RequestBody Cart details) {
	
		

		try
		{		
			Cart current = cartdb.get(id);
			cartdb.update(details, id);			
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

	Cart cart = cartdb.get(id);	        
    try
	{		
		 if (cart != null)
		 {
			 cartdb.delete(id);
		 }
		 return ResponseEntity.ok().build();
	}
	catch(ResourceNotFoundException e )
	{
		e.printStackTrace();
		return null;
	}

}
	
	@DeleteMapping("/clear")
	public ResponseEntity<?> delete() {
		
    try
	{		
		cartdb.clearTable();
		 return ResponseEntity.ok().build();
	}
	catch(ResourceNotFoundException e )
	{
		e.printStackTrace();
		return null;
	}
}
	
}
