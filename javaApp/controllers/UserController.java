package controllers;
import models.*;
import lib.*;
import java.sql.*;
public class UserController {
	
	public static void login(Request request, Response response) throws Exception
	{
		User user = new User();ProgramHistory programhistory = new ProgramHistory();programhistory.input = request.params.get("input");
		ViewController.getLogin(user, programhistory, response);
		response.program_id = request.program_id;
		response.user_id = request.user_id;
		response.username = request.username;
	}
	
	public static void validation(Request request, Response response) throws Exception
	{
		User user = new User();Program program = new Program(); ProgramHistory programhistory = new ProgramHistory();
		User.validate(request, user);
		System.out.println(user.id);
		if((user.id != 0) && (request.program_id.equals("null")))
		{
			Program.getIndex(request, program);user.flash ="true";program.order = "ASC";
		    ViewController.index(request, response, program, user);
		}
		else if ((!request.program_id.equals("null")) && (user.id != 0))
		{
			
			 program.id = request.program_id;program.getShow(request.con, program);user.flash = "true";programhistory.input = request.params.get("input");
		 ViewController.show(response, program, programhistory, user);
			
		}
		else 
		{ 
			programhistory.input = request.params.get("input");user.flash = "false";
			ViewController.getLogin(user, programhistory, response);
		}
			System.out.println(user.user_name);
		    response.username = user.user_name;
		    System.out.println(response.username);
			response.user_id = String.valueOf(user.id);
			response.program_id = request.program_id;
			
	}
	
	public static void signup(Request request, Response response) throws Exception
	{
		User user = new User();
		ViewController.getSignup(user, request, response);
		response.program_id = request.program_id;
		response.user_id = request.user_id;
		response.username = request.username;
	}
	
	public static void create(Request request, Response response) throws Exception
	{
		User user = new User();Program program = new Program();
		ResultSet result = User.registerUser(request, response);
		if(result.isBeforeFirst())
		{	
			user.flash = "false";
			ViewController.getSignup(user, request, response);
		}
		else
		{
			User.validate(request, user);
			 Program.getIndex(request, program);user.flash ="truesignup";program.order = "ASC";
		 ViewController.index(request, response, program, user);
		}
		response.username = user.user_name;
			response.user_id = String.valueOf(user.id);
			response.program_id = request.program_id;
		
	}
	
	public static void update(Request request, Response response) throws Exception
	{ 
		User user = new User();user.user_name = request.params.get("Username");user.id = Integer.parseInt(request.user_id);
		user.userUpdate(request.con, user);
		ProgramController.index(request, response);
		
		
	}
	
	public static void logout(Request request, Response response) throws Exception
	{
		request.user_id = null;request.program_id = null;request.username = null;Program program = new Program();User user = new User();user.user_name = request.username;
		Program.getIndex(request, program);user.flash ="false";program.order = "ASC";
		 ViewController.index(request, response, program, user);
	}
}

