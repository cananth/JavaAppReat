package models;
import mappers.*;
import lib.*;
import java.sql.*;
import java.io.*;
import java.net.URLDecoder;
import java.util.*;
public class Program 
{
	public String dataBaseContent = "", programName="", programDescription, programCode, author, flash, order = "null";
	public String id;
	public static ResultSet result;
	public int count, offset;
	public static void getIndex(Request request, Program program) throws Exception
	{
		if (program.order == "null")
		{
			program.order = "asc";
		}
		ProgramMapper.getData(request, program);
		
	}
	
	public static void getShow(Connection con, Program program) throws Exception
	{
		 ProgramMapper.description(con, program);
		ProgramHistory.count(con, program);
	}
	
	public static void getOutput(Connection con, Program program, ProgramHistory programhistory) throws Exception
	{
		File input = new File("java_programs/input.txt");
		FileWriter writer = new FileWriter(input);
		writer.write(URLDecoder.decode(programhistory.input, "UTF-8"));
      	writer.close();
      		
        ProgramMapper.description(con, program);
         
		while(result.next() == true)
		{
			program.programName = result.getString("program_name");
		}
		program.programName = program.programName.replaceAll(" ","");
		System.out.println(program.programName);	
		Runtime rt = Runtime.getRuntime();
		Process pro1 = rt.exec("javac java_programs/" + program.programName + ".java");
		Process pro2 = rt.exec("java -cp java_programs" + " " + program.programName + " " + "java_programs/input.txt"); 
		BufferedReader br = new BufferedReader(new InputStreamReader(pro2.getInputStream()));
		String  line;
		while( (line = br.readLine()) != null)
		{
		     programhistory.output += line + "\r\n";	
		}
		if(programhistory.useroutput == programhistory.output)
		{
			programhistory.status = "true";
		}
		else
		{
			programhistory.status = "true";
		}	
		programhistory.store(con, program, programhistory);
		programhistory.count(con, program);
	}
	
	public static void add(Connection con, Program program, User user) throws Exception
	{
		ProgramMapper.addNewProgram(con, program, user);
		File input = new File("java_programs/" + program.programName +".java");
		FileWriter writer = new FileWriter(input);
		writer.write(program.programCode);
      	writer.close();
	}
	
	public static void dataForUpdate(Connection con, Program program, User user) throws Exception
	{
		ProgramMapper.description(con, program);
		while(program.result.next())
		{
			program.programName = program.result.getString("program_name");
			program.programDescription = program.result.getString("program_description");
		}	
			BufferedReader br = new BufferedReader(new FileReader("java_programs/"+ program.programName.replaceAll(" ","") +".java"));
			String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			program.programCode += line;
		}
		
	}
	
	public static void updateTheProgram(Connection con, Program program, User user) throws Exception
	{
		ProgramMapper.description(con, program);
		while(program.result.next())
		{
			File file = new File("java_programs/" + program.result.getString("program_name").replaceAll(" ","") +".java");
			file.delete();
		}	 
		ProgramMapper.updateProgram(con, program, user);
		System.out.println(program.programName);
		File input = new File("java_programs/" + program.programName +".java");
		FileWriter writer = new FileWriter(input);
		writer.write(program.programCode);
		
	}
	
	public static void delete(Connection con, Program program) throws Exception
	{
		ProgramMapper.deleteProgram(con, program);
		
	}
}
