package com.JohnApp.JohnShop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import database.CartDb;
import entities.Cart;

public class CartDbTest {


	@Test
	public void shouldAddRecord()
	{
		int x = 1,y;
		CartDb db = new CartDb();
		Cart item = new Cart(0,"bag juice",0.0,"beverage",5);
		y = db.add(item);
		assertEquals(x,y,0);				
	}
	
	/*
	@Test
	public void shouldUpdateRecord()
	{
		int x = 1,y;
		CartDb db = new CartDb();
		Cart item = new Cart(0,"bag juice",0.0,"beverage",5);
		y = db.update(item,1);
		assertEquals(x,y,0);				
	}
	*/
	/*
	@Test
	public void shouldGetRecord()
	{
		Cart item = new Cart(0,"bag juice",0.0,"beverage",5);
		CartDb db = new CartDb();
		Cart y = new Cart();
		y = db.get(1);
		assertEquals(item,y);				
	}*/
	
	
	
	/*@Test
	public void shouldDeletRecord()
	{
		int x = 1,y;
		CartDb db = new CartDb();
		y = db.delete(1);
		assertEquals(x,y,0);				
	}*/
	/*
	
	@Test
	public void shouldDeleteMulipletRecords()
	{
		int x = 2,y, z[]= {2,3};		
		CartDb db = new CartDb();
		y = db.deleteMultiple(z);
		assertEquals(x,y,0);				
	}
*/
}
