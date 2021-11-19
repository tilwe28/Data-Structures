//Anurag Tilwe
public class OlympicTeam
{
	private String nameCountry;
	private int numGold;
	private int numSilver;
	private int numBronze;

	public OlympicTeam(String nameCountry, int numGold, int numSilver, int numBronze)
	{
		this.nameCountry = nameCountry;
		this.numGold = numGold;
		this.numSilver = numSilver;
		this.numBronze = numBronze;
	}

	public String getCountry()
	{
		return nameCountry;
	}

	public int getNumGold()
	{
		return numGold;
	}

	public int getNumSilver()
	{
		return numSilver;
	}

	public int getNumBronze()
	{
		return numBronze;
	}

	public String toString()
	{
		return nameCountry + " => G = " + numGold + ", S = " + numSilver + ", B = " + numBronze;
	}

	public static void main(String[]args)
	{
		OlympicTeam ot = new OlympicTeam("South Brunswick", 5, 3, 2);
		System.out.println(ot.toString());
	}
}