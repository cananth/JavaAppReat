import java.io.*;
class StringRotation 
{
	public static void main (String[] args)
	 {
		 try
		 {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			String[] splittedLine;
			int flag = 0;
			while((line = br.readLine()) != null)
			{
				if(line.isEmpty() == true)
				{
					System.out.println("the line is empty");
				}
				else
				{
						splittedLine = line.split(",");
						char[] firstWord = splittedLine[0].toCharArray();
						char[] secondWord = splittedLine[1].toCharArray();
						if(firstWord.length != secondWord.length)
						{
							System.out.println("false");
						}
						else
						{	
							for(int index = 0,j = 0; index < firstWord.length; j++,index++)
							{
							for(int j = 0; j < secondWord.length(); j++)
								{
								if(firstWord[index] == (secondWord[j]))
									flag = 1;
								else
								 flag = 0;
							}
							}
						}
						if (flag == 0)
							System.out.println("true");
						else
							System.out.println("false");
							
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("enter the correct file name");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}						
	}
}

