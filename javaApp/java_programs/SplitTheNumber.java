import java.io.*;
public class SplitTheNumber 
{
	public static void main (String[] args)throws IOException 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			String[] words;
			int position;
			while((line=br.readLine())!= null)
			{
				line = line.trim();
				words = line.split(" ");
				long result = 0;
				if (words[1].contains("+"))
				{
					String[] splitted = words[1].split("\\+");
					result = Long.parseLong(words[0].substring(0, splitted[0].length())) + Long.parseLong(words[0].substring(splitted[0].length()));
				}	
				else if (words[1].contains("-"))
				{
					String[] splitted = words[1].split("\\-");
					result = Long.parseLong(words[0].substring(0, splitted[0].length())) - Long.parseLong(words[0].substring(splitted[0].length()));
				
				}
				System.out.println(result);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}				

 }		

