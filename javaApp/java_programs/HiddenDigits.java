import java.io.*;
import java.util.*; 
 class HiddenDigits
  {
    public static void main(String[] args) throws Exception 
    {
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		while((line = br.readLine()) != null)
		 {
			 String result = "";
				for (int i = 0; i < line.length(); i++) 
				{
					char character = line.charAt(i); 
				if (character >= 'a' && character <= 'j') {
					result += character - 'a'; 
				} else if (character >= '0' && character <= '9') {
					result += character; 
				}
			}
			
			if (result.equals("")) {
				System.out.println("NONE");
			} else {
				System.out.println(result);
			}
		}
    }
}
