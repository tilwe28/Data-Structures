//Anurag Tilwe
import java.util.*;
import java.io.*;
public class AirlineIncidents
{

	private Map<Airline, IncidentData> map;
	private Scanner in;

	public static void main(String[]args)
	{
		AirlineIncidents ai = new AirlineIncidents("AirlineCrashData.csv");
	}

	public AirlineIncidents(String file)
	{
		map = new HashMap<Airline, IncidentData>();
		in = new Scanner(System.in);
		loadData(file);
		printAll();
		String input = "";
		while (!input.equalsIgnoreCase("x"))
		{
			System.out.print("Enter an Airline: ");
			input = in.nextLine();
			if (input.equalsIgnoreCase("x")) break;
			if (getByName(input) == null) System.out.println("Airline not found.");
			else {
				System.out.println(getByName(input));
				System.out.println(getIncidentsBySize(getByName(input)));
			}
			System.out.println();
		}
	}

	public void loadData(String file)
	{
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text="";
			input.readLine();//heading
			while ((text=input.readLine())!=null)
			{
				String[] data = text.split(",");
				map.put(new Airline(data[0].replace("*", ""), Long.parseLong(data[1])), new IncidentData(Integer.parseInt(data[2]), Integer.parseInt(data[3]), Integer.parseInt(data[4]), Integer.parseInt(data[5]), Integer.parseInt(data[6]), Integer.parseInt(data[7])));
			}
		} catch (IOException io) {
			System.err.println("File does not exist.");
		}
	}

	public void printAll()
	{
		for (Map.Entry<Airline, IncidentData> entry : map.entrySet())
			System.out.println(entry.getKey() + ":\n" + entry.getValue() + "\n");
	}

	public Airline getByName(String name)
	{
		for (Airline a : map.keySet())
			if (a.getName().equals(name))
				return a;
		return null;
	}

	public double getIncidentsBySize(Airline a)
	{
		System.out.println(map.get(a));
		return (double)(map.get(a).getIncidents_85_99()+map.get(a).getIncidents_00_14())/(double)(a.getSize());
	}
}