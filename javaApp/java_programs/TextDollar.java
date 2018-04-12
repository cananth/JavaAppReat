import java.io.*;
class TextDollar
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		int number = 0;
		String[] ones = {"","one","two","three","four","five","six","seven","Eight","nine","ten","eleven","twelve","thirteen","forteen","fifteen","sixteen","seventeen","eighteen","ninteen"};
		String[] tens = {"","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninty"};
		while((line = br.readLine()) != null) 
		{
			line = line.trim();
			if(line.isEmpty	() == true)
			{
				System.out.println("line is empty ");
			}
			else
			{
				 number = Integer.parseInt(line);
				 if(number < 10)
				 {
					 System.out.println(ones[(number % 10)]);
				 }
				else if(number > 10 && number < 20)
				{
					System.out.println(ones[(number % 10) + 10]);
				} 
			}
		}		
	}
}

