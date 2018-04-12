import java.io.*;
import java.util.regex.*;
public class EmailValidation 
{
 public static void main (String[] args) throws IOException
  {
	  try
	  {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String email;
			String regex = "^[\\w+_.-]+@(.+)$"; 
			while((email = br.readLine()) != null)
			{
				if(email.length() != 0)
				{
					Pattern p = Pattern.compile(regex);
					Matcher m = p.matcher(email);
					System.out.println(m.find());
				}
				else
				{
					System.out.println("empty");
				}	
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}				
			
	}
}

