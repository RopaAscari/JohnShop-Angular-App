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

import entities.Cart;

public class CartDb extends SQLBase<Cart>{


Logger logger = LogManager.getLogger(CartDb.class);
public static final String TABLE_NAME = "yung_Cart";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							"(id INTEGER PRIMARY KEY AUTOINCREMENT, item VARCHAR(50), price double, type VARCHAR(50),  available INTEGER)"))
			{
				logger.debug("Cart table created");
			} 
			else
			{
				logger.debug("Cart table does not need to be created");
			}
			logger.debug("Cart table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, Cart Table not created ", e);
			}
		
	}

	@Override
	public int add(Cart item) 
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
				    } catch (SQLException ex) 
					{
						logger.error("Could not close connection to database",ex);
					}
			  }
			  
		}
		
		
	}
	
	@Override
	public List<Cart> selectAll() {
		List<Cart> items = new ArrayList<Cart>();
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
					Cart Cart = new Cart();						
					Cart.setId(rs.getInt("id"));
					Cart.setItem(rs.getString("item"));
					Cart.setPrice(rs.getDouble("price"));
					Cart.setType(rs.getString("type"));
					Cart.setAvailable(rs.getInt("available"));
					items.add(Cart);					
				}
			}
			return items;
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in Cart database",e);
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
		
	}

	
	@Override
	public Cart get(int id) {
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
					Cart Cart = new Cart();
					Cart.setId(rs.getInt("id"));
					Cart.setItem(rs.getString("item"));
					Cart.setPrice(rs.getDouble("price"));
					Cart.setType(rs.getString("type"));
					Cart.setAvailable(rs.getInt("available"));
					return Cart;
				}								
			}		
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Cart record",e);
			
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
	public int update(Cart item, int id) 
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
			logger.error("unable to update Cart record",e);
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
			logger.error("Unable to delete Cart  with id "+id,e);
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

	
	public int clearTable()
	{
		try 
		{
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
						
			String query = "DELETE FROM "+ TABLE_NAME;
			PreparedStatement ps = connect.prepareStatement(query);			
			return ps.executeUpdate();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to clear table",e);
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
