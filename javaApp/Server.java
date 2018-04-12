import java.io.*;

import java.util.*;
import java.sql.*;
import lib.*;
import controllers.ProgramController;
import controllers.UserController;
import controllers.HistoryController;
import controllers.MailController;
import models.Program;
import models.User;
import mappers.ProgramMapper;
import mappers.UserMapper;
import controllers.AssetController;
import models.ProgramHistory;
import mappers.ProgramHistoryMapper;
import models.UserHistory;
import mappers.UserHistoryMapper;
import mailer.Mailer;
import java.lang.*;
import java.net.*;
class Server {

    public static void main(String args[] ) throws IOException {
		
		ServerSocket server = new ServerSocket(3000); 
		BufferedReader socketReader = null;
		BufferedWriter socketWriter = null;
		DataOutputStream dout = null;
		while (true) 
		{ 
		  try (Socket socket = server.accept()) 
		  {
		   	
			Request request = new Request();
			request.con =  ConnectDb.getConnection();
			InetAddress IP=InetAddress.getLocalHost();
			request.ip  = IP.toString();
			Response response = new Response();
			HttpParser parser = new HttpParser();
			Router router = new Router();
			socketReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			socketWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			dout = new DataOutputStream(socket.getOutputStream()); 
			parser.parsedData(socketReader, request);
			router.mapController(request);
			Object controller = Class.forName("controllers." + request.controller).newInstance();
			controller.getClass().getMethod(request.action, Request.class, Response.class).invoke(controller, request, response);
			if(response.imageContent != null){
				dout.write(response.imageContent);
			}
			socket.getOutputStream().write((response.setCookie(response) + response.data).getBytes("UTF-8"));
			
		    dout.flush();
		    
		  }
		  catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}	

}
