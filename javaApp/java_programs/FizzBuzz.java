import java.io.*;
public class FizzBuzz 
{
	public static void main (String[] args) throws IOException
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			String[] test_case;
			while((line = br.readLine())!= null)
			{
				if(line.isEmpty()==null)
				{
					System.out.println("the line is empty");
				}
				else
				{	
					test_case = line.split(" ");
					int count = Integer.parseInt(test_case[2]);
					int variable_a = Integer.parseInt(test_case[0]);
					int variable_b = Integer.parseInt(test_case[1]);
			
					for(int index = 1; i <= count; i++)
					{	
						if( (index % (variable_a * variable_b) ) == 0)
							System.out.print( "FB" );
						else if( (index % variable_a) == 0)
							System.out.print( "F" );
						else if( (index % variable_b) == 0)
							System.out.print( "B" );
						else 
							System.out.print( index );
						System.out.print(" ");	
					}
					System.out.println();
				}
			}	
		}
		catch ( Exception e)
		{
			e.printStackTrace();
		}	
	}
}				

