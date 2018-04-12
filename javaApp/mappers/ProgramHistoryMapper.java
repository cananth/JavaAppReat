package mappers;
import lib.*;
import java.sql.*;
import models.*;
import java.net.URLDecoder;
public class ProgramHistoryMapper {
	
	public static void programHistory(Connection con, Program program, ProgramHistory programhistory) throws Exception
	{
 			PreparedStatement prepareStatement = con.prepareStatement("insert into program_histories(program_index, input, output, time, date, ip_address) values(?, ?, ?, ?, ?, ?)");
			prepareStatement.setInt(1, Integer.parseInt(program.id));
			prepareStatement.setString(2, programhistory.input);
			prepareStatement.setString(3,URLDecoder.decode(programhistory.output, "UTF-8"));
			prepareStatement.setString(4, programhistory.time);
			prepareStatement.setString(5, programhistory.date);
			prepareStatement.setString(6,programhistory.ip);
			prepareStatement.executeUpdate();
			
	}
	
	public static void programHistoryData(Connection con,  ProgramHistory programhistory, Program program) throws Exception
	{
		PreparedStatement prepareStatement = con.prepareStatement("SELECT * from program_histories where program_index = ?");
		 prepareStatement.setInt(1,Integer.parseInt(program.id));
		programhistory.result = prepareStatement.executeQuery();
		
	}
	
	public static ResultSet getCount(Connection con, Program program) throws Exception
	{
		PreparedStatement prepareStatement = con.prepareStatement("SELECT COUNT(program_index) from program_histories where program_index = ?");
		  prepareStatement.setInt(1,Integer.parseInt(program.id));
		ResultSet result = prepareStatement.executeQuery();
		return result;
	}
	
}

