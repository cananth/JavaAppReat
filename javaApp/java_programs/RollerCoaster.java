import java.io.*;
class RollerCoaster
{
	public static void main(String args[])throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			String[] characters;
			int count = 0;
			while ((line = br.readLine()) != null)
			{
				line = line.trim();
				characters = line.split("");
				String result = " ";
				for (int intitial_index = 0; intitial_index < characters.length ; intitial_index++)
				{
					for (int sub_index= 0; sub_index < characters[intitial_index].length(); sub_index++)
					{
						if (Character.isLetter(characters[intitial_index].charAt(sub_index))) 
						{
							if (count == 0)
							{
								result += Character.toUpperCase(characters[intitial_index].charAt(sub_index));
								count = 1;
							}
							else
							{
								result += Character.toLowerCase( characters[intitial_index].charAt(sub_index));
								count = 0;
							}	
						}
						else
						{
							result += characters[intitial_index].charAt(sub_index);
						}
							
					}
					
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
