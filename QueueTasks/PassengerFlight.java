//Anurag Tilwe
import java.util.*;
import java.io.*;
public class PassengerFlight
{
	public static void main(String[]args)
	{
		Queue<Passenger> q = new LinkedList<Passenger>();
		Queue<Passenger> pq = new PriorityQueue<Passenger>();

		try {

			BufferedReader input = new BufferedReader(new FileReader("PassengerInfo.txt"));
			String text;
			while ((text=input.readLine()) != null)
			{
				q.add(new Passenger(text.split(" ")[1], text.split(" ")[0], input.readLine(), input.readLine()));
				pq.add(new Passenger(text.split(" ")[1], text.split(" ")[0], input.readLine(), input.readLine()));
			}
		} catch (IOException io) {
			System.err.println("File does not exist");
		}

		while (!(q.isEmpty()))
			System.out.println(q.poll());

		System.out.println("\n\n\n");

		while (!(pq.isEmpty()))
			System.out.println(pq.poll());
	}
}

class Passenger implements Comparable<Passenger>
{

	private String lastName, firstName, city, time;
	private Integer compareNum;

	public Passenger(String lastName, String firstName, String city, String time)
	{
		this.lastName = lastName;
		this.firstName = firstName;
		this.city = city;
		this.time = time;
		compareNum = getTimeValue();
	}

	public String getLastName() { return lastName; }
	public String getFirstName() { return firstName; }
	public String flightCity() { return city; }
	public String flightTime() { return time; }

	public String etdCalc()
	{
		//current time - 9:03 AM
		String militaryTime = "";
		if (time.contains("PM"))
		{
			if (Integer.parseInt(time.split(":")[0]) == 12)
				militaryTime = (time.split(":")[0] + ":" + time.split(":")[1].substring(0, 2));
			else militaryTime = ((Integer.parseInt(time.split(":")[0])+12) + ":" + time.split(":")[1].substring(0, 2));
		} else militaryTime = time.substring(0, 5).trim();

		if (Integer.parseInt(militaryTime.split(":")[1]) < 3)
		{
			return (Integer.parseInt(militaryTime.split(":")[0])-9-1) + " hrs & " + (60+Integer.parseInt(militaryTime.split(":")[1])-3) + " mins";
		} else return (Integer.parseInt(militaryTime.split(":")[0])-9) + " hrs & " + (Integer.parseInt(militaryTime.split(":")[1])-3) + " mins";
	}

	@Override
	public int compareTo(Passenger other)
	{
		/*if (getTimeValue()<other.getTimeValue())
			return -1;
		else if (getTimeValue()>other.getTimeValue())
			return 1;
		else return 0;*/

		int comparison = this.compareNum.compareTo(other.compareNum);
		if (comparison != 0)
			return comparison;

		return this.lastName.compareTo(other.lastName);
	}

	public Integer getTimeValue()
	{
		return Integer.parseInt(etdCalc().substring(0, etdCalc().indexOf(" ")) + etdCalc().substring(etdCalc().indexOf("&")+2, etdCalc().lastIndexOf(" ")));
	}

	public String toString()
	{
		return lastName + ", " + firstName + " - " + city + " - " + time + " - " + etdCalc();
	}
}