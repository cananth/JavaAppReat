package mappers;
import lib.*;
import models.*;
import java.sql.*;
import java.net.URLDecoder;
public class UserMapper {
	
	
	public static void userValidation(Request request, User user) throws Exception
	{
		 PreparedStatement prepareStatement = request.con.prepareStatement("SELECT * from users where user_name = ? and password = ? ");
		 prepareStatement.setString(1,request.params.get("name"));
		 prepareStatement.setString(2,request.params.get("password"));
		 user.result = prepareStatement.executeQuery();
		 
	}
	
	public static ResultSet addUser(Request request, Response response) throws Exception
	{
		 PreparedStatement prepareStatement = request.con.prepareStatement("select * from users where emailid = ? or user_name = ?"); 
		 prepareStatement.setString(1, request.params.get("email"));
		 prepareStatement.setString(2, request.params.get("name"));
	    ResultSet result = prepareStatement.executeQuery();
	    if (!result.isBeforeFirst())
	    {	
			System.out.println("signup");
			prepareStatement = request.con.prepareStatement("insert into users(user_name, password, emailid) values (?, ?, ?)");
			prepareStatement.setString(1,request.params.get("name"));
			prepareStatement.setString(2,request.params.get("password"));
			prepareStatement.setString(3, request.params.get("email"));
			 prepareStatement.executeUpdate();
			 
			return result;
			
		}
		else
		{
			return result;
		}
		
	
	}
	
	public static void update(Connection con, User user) throws Exception
	{
		PreparedStatement prepareStatement = con.prepareStatement("update users set user_name = ? where id = ?"); 
		prepareStatement.setString(1, user.user_name);
		prepareStatement.setInt(2, user.id);
		prepareStatement.executeUpdate();
		
	}
	
	public static void getData(Connection con, User user) throws Exception
	{
		 PreparedStatement prepareStatement = con.prepareStatement("SELECT * from users where id = ?");
		 prepareStatement.setInt(1,user.id);
		 user.result = prepareStatement.executeQuery();
	}
		
}




