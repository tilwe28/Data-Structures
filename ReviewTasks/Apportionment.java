//Anurag Tilwe
import java.util.*;
import java.lang.*;
import java.io.*;
public class Apportionment
{

	public static void main(String[]args)
	{

		ArrayList<States> states = new ArrayList<States>();

		try
		{

			BufferedReader input = new BufferedReader(new FileReader("CensusApportionment.txt"));
			input.readLine();//heading
			String text;
			while ((text=input.readLine()) != null)
			{
				String[] a = text.split(" ");
				if (a[0].equals("New") || a[0].equals("North") || a[0].equals("South") || a[0].equals("West") || a[0].equals("Rhode"))
				{
					a[0] += a[1];
					a[1] = a[2];
					a[2] = a[3];
				}
				states.add(new States(a[0], Integer.parseInt(a[1].replaceAll(",", "")), Integer.parseInt(a[2])));
			}

		}
		catch (IOException io)
		{
			System.out.println("File does not exist");
		}

		for (int i = 0; i < states.size(); i++)
			System.out.println(states.get(i).toString());

		System.out.println();

		States greatest = getGreatest(states);
		States lowest = getLowest(states);
		System.out.println("A congressman from " + greatest.getName() + " represents " + greatest.getPopulation()/greatest.getNumDistricts() + " people, while a congressman from " + lowest.getName() + " only represents " + lowest.getPopulation()/lowest.getNumDistricts() + " people!");
	}

	public static States getGreatest(ArrayList<States> states)
	{
		States greatest = states.get(0);

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < states.size(); i++)
		{
			int ratio = states.get(i).getPopulation()/states.get(i).getNumDistricts();
			if (ratio > max)
			{
				max = ratio;
				greatest = states.get(i);
			}
		}

		return greatest;
	}

	public static States getLowest(ArrayList<States> states)
	{
		States lowest = states.get(0);

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < states.size(); i++)
		{
			int ratio = states.get(i).getPopulation()/states.get(i).getNumDistricts();
			if (ratio < min)
			{
				min = ratio;
				lowest = states.get(i);
			}
		}

		return lowest;
	}
}