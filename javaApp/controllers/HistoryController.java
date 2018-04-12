package controllers;
import lib.*;
import models.*;
import java.lang.*;
import java.sql.*;
import java.util.*;

public class HistoryController {
	
	public static void programHistory(Request request, Response response) throws Exception
	 {
			ProgramHistory programhistory = new ProgramHistory();User user = new User();
			 if (!request.user_id.equals("null"))
			{
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
			}
			Program program = new Program();program.id = request.program_id;
			programhistory.history(request.con, programhistory, program);
			ViewController.showProgramHistory(response, programhistory, user);
			response.user_id = request.user_id;
			response.program_id = request.program_id;
			response.username = request.username;
	}
	
	public static void userHistory(Request request, Response response) throws Exception
	{
			User user = new User();
			 if (!request.user_id.equals("null"))
			{
				user.id = Integer.parseInt(request.user_id);
				User.getUserData(request.con, user);
				
			}
			UserHistory userhistory = new UserHistory();
			userhistory.userHistory(request.con, userhistory, user); 
			ViewController.showUserHistory(response, userhistory, user);
			response.user_id = request.user_id;
			response.program_id = request.program_id;
		
	}
	
	public static void programHistorypdf(Request request, Response response) throws Exception
	{
		ProgramHistory programhistory = new ProgramHistory();User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		Program program = new Program();program.id = request.program_id;
		programhistory.pdf(request.con, program);
		programhistory.history(request.con, programhistory, program);programhistory.flash = "pdf";
		ViewController.showProgramHistory(response, programhistory, user);
		response.user_id = request.user_id;
		response.program_id = request.program_id;
		response.username = request.username;
		
	}
	
	public static void userHistoryPdf(Request request, Response response) throws Exception
	{
		User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		UserHistory userhistory = new UserHistory();
		userhistory.pdf(request.con, userhistory, user); 
		userhistory.userHistory(request.con, userhistory, user);userhistory.flash = "pdf"; 
		ViewController.showUserHistory(response, userhistory, user);
		response.username = request.username;
		userHistory(request, response);
	}
}

