//Anurag Tilwe
import java.io.*;
import java.lang.*;
import java.util.*;
public class Olympics
{

	private ArrayList<OlympicTeam> teams;

	public Olympics(String name)
	{

		teams = new ArrayList<OlympicTeam>();

		try
		{

			BufferedReader input = new BufferedReader(new FileReader(name));
			input.readLine();//heading
			String text;
			while ((text=input.readLine()) != null)
			{
				if (text.length() > 0)
				{
					String[] a = text.split(",");
					teams.add(new OlympicTeam(a[0], Integer.parseInt(a[1]), Integer.parseInt(a[2]), Integer.parseInt(a[3])));
				}
			}

		}
		catch (IOException io)
		{
			System.out.println("File does not exist");
		}

	}//constructor

	public String toString()
	{
		String str = "";
		for (OlympicTeam ot: teams)
			str += ot + "\n";
		return str;
	}

	public static void main(String[]args)
	{
		Olympics tokyo2020 = new Olympics("olympic-medals.csv");
		System.out.println(tokyo2020.toString());

	}//main

}//Olympics