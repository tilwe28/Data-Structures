import java.util.*;

public class OlympicTeamComments implements Comparable<OlympicTeam>{
	private String country;
	private int numGold;
	private int numSilver;
	private int numBronze;

	public OlympicTeam(String countryName, int gold, int silver, int bronze){
		country = countryName;
		numGold = gold;
		numSilver = silver;
		numBronze = bronze;
	}//constructor

	public String getCountry() { return country; }

	public int getNumGold() { return numGold; }

	public int getNumSilver() { return numSilver; }

	public int getNumBronze() { return numBronze; }

	public String toString(){
		return country + " => G = "+numGold+", S = "+numSilver+", B = "+numBronze;
	}

  public boolean equals(OlympicTeam other){
      if (this.getCountry() == other.getCountry())
        if (this.getNumGold() == other.getNumGold())
            if (this.getNumSilver() == other.getNumSilver())
              if (this.getNumBronze() == other.getNumBronze())
                return true;

        return false;
  }//checks if OlympicTeam object is equal to another OlympicTeam object

  public int getTotalMedals(){
    int sum = 0;
    if (numGold > 0 )
      sum += numGold;
    if (numSilver > 0)
      sum += numSilver;
    if (numBronze > 0)
      sum += numBronze;
    return sum;
  }//returns sum of the 3 medal counts

  public int sumLeastTwo(){
    int sum = 0;

    if (numGold > numBronze && numGold > numSilver)//when gold is largest, returns silver+bronze
      return numBronze + numSilver;
    if (numSilver > numBronze && numSilver > numGold)//when silver is largest, returns gold+bronze
      return numBronze + numGold;
    // if (numSilver > sumBronze && numSilver > numGold)

    //checks is 2 medals have same count, so returns 2 times whatever lowest count medal is
    if (numSilver == numGold)
      if (numSilver < numBronze)
          return 2 * numSilver;
      else
          return numSilver + numBronze;

    if (numSilver == numBronze)
      if (numSilver < numGold)
          return 2 * numSilver;
      else
          return numSilver + numGold;

	if (numGold == numBronze)
		if (numGold < numSilver)
			return 2*numGold;
    return numGold + numSilver;//when bronze is largest, returns gold+silver
  }//returns sum of 2 lowest medal counts




  public int compareTo(OlympicTeam other){
    return this.getNumGold() - other.getNumGold();
  }//returns gold count difference

  public static void main(String[]args){
	  OlympicTeam t1 = new OlympicTeam("team 1",2,2,1);
	  System.out.println(t1.sumLeastTwo());
  }//main



}