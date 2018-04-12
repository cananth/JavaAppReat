import java.io.*;
class CompressedSequence 
{
	public static void main (String[] args) throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line,data[];
			int count;
			while((line = br.readLine()) != null)
			{
				if (line.isEmpty() == true)
					System.out.println("there is no input");
				else
				{  
					line = line.trim();
					data = line.split(" ");	
					count = 1;
					int index;
					if(data.length <= 400)
					{
						for ( index = 0; i < data.length - 1; index++)
						{	
							if(data[index].equals(data[index + 1]))
							count ++;
							else
							{ 
								System.out.print(count + " - " + data[index] + " " );
								count = 1 ;
							} 	
						}
						System.out.print(count + " - " + data[index]);
						System.out.println();
					}
					else
					{
						System.out.println("please give the input in desired length of 1 to 400");
					}
				}
			}
		}
		catch( Exception e)
		{
			e,printStackTrace();
		}	
	}
}

