package com.JohnApp.JohnShop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import database.OrderDb;
import entities.Order;

public class OrderDbTest {

	@Test
	public void shouldAddRecord()
	{
		int x = 1,y;
		OrderDb db = new OrderDb();
		Order item = new Order(1,"juice",80.0,"right here","bob marley",1,false);
		y = db.add(item);
		assertEquals(x,y,0);				
	}
	
	
	/*
	@Test
	public void shouldUpdateRecord()
	{
		int x = 1,y;
		OrderDb db = new OrderDb();
		Order item = new Order(1,"juice",80.0,"right here","bob marley",1,false);
		y = db.update(item,1);
		assertEquals(x,y,0);				
	}
	*/
	/*
	@Test
	public void shouldGetRecord()
	{
		Order item = new Order(1,"juice",80.0,"right here","bob marley",1,false);
		OrderDb db = new OrderDb();
		Order y = new Order();
		y = db.get(1);
		assertEquals(item,y);				
	}
	*/
	/*
	@Test
	public void shouldDeletRecord()
	{
		int x = 1,y;
		OrderDb db = new OrderDb();
		y = db.delete(1);
		assertEquals(x,y,0);				
	}*/
	/*
	
	@Test
	public void shouldDeleteMulipletRecords()
	{
		int x = 2,y, z[]= {2,3};		
		OrderDb db = new OrderDb();
		y = db.deleteMultiple(z);
		assertEquals(x,y,0);				
	}
*/
}
