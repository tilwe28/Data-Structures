//Anurag Tilwe
import java.util.*;
import java.io.*;
public class DrugDeaths
{

	private Map<String, DrugUse> drugsMap;
	private Map<String, YearlyDeaths> deathsMap;

	public static void main(String[]args)
	{
		DrugDeaths dd = new DrugDeaths("drug-use-by-age.csv", "number-of-deaths-by-age-group.csv");
	}

	public DrugDeaths(String drugsFile, String deathsFile)
	{
		drugsMap = new HashMap<String, DrugUse>();
		deathsMap = new HashMap<String, YearlyDeaths>();
		loadData(drugsFile, deathsFile);
		printAll();
	}

	public void loadData(String drugsFile, String deathsFile)
	{
		try {
			BufferedReader drugsInput = new BufferedReader(new FileReader(drugsFile));
			BufferedReader deathsInput = new BufferedReader(new FileReader(deathsFile));
			drugsInput.readLine(); deathsInput.readLine();//Headings
			String drugsText, deathsText;
			while ((drugsText=drugsInput.readLine()) != null && (deathsText=deathsInput.readLine()) != null)
			{
				String[] drugsData = drugsText.split(","), deathsData = deathsText.split(",");
				double[] drugNumbers = new double[drugsData.length-1], deathNumbers = new double[deathsData.length-1];
				for (int i=0; i<drugNumbers.length; i++)
					drugNumbers[i] = Double.parseDouble(drugsData[i+1]);
				drugsMap.put(drugsData[0], new DrugUse(drugNumbers[0], drugNumbers[1], drugNumbers[2], drugNumbers[3], drugNumbers[4], drugNumbers[5], drugNumbers[6], drugNumbers[7], drugNumbers[8], drugNumbers[9], drugNumbers[10], drugNumbers[11], drugNumbers[12], drugNumbers[13], drugNumbers[14], drugNumbers[15], drugNumbers[16], drugNumbers[17], drugNumbers[18], drugNumbers[19], drugNumbers[20], drugNumbers[21], drugNumbers[22], drugNumbers[23], drugNumbers[24], drugNumbers[25]));
				for (int i=0; i<deathNumbers.length; i++)
					deathNumbers[i] = Double.parseDouble(deathsData[i+1]);
				deathsMap.put(deathsData[0], new YearlyDeaths(deathNumbers[0], deathNumbers[1], deathNumbers[2], deathNumbers[3], deathNumbers[4], deathNumbers[5], deathNumbers[6], deathNumbers[7], deathNumbers[8], deathNumbers[9], deathNumbers[10]));
			}
		} catch (IOException io) {
			System.err.println("The file or files do not exist.");
		}
	}

	public void printAll()
	{
		Iterator<Map.Entry<String, DrugUse>> drugIt = drugsMap.entrySet().iterator();
		Iterator<Map.Entry<String, YearlyDeaths>> deathsIt = deathsMap.entrySet().iterator();
		while (drugIt.hasNext() && deathsIt.hasNext())
		{
			Map.Entry<String, DrugUse> drugSet = drugIt.next();
			Map.Entry<String, YearlyDeaths> deathsSet = deathsIt.next();
			System.out.println(deathsSet.getKey() + ":\n" + deathsSet.getValue() + "\n" + drugSet.getValue() + "\n");
		}
	}
}