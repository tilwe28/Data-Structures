import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.*;
import java.io.*;

public class DateHelper
{
	public static void main(String[]args)
	{

		ArrayList<Birthday> bdays = new ArrayList<Birthday>();

		try
		{
			BufferedReader input = new BufferedReader(new FileReader("DSBirthdays.csv"));
			String text;
			input.readLine();//skipping title of csv file
			while((text=input.readLine())!= null)
			{
				String[] a = text.split(",");
				Calendar date = Calendar.getInstance();
				date.set(Integer.parseInt(a[2].split("/")[2]), Integer.parseInt(a[2].split("/")[0]), Integer.parseInt(a[2].split("/")[1]));
				bdays.add(new Birthday(a[1], a[0], date));
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}

		System.out.println("Name\t\t\t\tBorn on Day\tDaysAlive");
		for (int i=0; i<bdays.size(); i++)
			System.out.println(bdays.get(i));
	}
}