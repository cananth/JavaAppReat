import java.io.*;
class Panagrams 
{
    public static void main(String[] args) 
    {
		try
		{
			
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			while((line = br.readLine()) != null)
			{ 
				if( line.isEmpty() == true)
				  System.out.println("the line is empty");
				else
				{  
					line = line.toLowerCase();
					String result = "";
					String[] alphabets = { "a", "b", "c", "d", "e", "f", "g",
									"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
									"u", "v", "w", "x", "y", "z" };     
				 
					for(int i = 0; i < alphabets.length; i++) 
					{
						if(!line.contains(alphabets[i]))
						{
							result += alphabets[i];
						}
					}
					if (result.equals(""))
						System.out.println("NULL");
					else
						System.out.println(result);
				}
			}
		}	
		catch(IOException e)
		{
			System.out.println("plz check the file ");
		}	
		catch(Exception f)
		{
			f.printStackTrace();
		}	
	}	
}
