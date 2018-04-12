package controllers;
import lib.*;
import models.*;
import java.lang.*;
import java.sql.*;
import java.util.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
public class ProgramController {

	public static void index(Request request, Response response) throws Exception
	{
		 Program program = new Program();User user = new User();program.order = request.params.get("order");
		 if ((!request.user_id.equals("null")))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
		 }
		 ProgramHistory programhistory = new ProgramHistory();	
		 ViewController.index(request, response, program, user);
		 response.program_id = request.program_id;response.user_id = request.user_id;response.username = user.user_name;
	}
	
	public static void show(Request request, Response response) throws Exception
	{
		 Program program = new Program();User user = new User();ProgramHistory programhistory = new ProgramHistory();
		 if (!request.user_id.equals("null"))
			{
				user.id = Integer.parseInt(request.user_id);
				User.getUserData(request.con, user);
			}
		System.out.println(request.params.get("id"));	
		 if(!request.params.get("id").equals("data"))
		 {
			 response.program_id = request.params.get("id");
			  ViewController.show(response, program, programhistory, user);	 
		 }	 
		 else if(request.params.get("id").equals("data"))
		 {	
			 System.out.println("showwwwwwwwwwwwwwwwwwwwww");
		    program.id = request.program_id;
		    program.getShow(request.con, program);
		    JSONArray json = new JSONArray();
			ResultSetMetaData metadata = program.result.getMetaData();
			int numColumns = metadata.getColumnCount();
			while(program.result.next())             
			{
				JSONObject obj = new JSONObject();      
				for (int i = 1; i <= numColumns; ++i)           
				{
					String column_name = metadata.getColumnName(i);
					obj.put(column_name, program.result.getObject(column_name));	
				}
				obj.put("username",user.user_name);
				json.put(obj); 
			
			}
		    response.program_id = program.id; 
		    response.data = json.toString();
		 }	
		
		 response.user_id = request.user_id;
		 response.username = request.username;
	}
	
	public static void execute(Request request, Response response) throws Exception
	{
		
		Program program = new Program();User user = new User();program.id = request.program_id;
		 if( request.user_id.equals("null"))
		{
			UserController.login(request, response);
			
		}
		else
		{	
			ProgramHistory programhistory = new ProgramHistory();
			 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			
		 }
			program.id = request.params.get("id");programhistory.ip = request.ip;programhistory.input = request.params.get("input");programhistory.useroutput = request.params.get("output");
			program.getOutput(request.con, program, programhistory);
			program.getShow(request.con, program); 
			if (programhistory.useroutput == null)
			{
				ViewController.show(response, program, programhistory, user);
			}
			else
			{
				ViewController.status(response, programhistory);
			}	 
			
		 } 	
		
		 response.user_id = request.user_id;
		 response.program_id = program.id;
		 response.username = request.username;
	}
	
	public static void addProgram(Request request, Response response) throws Exception
	{
		 User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		 ViewController.showAdd(response, user);
		 response.program_id = request.program_id;
		 response.user_id = request.user_id;
		 response.username = request.username;
	}
	
	public static void create(Request request, Response response) throws Exception
	{
		 Program program = new Program();User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		 program.programName = request.params.get("programname");program.programDescription = request.params.get("description");program.programCode = request.params.get("code");
	     program.add(request.con, program, user);
	     Program.getIndex(request, program);program.flash = "true";program.order = "ASC";
		 ViewController.index(request, response, program, user);
		 response.program_id = request.program_id;
		 response.user_id = request.user_id;
		 response.username = request.username;
	}
	
	public static void updateProgram(Request request, Response response) throws Exception
	{
		 Program program = new Program();User user = new User();program.id = request.program_id;
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		 program.dataForUpdate(request.con, program, user);
		 ViewController.update(response, program, user);
		 response.program_id = request.program_id;
		 response.user_id = request.user_id;
		 System.out.println("fssss" + request.username);
		 response.username = request.username;
	}
	
	public static void update(Request request, Response response) throws Exception
	{
		 Program program = new Program();User user = new User();ProgramHistory programhistory = new ProgramHistory();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		 program.programName = request.params.get("name");program.programDescription = request.params.get("description");program.programCode = request.params.get("code");program.id = request.program_id;
		 System.out.println(program.programName + program.programDescription);
		 program.updateTheProgram(request.con, program, user);
		 program.getShow(request.con, program);program.flash = "true";
		 ViewController.show(response, program, programhistory, user);
		 response.program_id = request.program_id;
		 response.user_id = request.user_id;
		 System.out.println("update" + request.username);
		 response.username = request.username;
		
	}
	
	public static void destroy(Request request, Response response) throws Exception
	{
		 Program program = new Program();program.id = request.program_id;User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		 program.delete(request.con, program);
		 Program.getIndex(request, program);program.flash = "false";program.order = "ASC";
		 ViewController.index(request, response, program, user);
		 response.user_id = request.user_id;
		 response.username = request.username;
	}
	
	public static void tableContent(Request request, Response response) throws Exception
	{
		 Program program = new Program();User user = new User();program.order = request.params.get("order");program.offset = Integer.parseInt(request.params.get("offset"));
		 if ((!request.user_id.equals("null")))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
		 }
		 ProgramHistory programhistory = new ProgramHistory();	
		 Program.getIndex(request, program);
		 JSONArray json = new JSONArray();
		 ResultSetMetaData metadata = program.result.getMetaData();
		 int numColumns = metadata.getColumnCount();
		 while(program.result.next())             
		 {
			JSONObject obj = new JSONObject();      
			for (int i = 1; i <= numColumns; ++i)           
			{
				String column_name = metadata.getColumnName(i);
				obj.put(column_name, program.result.getObject(column_name));
				
			}
			obj.put("username",user.user_name);
			json.put(obj); 
			
		 }
		
		 response.program_id = request.program_id;response.user_id = request.user_id;response.username = request.username;
		 response.data = json.toString();
	}
}
