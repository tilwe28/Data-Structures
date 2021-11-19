public class Municipality
{
	private String name, county, type;

	public Municipality(String name, String county, String type)
	{
		this.name = name;
		this.county = county;
		this.type = type;
	}

	public String getName() { return name; }
	public String getCounty() { return county; }
	public String getType() { return type; }

	public String toString()
	{
		return name + "\t\t\t\t" + county + "\t\t\t\t" + type;
	}
}