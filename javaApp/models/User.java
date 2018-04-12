package models;
import mappers.*;
import lib.*;
import java.sql.*;
public class User {
	
	public int id, count;
	public String user_name = null, flash, email;
	public ResultSet result = null;
	public static void validate(Request request, User user) throws Exception
	{
		 UserMapper.userValidation(request, user);
		 if (user.result.next() == true)
		 {
			 user.id = user.result.getInt("id");
			 user.user_name = user.result.getString("user_name");
			 user.email = user.result.getString("emailid");
			 UserHistory.store(request, user);	
			 UserHistory.count(request.con, user);		
		}
	}
	
	public static ResultSet registerUser(Request request, Response response) throws Exception 
	{
	  ResultSet result =  UserMapper.addUser(request, response); 
	  return result;
	}
	
	public static void userUpdate(Connection con, User user) throws Exception
	{
		UserMapper.update(con, user);
		
	}
	
	public static void getUserData(Connection con, User user) throws Exception
	{
		UserMapper.getData(con, user);
		if (user.result.next() == true)
		 {
			 user.id = user.result.getInt("id");
			 user.user_name = user.result.getString("user_name");
			 user.email = user.result.getString("emailid");
		}
		UserHistory.count(con, user);
		
	}
	
	
}

