import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
class StackOperation
 {
	 public static void main(String[] args)
	 {
		 try
		 {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));      
			String line;
			while ((line = br.readLine()) != null)
			{
				if(line.isEmpty() == true)
				{
					System.out.println("line is empty");
				}
				else
				{	
					line = line.trim();
					String splitted_data[] =line.split("\\s");
					Stack<Integer> st = new Stack<>();
					for(int i=0;i<splitted_data.length;i++)
					{
						int number = Integer.parseInt(splitted_data[i]);
						st.push(number);
					}
					int c = 0;
					StringBuilder answer = new StringBuilder();
					while(!st.isEmpty())
					{
						int number = st.pop();
						if(c ==  0)
							answer.append(number+" ");
						c ^= 1;
					
					}
					System.out.println(answer);
				}
			}
		}
		catch(IOException e)
		{
			System.out.println("file not found");
		}
		catch(Exception f)
		{
			f.printStackTrace();
		}	
	}

}
