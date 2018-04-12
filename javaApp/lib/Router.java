package lib;
import java.util.*;
public class Router {
	
	public static void mapController(Request request)
	{
		try
		{
		 Hashtable<String, String> hash = new Hashtable<String, String>();
		 hash.put("Program", "ProgramController");
		 hash.put("User", "UserController");
		 hash.put("History", "HistoryController");
		 hash.put("LoginHistory", "LoginHistoryController");
		 hash.put("Mail","MailController");
		 hash.put("Asset","AssetController");
		 request.controller = hash.get(request.controller);
		}
		catch(NullPointerException e)
		{
			System.out.println("Controller not found");
		}

	}
	
}

