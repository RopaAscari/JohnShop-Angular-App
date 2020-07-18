
	package database;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.sql.Statement;
	import java.util.List;
	import org.apache.logging.log4j.LogManager;
	import org.apache.logging.log4j.Logger;

abstract public class SQLBase <T>
	{
		protected Connection connect = null; // connection object to database
		protected Statement statement = null; // use to execute sql statement
		protected ResultSet result = null; // used to collect result data from 	// database
										
		private static final String DRIVER = "org.sqlite.JDBC"; 
		//private static final String DRIVER = "com.mysql.jdbc.Driver";
		private static Logger logger = LogManager.getLogger(SQLBase.class);


		
		@SuppressWarnings("deprecation")
		public SQLBase() 
		{
			try 
			{
				logger.trace("Attempting to connect to database");
				Class.forName(DRIVER).newInstance(); 
				String url = "jdbc:sqlite:Vclan5.sqlite"; 	
			//	String url = "jdbc:mysql://localhost:3306/Vclan7?useSSL=false&createDatabaseIfNotExist=true"; 
				connect = DriverManager.getConnection(url);
				
				initSQLDatabase();

				logger.info("Connected to database");
				logger.debug( "Connected to database");

			
			}// end try
			catch (SQLException ex) 
			{
				logger.error("Could not connect to database",ex);
			}// end catch
			catch (ClassNotFoundException ex) 
			{
				logger.error("Failed to load JDBC/OBDC Driver",ex);
			}// end catch
			catch (NullPointerException ex) 
			{
				logger.error("Could not find database",ex);
			}// end catch
			catch (IllegalAccessException ex) 
			{
				logger.error("Unauthorized access to the database",ex);
			} catch (InstantiationException ex) 
			{
				logger.error("Could not create instance of database",ex);
			}

		}

		   abstract protected void initSQLDatabase();
		   
		   abstract public List<T> selectAll();
		   
		   abstract public T get(int id);
		   
		   abstract public int update(T item, int id);
		   
		   abstract public int delete(int id);
		   
		   abstract public int deleteMultiple(int[] ids);
		   
		   abstract public int add(T item);
		   

}
