package lib;
import java.sql.*;
import java.util.*;
import java.net.*;
public class Request {
	
	public  String controller, action, ip, user_id = "null", program_id, username;
	public Connection con = null;
	public Hashtable<String, String> params = new Hashtable<String, String>();
}

