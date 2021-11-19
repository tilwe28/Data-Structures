import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
public class Birthday
{
	private String fName, lName;
	private Calendar birthdate;

	private String[] dayString = new String[] { "","Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };

	public Birthday(String fName, String lName, Calendar birthdate)
	{
		this.fName = fName;
		this.lName = lName;
		this.birthdate = birthdate;
	}

	public String toString()
	{
		String tab = "\t\t\t", tab2 = "\t\t";
		if ((fName + " " + lName).length() >= 16) tab = "\t\t";
		if (dayString[birthdate.get(Calendar.DAY_OF_WEEK)].length() >=8) tab2= "\t";
		return fName + " " + lName + tab + dayString[birthdate.get(Calendar.DAY_OF_WEEK)] + tab2 + TimeUnit.MILLISECONDS.toDays(Calendar.getInstance().getTimeInMillis() - birthdate.getTimeInMillis());
	}

}