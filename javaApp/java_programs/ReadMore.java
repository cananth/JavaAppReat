 import java.io.*;
 import java.util.*;
 class ReadMore {
	public static void main (String[] args)throws IOException 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			while((line = br.readLine()) != null)
			{
				line = line.trim();
				if (line.length() > 55)
				{
					System.out.print( line.substring(0,39) + "<...Read More>");
				}
				else if(line.length() > 0 && line.length() < 55)
				{
					System.out.print( line );
				}
				else
				{
					System.out.print(" no input to process");
				}
				System.out.println();
			}			
		}
		catch( Exception e)
		{
			e.printStackTrace();
		}	
	}
}

