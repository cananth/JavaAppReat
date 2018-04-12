import java.io.*;
class PrimeNumber 
{
	public static void main (String[] args)
	 {
		 try
		 {
			 
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String data;
			String[] splitted_data ;
			int count,  result = 0;
			while((data = br.readLine()) != null)
			{
				data = data.trim();
				splitted_data = data.split(" ");
				String[] prime_number;
				String prime_numbers = "";
				for(int index = Integer.parseInt(splitted_data[0]),i = 0; index <= Integer.parseInt(splitted_data[1]); index++,i++)
				{
					 count = 0;
					 for(int j = 1; j <= index ; j++)
					 {
						 if(index % j == 0)
							 count = count + 1;
					}
					if(count == 2)
					{
						prime_numbers = prime_numbers + index +"\n"  ;
					}	
				}
				
				prime_number = prime_numbers.split("\n");
					
					for(int index = 0 ; index < prime_number.length; index++)
					{
						for (int j = 0; j < prime_number.length - 1 ; j++)
						
						{
							if(((Integer.parseInt(prime_number[j]) + Integer.parseInt(prime_number[j + 1])) + 1) == Integer.parseInt(prime_number[index]))
							{
								result += 1;
							}
											

						}	
					
			      }
			      
			       System.out.println(result);
			       result = 0;
			}
		}
		catch(IOException e)
		{	
			System.out.println("file not found");
		}
	
	}

}
