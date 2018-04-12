package controllers;
import lib.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import models.*;
import mailer.*;
public class ViewController {
	
	public static void index(Request request, Response response, Program program, User user) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/programs/index.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		 response.data = data;
		 String content = " ";
		 int index = 1;
		
		System.out.println(user.user_name);
		  if( (user.user_name == null) || (user.user_name.equals("null")) || user.user_name.isEmpty())
		{
			response.data = response.data.replaceAll("change"," ");
			response.data = response.data.replaceAll("CHANGE"," ");
			System.out.println("change");
		}
		else
		{
			response.data = response.data.replaceAll("<!--","");
			response.data = response.data.replaceAll("-->","");
			response.data = response.data.replaceAll("change","<!--");
			response.data = response.data.replaceAll("CHANGE","-->");
			response.data = response.data.replaceAll("Guest",user.user_name);
			response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
			response.data = response.data.replaceAll("count",Integer.toString(user.count));
		}
		if(user.flash == "true")
		{
			String flash = String.format("<div id=flash><div id=hideMe>U have Successfully logged in!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}
		else if (user.flash == "truesignup")
		{
			String flash = String.format("<div id=flash><div id=hideMe>U have Successfully Signed in!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}else if (program.flash == "true")
		{
			String flash = String.format("<div id=flash><div id=hideMe>Program Is Successfully Added!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}
		else if(program.flash == "false")
		{
			String flash = String.format("<div id=flash><div id=hideMe>Program Is Successfully Deleted!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}
		else if(user.flash == "false")
		{
			String flash = String.format("<div id=flash><div id=hideMe>You Hava Successfully Logged Out...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}else
		{
			response.data = response.data.replaceAll("flash","");
		}
		if (program.order.equals("DESC"))
		{
			System.out.println(program.order);
			response.data = response.data.replaceAll("descend","ascend");
			response.data = response.data.replaceAll("DESC","ASC");
		}else if (program.order.equals("ASC"))
		{
			response.data = response.data.replaceAll("ascend","descend");
			response.data = response.data.replaceAll("ASC","DESC");
		}
			
		response.data = response.data.replaceAll("Data",content);
			
		response.contentType = "text/html";
		response.statusCode = 200;
	}
	
	public static void getLogin(User user, ProgramHistory programhistory, Response response) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/users/login.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		if (programhistory.input != null)
		response.data = response.data.replaceAll("INPUT",programhistory.input);
		if (user.flash == "false")
		{ 
			String flash = String.format(" <p style = color: red; font-size: 26px;>Please, enter valid Username and Password!</p>");
			response.data = response.data.replaceAll("flash", flash);
		}
		
		response.contentType = "text/html";
		response.statusCode = 200;
	}
	
	public static void getSignup(User user, Request request, Response response) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/users/signup.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		if (user.flash == "false")
		{
			String flash = String.format("<p id=message style = color: red; font-size: 26px;>Please, enter valid Username and Password!</p>");
			response.data = response.data.replaceAll("flash", flash);
		}
		response.contentType = "text/html";
		response.statusCode = 200;
	}
	
	public static void show(Response response, Program program, ProgramHistory programhistory, User user) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/programs/description.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		 String content = "";
		/*while((program.result.next()) == true)
		{
			content += String.format("<pre>%s</pre>", program.result.getString("program_description"));
			program.author = program.result.getString("author");
			program.programName = program.result.getString("program_name");
		}
		 if( (user.user_name == null) || (user.user_name.equals("null")) || user.user_name.isEmpty())
		{
			response.data = response.data.replaceAll("change"," ");
			response.data = response.data.replaceAll("CHANGE"," ");
			System.out.println("change");
		}
		else if (user.user_name.equals(program.author))
		{
			response.data = response.data.replaceAll("<!--","");
			response.data = response.data.replaceAll("-->","");
			response.data = response.data.replaceAll("change","<!--");
			response.data = response.data.replaceAll("CHANGE","-->");
			response.data = response.data.replaceAll("similar","");
			response.data = response.data.replaceAll("SIMILAR","");
			response.data = response.data.replaceAll("Guest",user.user_name);
			response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
			response.data = response.data.replaceAll("count",Integer.toString(user.count));
			response.data = response.data.replaceAll("pg_c",Integer.toString(program.count));
		}	
			
		else 
		{
			System.out.println("username");
			response.data = response.data.replaceAll("<!--","");
			response.data = response.data.replaceAll("-->","");
			response.data = response.data.replaceAll("change","<!--");
			response.data = response.data.replaceAll("CHANGE","-->");
			response.data = response.data.replaceAll("similar","<!--");
			response.data = response.data.replaceAll("SIMILAR","-->");
			response.data = response.data.replaceAll("Guest",user.user_name);
		   response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
			response.data = response.data.replaceAll("count",Integer.toString(user.count));
			response.data = response.data.replaceAll("pg_c", Integer.toString(program.count));
		}
		if (user.flash == "true")
		{
			String flash = String.format("<div id=flash>1<div id=hideMe>U have Successfully logged in!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
			
		}
		else if(program.flash == "true")
		{
			String flash = String.format("<div id=flash1><div id=hideMe>Program Is Successfully Updated!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}
		
		System.out.println(content);
		response.data = response.data.replaceAll("author",program.author);
		response.data = response.data.replaceAll("PROGRAMNAME",program.programName);
		response.data = response.data.replaceAll("DATA", content);
		response.data = response.data.replaceAll("intid",program.id);
		response.data = response.data.replaceAll("iinput", programhistory.input);
		response.data = response.data.replaceAll("ooutput", programhistory.output);*/
		response.contentType = "text/html";
		response.statusCode = 200;
	}
	
	public static void showProgramHistory(Response response, ProgramHistory programhistory, User user) throws Exception
	{
		
		BufferedReader br = new BufferedReader(new FileReader("views/history/program_history.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		  String content = "";
		 int index = 1;
		while(programhistory.result.next())
		{
			content += String.format("<tr><td>%d</td><td>%s</td><td><textarea>%s</textarea></td><td><textarea>%s</textarea></td><td>%s</td><td>%s</td><td>%s</td></tr>", index, programhistory.result.getInt("program_index"), programhistory.result.getString("input"), programhistory.result.getString("output"), programhistory.result.getString("time").substring(11,19), programhistory.result.getString("date"), programhistory.result.getString("ip_address").split("/")[1]);
			index += 1;
		}
		if(programhistory.flash == "pdf")
		{
			String flash = String.format("<div id=flash1><div id=hideMe>Pdf has been Downloaded!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}else if(programhistory.flash == "email")
		{
			String flash = String.format("<div id=flash1><div id=hideMe>Email has been Sent!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}
		response.data = response.data.replaceAll("Data", content);
		response.data = response.data.replaceAll("Guest",user.user_name);
		response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
			response.data = response.data.replaceAll("count",Integer.toString(user.count));
		response.contentType = "text/html";
		response.statusCode = 200;
	}
	
	public static void showUserHistory(Response response, UserHistory userhistory, User user) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/history/login_history.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		  String content = "";
		 int index = 1;
		while(userhistory.result.next())
		{
			content += String.format("<tr><td>%d</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td></tr>", index, userhistory.result.getInt("user_id"), userhistory.result.getString("login_time").substring(11,19), userhistory.result.getString("date"), userhistory.result.getString("ip").split("/")[1]);
			index += 1;
		}
		if( !user.user_name.equals("null"))
		{
			response.data = response.data.replaceAll("Guest",user.user_name);
			response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
			
		}
		if(userhistory.flash == "pdf")
		{
			String flash = String.format("<div id=flash2><div id=hideMe>Pdf has been Downloaded!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}else if(userhistory.flash == "email")
		{
			String flash = String.format("<div id=flash2><div id=hideMe>Email has been Sent!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
		}
		response.data = response.data.replaceAll("Data", content);
		response.contentType = "text/html";
		response.statusCode = 200;
		
		
	}
	
	public static void contact(Response response, User user, Mailer mailer) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/mailer/contact_us.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		/*if( !user.user_name.equals("null"))
		{
			response.data = response.data.replaceAll("<!--","");
			response.data = response.data.replaceAll("-->","");
			response.data = response.data.replaceAll("change","<!--");
			response.data = response.data.replaceAll("CHANGE","-->");
			response.data = response.data.replaceAll("Guest",user.user_name);
			response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
		}
		else
		{
			
			response.data = response.data.replaceAll("change"," ");
			response.data = response.data.replaceAll("CHANGE"," ");
		}
		if (mailer.flash == "true")
		{
			String flash = String.format("<div id=flash1><div id=hideMe>Email has been Sent!...</div></div>");
			response.data = response.data.replaceAll("flash",flash);
			
		}*/
		response.contentType = "text/html";
		response.statusCode = 200;
		
	}
	public static void showAdd(Response response, User user) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/programs/add_program.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		
		response.data = data;
		response.data = response.data.replaceAll("Guest",user.user_name);
		response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
		response.contentType = "text/html";
		response.statusCode = 200;	
	}
	
	public static void update(Response response, Program program, User user) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/programs/update_program.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		if( !user.user_name.equals("null"))
		{
			response.data = response.data.replaceAll("Guest",user.user_name);
			response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
		}
		response.data = response.data.replaceAll("desp", program.programDescription);
		response.data = response.data.replaceAll("program_name", program.programName);
		response.data = response.data.replaceAll("prg_code", program.programCode);
		response.contentType = "text/html";
		response.statusCode = 200;
	}
	
	public static void mailProgramHistoryPdf(Response response, User user) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/mailer/mail_program_pdf.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		if( !user.user_name.equals("null"))
		{
			response.data = response.data.replaceAll("Guest",user.user_name);
			response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
		}
		response.contentType = "text/html";
		response.statusCode = 200;
		
		
	}
	
	public static void mailLoginHistoryPdf(Response response, User user) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/mailer/mail_login_pdf.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		if( !user.user_name.equals("null"))
		{
			response.data = response.data.replaceAll("Guest",user.user_name);
			response.data = response.data.replaceAll("username",user.user_name);
			response.data = response.data.replaceAll("email",user.email);
		}
		response.contentType = "text/html";
		response.statusCode = 200;
		
		
	}
	
	public static void status(Response response, ProgramHistory programhistory) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("views/programs/compare.html"));
		String data = "", line;
		while ( (line = br.readLine()) != null)
		{
			data += line;
		}
		response.data = data;
		response.data =  response.data.replaceAll("actual",programhistory.output);
		response.data = response.data.replaceAll("output",programhistory.useroutput);
		response.data = response.data.replaceAll("PROGRMstatus",programhistory.status);
		response.contentType = "text/html";
		response.statusCode = 200;
	}
}

