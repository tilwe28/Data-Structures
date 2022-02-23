//Anurag Tilwe
public class Airline
{
	private String name;
	private long size;

	public Airline(String name, long size)
	{
		this.name = name;
		this.size = size;
	}

	public String getName() { return name; }
	public long getSize() { return size; }

	public void setName(String newName) { name = newName; }
	public void setSize(long newSize) { size = newSize; }

	public String toString() { return name+" ("+size+")"; }
}