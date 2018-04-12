import java.io.*;
class DistinctSubsequence 
{ 
	public static int getSubSeq(String word1, String word2, int i, int j)
	{
		int matches = 0;
		if( j == word2.length())
		{
			return 1;
		}
		for(; i < word1.length(); i++)
		{
			if(word1.charAt(i) == word2.charAt(j))
			{
				matches += getSubSeq(word1, word2, i + 1, j + 1);
			}
		}
		return matches;
	}		
				
	public static void main(String args[])
	{
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			String[] splittedData;
			while((line = br.readLine()) != null)
			{
				line = line.trim();
				if( line.isEmpty() == true)
				{
					System.out.println("the line is empty");
				}
				else
				{	
					splittedData = line.split(",");
					String data1 = splittedData[0].trim();
					String data2 = splittedData[1].trim();
					int i = 0;
					int j = 0;
					System.out.println(getSubSeq(data1, data2, i ,j));
				}
			}
		}	
		catch(IOException e)
		{
			System.out.println("file not found");
		}
	}	
    
}
