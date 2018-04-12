package lib;
import java.sql.*;

public class ConnectDb 
{   
	static 
	{
		try 
		{
			 Class.forName("org.postgresql.Driver");
		} 
		catch (ClassNotFoundException e) 
		{
			throw new IllegalArgumentException("Postgresql db driver is not on classpath");
		}
    }
	public static Connection getConnection() throws SQLException
	{
		return DriverManager.getConnection("jdbc:postgresql://localhost:5432/mahaswami","postgres", "postgres");    
	}
}
