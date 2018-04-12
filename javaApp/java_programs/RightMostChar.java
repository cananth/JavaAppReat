import java.io.*;
public class RightMostChar
{
	public static void main (String[] args)throws IOException
	{ 
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			while((line=br.readLine())!= null)
			{
				String[] word = line.split(",");
				System.out.println(word[0].lastIndexOf(word[1]));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}		
	
}

