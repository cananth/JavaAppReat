package controllers;
import mailer.*;
import models.*;
import lib.*;
import java.sql.*;
import java.net.URLDecoder;
public class MailController {
	
	public static void contactUs(Request request, Response response) throws Exception
	{
		Mailer mailer = new Mailer();User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		ViewController.contact(response, user, mailer);
		response.user_id = request.user_id;
		response.program_id = request.program_id;
		response.username = request.username;
	}
	public static void sendMail(Request request, Response response) throws Exception
	{
		User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		Mailer mailer = new Mailer();mailer.flash = "true";
		mailer.email = request.params.get("mail");
		mailer.name = request.params.get("name");
		mailer.subject = request.params.get("subject");
		mailer.message = request.params.get("message");
		mailer.send(mailer);
		ViewController.contact(response, user, mailer);	
	}
	
	public static void sendProgramPdf(Request request, Response response) throws Exception
	{
		User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		ViewController.mailProgramHistoryPdf(response, user);
		response.program_id = request.program_id;
		 response.user_id = request.user_id;
		 response.username = request.username;
	}
	
	public static void mailProgramPdf(Request request, Response response) throws Exception
	{
		Mailer mailer = new Mailer();ProgramHistory programhistory = new ProgramHistory();Program program = new Program();User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		program.id = request.program_id;user.user_name = request.username;
		mailer.email = request.params.get("to");
		mailer.cc = request.params.get("cc");
		mailer.bcc = request.params.get("bcc");
		mailer.message = request.params.get("message");
		mailer.attachment = request.params.get("attachment");
		mailer.sendPdf(mailer);
		programhistory.history(request.con, programhistory, program);programhistory.flash = "email";
		ViewController.showProgramHistory(response, programhistory, user);
		response.program_id = request.program_id;response.user_id = request.user_id;response.username = request.username;
		
		
	}
	
	public static void sendLoginPdf(Request request, Response response) throws Exception
	{
		User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		ViewController.mailLoginHistoryPdf(response, user);
		response.program_id = request.program_id;
		 response.user_id = request.user_id;
		 response.username = request.username;
	}
	
	public static void mailLoginPdf(Request request, Response response) throws Exception
	{
		Mailer mailer = new Mailer();UserHistory userhistory = new UserHistory();User user = new User();
		 if (!request.user_id.equals("null"))
		 {
			 user.id = Integer.parseInt(request.user_id);
			 User.getUserData(request.con, user);
			 System.out.println("user.user_name");
		 }
		mailer.email = request.params.get("to");
		mailer.cc = request.params.get("cc");
		mailer.bcc = request.params.get("bcc");
		mailer.message = request.params.get("message");
		mailer.attachment = request.params.get("attachment");
		mailer.sendPdf(mailer);
		userhistory.userHistory(request.con, userhistory, user);userhistory.flash = "email"; 
		ViewController.showUserHistory(response, userhistory, user);
		response.program_id = request.program_id;response.user_id = request.user_id;response.username = request.username;
		
	}
	
	
	
	
}
  
