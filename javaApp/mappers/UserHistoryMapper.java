package mappers;
import lib.*;
import java.sql.*;
import models.*;
import java.net.URLDecoder;
public class UserHistoryMapper {
	
	public static void storeUserHistory (Request request, User user, UserHistory userhistory) throws Exception
	{
		PreparedStatement prepareStatement = request.con.prepareStatement("insert into login_histories(user_id, login_time, date, ip) values(?, ?, ?, ?)");
		prepareStatement.setInt(1, user.id);
		prepareStatement.setString(2, userhistory.time);
		prepareStatement.setString(3, userhistory.date);
		prepareStatement.setString(4, request.ip);
		prepareStatement.executeUpdate();
		
	}
	
	public static void fetchUserHistory(Connection con, UserHistory userhistory, User user) throws Exception
	{
		PreparedStatement prepareStatement = con.prepareStatement("SELECT * from login_histories where user_id = ?");
		 prepareStatement.setInt(1,user.id);
		 userhistory.result = prepareStatement.executeQuery();
		
		
	}
	
	public static void getCount(Connection con, User user) throws Exception
	{
		PreparedStatement prepareStatement = con.prepareStatement("SELECT COUNT(user_id) from login_histories where user_id = ?");
		 prepareStatement.setInt(1,user.id);
		 user.result = prepareStatement.executeQuery();
	}
	
}

