package lib;
import java.net.*;
import java.io.*;
import java.net.URLDecoder;
public class HttpParser {
	
		
		public void parsedData(BufferedReader socket, Request request) throws Exception
		{
			String url = socket.readLine();  
			String[] line = new String[100];
			int index = 0;
		    System.out.println(url);
			while(!(line[index] = socket.readLine()).equals(""))
			{
				System.out.println(line[index]);
				if(line[index].contains("Cookie"))
				{
					//System.out.println(line[index].split("&")[2].split("=")[1]);
					request.user_id = line[index].split("&")[0].split("=")[1];
					request.program_id = line[index].split("&")[1].split("=")[1];
					request.username = line[index].split("&")[2].split("=")[1];
				}
			// }
			if (url.equals("GET / HTTP/1.1"))
			{
				request.controller = "Program";
				request.action = "index";
				request.params.put("order", "asc");
			}
			
			else if( url.contains("?"))
			{
				request.controller = url.split("/")[1];
				request.action = url.split("/")[2];
				String[] tokens;
				if (url.contains("&"))
				{
					tokens = url.split(" ")[1].split("\\?")[1].split("&|=");
				}
				else
				{	
					tokens = url.split(" ")[1].split("\\?")[1].split("=");
				}	
				for (int i = 0; i < tokens.length-1; ) 
				{
						request.params.put(tokens[i++], URLDecoder.decode(tokens[i++], "UTF-8"));
				}
			}
			else if(!url.contains("?"))
			{
				request.controller = url.split("/")[1];
				request.action = url.split("/")[2];
			}

			
	}
}
