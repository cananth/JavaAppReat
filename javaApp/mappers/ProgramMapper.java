package mappers;
import lib.*;
import java.sql.*;
import models.*;
import java.net.URLDecoder;
public class ProgramMapper {
	
	public static void getData(Request request, Program program) throws Exception
	{
		Statement st = request.con.createStatement();
		String sql = ("SELECT * FROM programs order by  program_name"+ " "+program.order+ " " + "offset" + " " + program.offset + "limit 7");
		 program.result = st.executeQuery(sql);
		
		
	}
	
	public static void description(Connection con, Program program) throws Exception
	{
		 PreparedStatement prepareStatement = con.prepareStatement("SELECT * from programs where id = ?");
		 prepareStatement.setInt(1,Integer.parseInt(program.id));
		  program.result = prepareStatement.executeQuery();
		
	}
	
	public static void addNewProgram(Connection con, Program program, User user) throws Exception
	{
		PreparedStatement prepareStatement = con.prepareStatement("insert into programs(program_name, program_description, author) values(?, ?, ?)");
		prepareStatement.setString(1, program.programName);
		prepareStatement.setString(2, program.programDescription);
		prepareStatement.setString(3, user.user_name);
		prepareStatement.executeUpdate();
	}
	
	public static void updateProgram(Connection con, Program program, User user) throws Exception
	{
		PreparedStatement prepareStatement = con.prepareStatement("update programs set program_name = ?, program_description = ?, author = ? where id = ?");
		prepareStatement.setString(1, program.programName);
		prepareStatement.setString(2, program.programDescription);
		prepareStatement.setString(3, user.user_name);
		prepareStatement.setInt(4, Integer.parseInt(program.id));
		prepareStatement.executeUpdate();
	}	
	
	public static void deleteProgram(Connection con, Program program) throws Exception
	{
		PreparedStatement prepareStatement = con.prepareStatement("delete from programs where id = ?");
		prepareStatement.setInt(1, Integer.parseInt(program.id));
		prepareStatement.executeUpdate();
	}	
		

	
		
	
	
}

