import java.io.*;

public class ReverseGroup 
{
    public static void main(String[] args) 
    {
       try {
			BufferedReader br = new BufferedReader(new FileReader(args[0]));
			String line;
			while ((line = br.readLine()) != null)
			{
					System.out.println(reversed(line));
            }
        } 
        catch (IOException e) 
        {
            System.out.println("Could not find file.");
        }
        catch(Exception e)
        {
			System.out.println("the line is empty");
		}
        
    }

    private static String reversed(String line)
     {
        String[] splitted_data = line.split(";");
        int k = Integer.parseInt(splitted_data[1]);
        if (k == 0) 
        {
            return splitted_data[0];
        }
        return reversedByK(splitted_data[0].split(","), k);
    }

    private static String reversedByK(String[] nums, int k) 
    {
        StringBuilder result = new StringBuilder();
        for (int i = k - 1; i < nums.length; i += k)
         {
            for (int j = i; i - j <= k - 1; j--) 
            {
                result.append(',').append(nums[j]);
            }
        }

        for (int i = nums.length - nums.length % k; i < nums.length -1; i++) 
        {
            result.append(',').append(nums[i]);
        }
        return result.substring(1);
    }
}
