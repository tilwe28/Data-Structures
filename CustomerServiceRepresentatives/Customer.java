//Anurag Tilwe
public class Customer implements Comparable<Customer>
{
	private static int idGen = 0;
	private int id;
	private boolean priority;
	private long callStart, holdTime;

	public Customer(boolean priority)
	{
		this.priority = priority;
		id = idGen++;
		callStart = System.currentTimeMillis();
	}

	public int getID() { return id; }
	public boolean getPriority() { return priority; }
	public long getCallStart() { return callStart; }
	public long getHoldTime() { return holdTime; }

	public void setHoldTime()
	{
		holdTime = System.currentTimeMillis() - callStart;
	}

	public int compareTo(Customer other)
	{
		if (priority && !other.priority) return -1;
		if (!priority && other.priority) return 1;
		if (callStart < other.callStart) return -1;
		return 1;
	}

	public String toString()
	{
		return id + ", priority = " + priority;
	}
}