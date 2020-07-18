package com.JohnApp.JohnShop;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import database.StudentDb;
import entities.Student;

public class StudentDbTest {

	@Test
	public void shouldAddRecord()
	{
		int x = 1,y;
		StudentDb db = new StudentDb();
		Student item = new Student(0,"YungLord",1608193);	
		y = db.add(item);
		assertEquals(x,y,0);				
	}
	

/*	@Test
	public void shouldUpdateRecord()
	{
		int x = 1,y;
		StudentDb db = new StudentDb();
		Student item = new Student(0,"YungLord",1608193);	
		y = db.update(item,1);
		assertEquals(x,y,0);				
	}
	*/
	
	/*
	@Test
	public void shouldGetRecord()
	{
		Student item = new Student(1,"YungLord",1608193);	
		StudentDb db = new StudentDb();
		Student y = new Student();
		y = db.get(1);
		assertEquals(item,y);				
	}
	*/
	
	/*	
	@Test
	public void shouldDeletRecord()
	{
		int x = 1,y;
		StudentDb db = new StudentDb();
		y = db.delete(1);
		assertEquals(x,y,0);				
	}
	
	
	@Test
	public void shouldDeleteMulipletRecords()
	{
		int x = 2,y, z[]= {2,3};		
		StudentDb db = new StudentDb();
		y = db.deleteMultiple(z);
		assertEquals(x,y,0);				
	}
	
	*/
}


