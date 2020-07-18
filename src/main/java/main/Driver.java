package main;

import java.util.ArrayList;
import java.util.List;

//import java.util.ArrayList;
//import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import database.CartDb;
import database.InventoryDb;
import database.OrderDb;
import database.SQLBase;
//import database.StudentDb;
import entities.Cart;
import entities.Inventory;
//import entities.Order;
//import entities.Student;

public class Driver {

	public static void main(String args[])
	{
		//SQLBase<Student> db = new StudentDb();
    	OrderDb db = new OrderDb();
		//SQLBase<Inventory> db = new InventoryDb();	
		Logger logger = LogManager.getLogger(Driver.class);
		//SQLBase<Cart> db = new CartDb();
		
		//add student//
		/*Cart item = new Cart(0,"juice",0.0,"beverage",5);
		int recordsAffected;
		recordsAffected = db.add(item);
		
		if (recordsAffected == 1)
		{
			logger.debug("Record added successfully");
		}
		else
		{	
			logger.error("Record not added successfully");
		}
	
		List<Cart> result = new ArrayList<Cart>();
		
		result = db.selectAll();
		
		for (Cart s : result)
		{
			System.out.println(s);
		}	*/	
		
		//update student
		/*Student item = new Student(1,"kartel","Gaza");
		int recordsAffected;
		recordsAffected = db.update(item, 1);
		
		if (recordsAffected == 1)
		{
			logger.debug("Record added successfully");
		}
		else
		{
			logger.error("Record no added successfully");
		}
		
		*/
		
		
		// get student 
	/*	
		Student item = new Student();
		int id = 2;
		item = db.get(id);
		if (item  != null)
		{
			logger.debug("Record retrieved successfully");
			System.out.println(item);
		}
		else
		{
			logger.error("Record not retrieved successfully");
		}
		
		*/
		
	
		
		
		//SelectAll Student
		
	/*	List<Student> result = new ArrayList<Student>();
	
		result = db.selectAll();
		
		for (Student s : result)
		{
			System.out.println(s);
		}

		*/
		
	//SelectAll Order
	/*	Order item = new Order(1,"juice",80.0,"right here","bob marley",1);
			int recordsAffected;
			recordsAffected = db.add(item);
			
			if (recordsAffected == 1)
			{
				logger.debug("Record added successfully");
			}
			else
			{
				logger.error("Record not added successfully");
			}
			
			
		List<Order> result = new ArrayList<Order>();
	
		result = db.selectAll();
		
		for (Order s : result)
		{
			System.out.println(s);
		}
		*/
		
		/*  Inventory item = new Inventory(0,"bay juice",0.0,"beverage",5);
		int recordsAffected;
		recordsAffected = db.add(item);
		
		if (recordsAffected == 1)
		{
			logger.debug("Record added successfully");
		}
		else
		{
			logger.error("Record not added successfully");
		}*/
		/*
		List<Inventory> result = new ArrayList<Inventory>();
		
		result = db.selectAll();
		
		for (Inventory s : result)
		{
			System.out.println(s);
		}
		*/
		db.clearTable();
	
	}
}
























/*
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import database.IOrderDatabase;

import entities.Order;
import entities.Student;

@SpringBootApplication
public class Driver {

	@Autowired
	private IOrderDatabase db;
	
	public Order addItem(Order data)
	{
		return db.save(data);
	}
		
	public static void main(String[] args) 
	{
		SpringApplication.run(Driver.class,args);
		Driver myDriver = new Driver();
		
		Student student = new Student();
		Order result = myDriver.addItem(new Order(1,"string",9.4,student ));
		
		if(result != null)
		{
			System.out.print("Success, item added");
		}
		else
		{
			System.out.print("Failure, item was not added");
		}
		
	}

}
*/