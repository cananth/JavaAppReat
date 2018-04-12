import java.io.*;
public class CrackEggs
{
	public static void main(String args[])
	{
		try
		{
			CrackEggs crack = new CrackEggs();
			BufferedReader in = new BufferedReader(new FileReader(args[0]));
			String line, data[], number[];
			int result = 0, eggs, floors, dropsCount;
			while((line=in.readLine()) != null)
			{ 
				number = line.split(" ");
				if(number.length == 2)
				{
					eggs = Integer.parseInt(number[0]);
					floors = Integer.parseInt(number[1]);
					System.out.println(crack.cracking_eggs(eggs, floors));
				}
				else
					System.out.println("Give correct data");
			}
		}
		catch(Exception e)
		{
			System.out.println("Wrong file name or data");
		}
	}
	public int maximum_floors(int eggs, int dropCount)
	{
		int result;
		if(eggs == 0)
			return 0;
		else
		{
			result = 0; 
			for (int index = 0; index < dropCount ; index++)
			{
				result += maximum_floors(eggs - 1, index) + 1;
			}
			return result;
		}
	}
	public int cracking_eggs (int eggs,int floors)
	{
		int count = 1;
		while (maximum_floors(eggs, count) < floors)
		{
			count += 1;
		}
		return count;
	}
}
