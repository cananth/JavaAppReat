import java.io.*;
class SumOfDigits 
{
	public static void main(String[] args) throws IOException 
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line ;
			int remainder=0 , sum=0;
			int number;
			
			while((line=br.readLine())!=null)
			{
				number=Integer.parseInt(line);
				while (number > 0)
				{
					remainder=number%10;
					sum=sum+remainder;
					number=number/10;
				}
			System.out.println(sum)	;
			}
				
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
		

}
