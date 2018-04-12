import java.io.*;
class LongestWord 
{
	public static void main (String[] args)throws IOException
	{
		try
		{	
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			String[] splitted;
			while((line = br.readLine())!= null)
			{
				splitted = line.split(" ");
				for(int index = 0; index<splitted.length; index++)
				{
					for (int j = 0; j<splitted.length-1; j++)
					if(splitted[index].length() > splitted[j].length())
					{
						String temp = splitted[index];
						splitted[index] = splitted[j];
						splitted[j] = temp;
					} 
				
				}
				
				System.out.println(splitted[0]);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	
	}
}

