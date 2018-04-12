import java.io.*;
public class SwapCase 
{
	public static void main (String[] args) throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			String result="";
			while((line = br.readLine()) != null)
			{ 
				if (line.isEmpty() == true)
					System.out.println("please enter the line in a string format");
				else
				{	 
					for(int index = 0 ; index<line.length(); index++)
					{
						if(Character.isUpperCase(line.charAt(index)))
						{
							char currentToLowerCase = Character.toLowerCase(line.charAt(index));
							result += currentToLowerCase;		
						}
						else if(Character.isLowerCase(line.charAt(index)))
						{
							char currentToUpperCase = Character.toUpperCase(line.charAt(index));
							result += currentToUpperCase;
						}
						else
						{
							result = result + line.charAt(index);
						}
						System.out.print(result);
						result = "" ;
					}
					
					System.out.println();
				}
			}	
		catch ( Exception e)
		{
			e.printStackTrace();
		}	
	}
}
