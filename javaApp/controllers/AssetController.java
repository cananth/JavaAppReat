package controllers;
import lib.*;
import java.io.*;
 import java.nio.file.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class AssetController 
{
	
	public static void assets(Request request, Response response) throws Exception
	{
		
		if ((request.params.get("file").contains(".png")) || (request.params.get("file").contains(".jpg")) )
		{	
			String file = request.params.get("file");
			response.contentType = "image/png";
            String folder = "/assets/images/";
            Path currentRelativePath = Paths.get("");
            String currentPath = currentRelativePath.toAbsolutePath().toString();
            Path path = Paths.get(currentPath+folder+file);
            response.data = new String(Files.readAllBytes(path));
            response.imageContent = Files.readAllBytes(path);
		}
		
		 if( request.params.get("file").contains(".css") )
		{
			BufferedReader br = new BufferedReader(new FileReader("assets/css/" + request.params.get("file")));
			String data = "", line;
			while ( (line = br.readLine()) != null)
			{
				data += line;
			}
			response.data = data;
			response.contentType = "text/css"; 
		}
		if( request.params.get("file").contains(".js") )
		{
				System.out.println(request.params.get("file"));
				String folder = "/assets/js/";
				String filename = request.params.get("file");
				Path currentRelativePath = Paths.get("");
				String currentPath = currentRelativePath.toAbsolutePath().toString();
				Path path = Paths.get(currentPath+folder+filename);
				response.data = new String(Files.readAllBytes(path));
				response.contentType = "application/js";
			
			
		}
		response.program_id = request.program_id;
		response.user_id = request.user_id;
		response.username = request.username;
		response.statusCode = 200;
	}
}

