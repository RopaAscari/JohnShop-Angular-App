package database;


import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import entities.Student;

public class StudentDb extends SQLBase<Student> {

	
	



Logger logger = LogManager.getLogger(StudentDb.class);
	public static final String TABLE_NAME = "yung_Student";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(id INTEGER PRIMARY KEY AUTOINCREMENT,name VARCHAR(50), studentId INTEGER)"))
			{
				logger.debug("Student table created");
			} 
			else
			{
				logger.debug("Student table does not need to be created");
			}
			logger.debug("Student table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, Student Table not created ", e);
			}
	}

	@Override
	public int add(Student item) 
	{
		try{
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			String query = "INSERT INTO "+TABLE_NAME
					       + "(name,studentId)  VALUES (?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setString(1, item.getName());
			ps.setInt(2, item.getStudentId());			
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add Student",e);
			return 0;

		}
		
		
		finally {			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important				      
				      logger.info("connection closed");
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
		}
		
	}
	
	@Override
	public List<Student> selectAll() {
		List<Student> items = new ArrayList<Student>();
		try {
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			Statement statement = connect.createStatement();
			String sql = "SELECT id, name,studentId from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					Student Student = new Student();						
					Student.setId(rs.getInt("id"));
					Student.setName(rs.getString("name"));
					Student.setStudentId(rs.getInt("studentId"));
					items.add(Student);					
				}
			}
			return items;
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in Student database",e);
			return null;
		}
		
		finally {			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important				      
				      logger.info("connection closed");
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
		}
	}

	
	@Override
	public Student get(int id) {
		try
		{
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			Statement stat;
			stat = connect.createStatement();			
			String query = "Select * from " +TABLE_NAME+ " WHERE id = "+id;   
			ResultSet rs= stat.executeQuery(query);
			if(rs != null)
			{
				while(rs.next())
				{					
					Student Student = new Student();
					Student.setId(rs.getInt("id"));
					Student.setName(rs.getString("name"));
					Student.setStudentId(rs.getInt("studentId"));			
					return Student;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Student recorf=d",e);
		}
		

		finally {			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important				      
				      logger.info("connection closed");
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
		}
		return null;
	}

	
	@Override
	public int update(Student item, int id) 
	{		
		try 
		{	
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			String query = " UPDATE " +TABLE_NAME+ " SET name = ?, studentId = ? " +
					   " WHERE id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setString(1, item.getName());
			ps.setInt(2, item.getStudentId());	
			ps.setInt(3,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update Student record",e);
			return 0;
		}
		
		finally {			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important				      
				      logger.info("connection closed");
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
		}
	}
	

	@Override
	public int delete(int id) 
	{
		try 
		{
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE id = ?";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setInt(1,id);
			return ps.executeUpdate();
		}
	
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("Unable to delete Student Manager with id "+id,e);
			return 0;
		}
		
		finally {			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important				      
				      logger.info("connection closed");
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
		}
	}

	@Override
	public int deleteMultiple(int[] ids)
	{
		try 
		{
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			String groupedIds = Arrays.toString(ids).replace("[","").replace("]","");
			String query = "DELETE FROM "+TABLE_NAME+ " WHERE id in ("+groupedIds+")";
			PreparedStatement ps = connect.prepareStatement(query);			
			return ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to delete multiple",e);
			return 0;
		}
		finally {			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important				      
				      logger.info("connection closed");
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
		}
	}
	

}



