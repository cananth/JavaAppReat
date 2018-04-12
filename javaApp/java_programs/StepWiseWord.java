import java.io.*;
class StepWiseWord 
{
	public static void main (String[] args) throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			String[] splitted;
			while((line = br.readLine())!=null)
			{
				if(line.isEm
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
					String[] step_wise=splitted[0].split("");
					for(int i=0;i<=step_wise.length-1;i++)
					{
					
						System.out.print(step_wise[i]);
						System.out.print(" ");
						for(int j=1;j<=i;j++)
							{
								System.out.print("*");
							}	
					
					}
					System.out.println();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}	


}
