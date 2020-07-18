package com.JohnApp.JohnShop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import database.InventoryDb;
import entities.Inventory;

public class InventoryDbTest {


	@Test
	public void shouldAddRecord()
	{
		int x = 1,y;
		InventoryDb db = new InventoryDb();
		Inventory item = new Inventory(0,"bag juice",0.0,"beverage",5);
		y = db.add(item);
		assertEquals(x,y,0);				
	}
	
	/*
	@Test
	public void shouldUpdateRecord()
	{
		int x = 1,y;
		InventoryDb db = new InventoryDb();
		Inventory item = new Inventory(0,"bag juice",0.0,"beverage",5);
		y = db.update(item,1);
		assertEquals(x,y,0);				
	}
	*/
	/*
	@Test
	public void shouldGetRecord()
	{
		Inventory item = new Inventory(0,"bag juice",0.0,"beverage",5);
		InventoryDb db = new InventoryDb();
		Inventory y = new Inventory();
		y = db.get(1);
		assertEquals(item,y);				
	}*/
	
	
	
	/*@Test
	public void shouldDeletRecord()
	{
		int x = 1,y;
		InventoryDb db = new InventoryDb();
		y = db.delete(1);
		assertEquals(x,y,0);				
	}*/
	/*
	
	@Test
	public void shouldDeleteMulipletRecords()
	{
		int x = 2,y, z[]= {2,3};		
		InventoryDb db = new InventoryDb();
		y = db.deleteMultiple(z);
		assertEquals(x,y,0);				
	}
*/
}
