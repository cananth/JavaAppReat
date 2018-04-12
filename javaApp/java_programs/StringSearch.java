import java.io.*;
import java.util.regex.*;
class StringSearch {
	public static void main (String[] args)throws I0Exception {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		String[] word;
		while((line = br.readLine()) != null)
		{
			if (line.isEmpty() == true)
				System.out.println("there is no data in that line");
			else 
			{	
				line = line.trim();
				try
				{
					word = line.split(",");
				
					String word1 = word[0];
					String word2 = word[1];
					if (word2.contains("*"))
					{
						Pattern p = Pattern.compile(word2);
						Matcher m = p.matcher(word1);
						System.out.println(m.find());
					}
					else if ( word1.toLowerCase().contains(word2.toLowerCase()))
						System.out.println("true");
					else
						System.out.println("False");
				}
				catch(Exception e){
					System.out.println("plz give the valid input");
				}
			}
		}
				
	}
}

