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

import entities.Order;


public class OrderDb extends SQLBase<Order> {


Logger logger = LogManager.getLogger(OrderDb.class);
public static final String TABLE_NAME = "yung_Order";
	
			
	@Override
	protected void initSQLDatabase() {
		try {
			
			statement = connect.createStatement();
			if (statement
					.execute("CREATE TABLE if not exists "+TABLE_NAME+
							" (id INTEGER PRIMARY KEY AUTOINCREMENT, itemName VARCHAR(50), amtDue double, location VARCHAR(50), name VARCHAR(50) ,studentId INTEGER, completed BOOLEAN)"))
			{
				logger.debug("Order table created");
			} 
			else
			{
				logger.debug("Order table does not need to be created");
			}
			logger.debug("Order table exists");
			
			} catch (SQLException e) 
			{
				e.printStackTrace();
				logger.error("Unable to initialize SQL database, Order Table not created ", e);
			}
	}

	@Override
	public int add(Order item) 
	{
		try{
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			
			String query = "INSERT INTO "+TABLE_NAME
					       + "(itemName,amtDue,location,name,studentId,completed)  VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = connect.prepareStatement(query);			
			ps.setString(1, item.getItemName());
			ps.setDouble(2,item.getAmtDue());		
			ps.setString(3,item.getLocation());
			ps.setString(4,item.getName());
			ps.setInt(5,item.getStudentId());
			ps.setBoolean(6, item.isCompleted());
			return ps.executeUpdate();
					
    	}catch(SQLException e){
    		e.printStackTrace();
			logger.error("Unable to add Order",e);
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
	public List<Order> selectAll() {
		List<Order> items = new ArrayList<Order>();
		try {
			
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			Statement statement = connect.createStatement();
			String sql = "SELECT id,itemName,amtDue,location,name,studentId,completed from "+TABLE_NAME;
			ResultSet rs = statement.executeQuery(sql);
			if(rs != null) 
			{
				while(rs.next()) 
				{				
					Order Order = new Order();						
					Order.setId(rs.getInt("id"));
					Order.setItemName(rs.getString("itemName"));
					Order.setAmtDue(rs.getDouble("amtDue"));
					Order.setLocation(rs.getString("location"));
					Order.setName(rs.getString("name"));
					Order.setStudentId(rs.getInt("studentId"));
					Order.setCompleted(rs.getBoolean("completed"));
					items.add(Order);					
				}
			}
			return items;
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to select elements in Order database",e);
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
	public Order get(int id) {
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
					Order Order = new Order();
					Order.setId(rs.getInt("id"));
					Order.setItemName(rs.getString("itemName"));
					Order.setAmtDue(rs.getDouble("amtDue"));
					Order.setLocation(rs.getString("location"));
					Order.setName(rs.getString("name"));
					Order.setStudentId(rs.getInt("studentId"));
					Order.setCompleted(rs.getBoolean("completed"));
					return Order;
				}								
			}				
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			logger.error("Unable to retrieve Order record",e);
			
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
	public int update(Order item, int id) 
	{		
		try 
		{	
			String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			connect = DriverManager.getConnection(url);
			
			
			String query = " UPDATE " +TABLE_NAME+ " SET itemName = ?, amtDue = ?, location = ?, name = ?,studentId = ?  , completed = ?" +
					   " WHERE id = ?";
			PreparedStatement ps;		
			ps = connect.prepareStatement(query);				
			ps.setString(1, item.getItemName());
			ps.setDouble(2,item.getAmtDue());		
			ps.setString(3,item.getLocation());
			ps.setString(4,item.getName());
			ps.setInt(5,item.getStudentId());
			ps.setBoolean(6, item.isCompleted());
			ps.setInt(6,id);
			return ps.executeUpdate();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
			logger.error("unable to update Order record",e);
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
			logger.error("Unable to delete Order Manager with id "+id,e);
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
