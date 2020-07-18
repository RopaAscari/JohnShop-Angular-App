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

import entities.Inventory;

public class InventoryDb extends SQLBase<Inventory>{


Logger logger = LogManager.getLogger(InventoryDb.class);
public static final String TABLE_NAME = "yung_Inventory";

			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(id INTEGER PRIMARY KEY AUTOINCREMENT, item VARCHAR(50), price double, type VARCHAR(50),  available INTEGER)"))
			{
				logger.debug("Inventory table created");
			} 
			else
			{
				logger.debug("Inventory table does not need to be created");
			}
			logger.debug("Inventory table exists");
			
			}
			catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, Inventory Table not created ", e);
			}
	}

	@Override
	public int add(Inventory item) 
	{
		try{
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			String query = "INSERT INTO "+TABLE_NAME
					       + "(item,price,type,available )  VALUES (?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setString(1,item.getItem());
			ps.setDouble(2, item.getPrice());
			ps.setString(3,item.getType());
			ps.setInt(4,item.getAvailable());		
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add to Inventory",e);
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
	public List<Inventory> selectAll() {
		List<Inventory> items = new ArrayList<Inventory>();
		try {
			
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			Statement statement = connect.createStatement();
			String sql = "SELECT id,item,price,type,available from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					Inventory Inventory = new Inventory();						
					Inventory.setId(rs.getInt("id"));
					Inventory.setItem(rs.getString("item"));
					Inventory.setPrice(rs.getDouble("price"));
					Inventory.setType(rs.getString("type"));
					Inventory.setAvailable(rs.getInt("available"));
					items.add(Inventory);					
				}
			}
		}
		catch(SQLException  e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in Inventory database",e);
			return null;
		}

		finally {
			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
			  
		}
		return items;
	}

	
	@Override
	public Inventory get(int id) {
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
					Inventory Inventory = new Inventory();
					Inventory.setId(rs.getInt("id"));
					Inventory.setItem(rs.getString("item"));
					Inventory.setPrice(rs.getDouble("price"));
					Inventory.setType(rs.getString("type"));
					Inventory.setAvailable(rs.getInt("available"));
					return Inventory;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Inventory record",e);
		}

		finally {
			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
			  
		}
		return null;
	}

	
	@Override
	public int update(Inventory item, int id) 
	{		
		try 
		{	

			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			String query = " UPDATE " +TABLE_NAME+ " SET item = ?, price = ?, type = ?, available = ? " +
					   " WHERE id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setString(1,item.getItem());
			ps.setDouble(2, item.getPrice());
			ps.setString(3,item.getType());
			ps.setInt(4,item.getAvailable());			
			ps.setInt(5,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update Inventory record",e);
			return 0;
		}

		finally {
			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important
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
			logger.error("Unable to delete Inventory Manager with id "+id,e);
			return 0;
		}

		finally {
			
			  if (connect != null) {
				    try {
				      connect.close(); // <-- This is important
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
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
			  
		}
	
	}
	

}
