//Anurag Tilwe
public class States
{
	private String name;
	private int population;
	private int numDistricts;

	public States (String name, int population, int numDistricts)
	{
		this.name = name;
		this.population = population;
		this.numDistricts = numDistricts;
	}

	public String getName()
	{
		return name;
	}

	public int getPopulation()
	{
		return population;
	}

	public int getNumDistricts()
	{
		return numDistricts;
	}

	public String toString()
	{
		return name + " -> " + population/numDistricts;
	}
}