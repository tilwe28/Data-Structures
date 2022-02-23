//incidents_85_99,fatal_accidents_85_99,fatalities_85_99,incidents_00_14,fatal_accidents_00_14,fatalities_00_14

public class IncidentData{

	private int incidents_85_99;
	private int fatal_accidents_85_99;
	private int fatalities_85_99;
	private int incidents_00_14;
	private int fatal_accidents_00_14;
	private int fatalities_00_14;


	public IncidentData(int i85_99, int fa85_99, int f85_99, int i00_14, int fa00_14, int f00_14){
		incidents_85_99 = i85_99;
		fatal_accidents_85_99 = fa85_99;
		fatalities_85_99 = f85_99;
		incidents_00_14 = i00_14;
		fatal_accidents_00_14 = fa00_14;
		fatalities_00_14 = f00_14;
	}

	public int getIncidents_85_99 (){ return incidents_85_99; }
	public int getFatal_accidents_85_99 (){ return fatal_accidents_85_99; }
	public int getFatalities_85_99 (){ return fatalities_85_99; }
	public int getIncidents_00_14 (){ return incidents_00_14; }
	public int getFatal_accidents_00_14 (){ return fatal_accidents_00_14; }
	public int getFatalities_00_14 (){ return fatalities_00_14; }
  
  public String toString() {
     return "85-99: "+incidents_85_99+" incidents, "+fatal_accidents_85_99+" fatal accidents "+fatalities_85_99+" fatalities\n00-14: "+incidents_00_14+" incidents, "+fatal_accidents_00_14+" fatal accidents, "+fatalities_00_14+" fatalities";
  }

}