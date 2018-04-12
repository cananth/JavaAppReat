import java.io.*;
class Halloween 
{
	public static void main (String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		String line;
		String[] halloween = null;
		int vampires = 0, zombies = 0, witches = 0, houses = 0, candies = 0;
		while((line = br.readLine()) != null)
		{
			halloween = line.split(",");
			vampires = Integer.parseInt((halloween[0].split(":")[1]).trim());
			zombies = Integer.parseInt((halloween[1].split(":")[1]).trim());
			witches = Integer.parseInt((halloween[2].split(":")[1]).trim());
			houses = Integer.parseInt((halloween[3].split(":")[1]).trim());
			if ((vampires > 0 && vampires < 100) && (zombies > 0 && zombies < 100) && (witches > 0 && witches < 100))
			{
				 candies = ((( vampires * 3 ) + ( zombies * 4 ) + ( witches * 5 )) * houses) / (vampires + zombies + witches);
				System.out.println(candies);
			}
			else
			{
				System.out.println("plz give in the specified range");
			}		
		}
	}
}


