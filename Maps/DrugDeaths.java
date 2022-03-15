//Anurag Tilwe
import java.util.*;
import java.io.*;
public class DrugDeaths
{

	private Map<String, DrugUse> drugsMap;
	private Map<String, YearlyDeaths> deathsMap;
	private Scanner in;

	public static void main(String[]args)
	{
		DrugDeaths dd = new DrugDeaths("drug-use-by-age.csv", "number-of-deaths-by-age-group.csv");
	}

	public DrugDeaths(String drugsFile, String deathsFile)
	{
		in = new Scanner(System.in);
		drugsMap = new HashMap<String, DrugUse>();
		deathsMap = new HashMap<String, YearlyDeaths>();
		loadData(drugsFile, deathsFile);
		//printAll();

		System.out.println("STATEMENT OF TOPIC:\nThe relationship between drug use and deaths by age group\n");
		System.out.println("STATEMENT OF HYPOTHESIS:\nAge groups with higher drug use rates will have a greater amount of deaths\n");
		System.out.println("POTENTIAL ISSUES:\n\t1. The original data sets did not have the exact same age group ranges, so I\n\t   had to take the average of sum numbers to make the data sets more comparable.");
		System.out.println("\t2. There are multiple causes of deaths, for example the older age group might\n\t   have more deaths due to disease and old age, while the baby age group might\n\t   have more deaths due to misfortune and other newborn related diseases.");
		System.out.println("\t3. There could have been some type of error while the people retrieved data\n\t   where the answerer could have lied or given an inaccurate number.\n\n");

		System.out.println("DATA ANALYSIS:");
		while (true)
		{
			System.out.print("Enter an input to analyze different things (1 for drug data, 2 for deaths data, 3 to print all data, 4 to cross analyze drugs and deaths data, x to exit): ");
			String input = in.nextLine(), input2, input3, input4;
			System.out.println();
			if (input.equalsIgnoreCase("x")) break;
			else if (input.equals("3"))
				printAll();
			else if (input.equals("1"))
			{
				while (true)
				{
					System.out.print("Enter an input to get different drug statistics (a to search by age group, b for age group with highest drug use, c to compare two different age groups, x to go back): ");
					input2 = in.nextLine();
					System.out.println();
					if (input2.equalsIgnoreCase("x")) break;
					else if (input2.equalsIgnoreCase("a"))
					{
						System.out.print("Enter an age group (12-16, 17-21, 22-30, 31-64, 65+): ");
						input3 = in.nextLine();
						System.out.println(getDrugData(input3));
					}
					else if (input2.equalsIgnoreCase("b"))
						System.out.println(getHighestDrugUse());
					else if (input2.equalsIgnoreCase("c"))
					{
						System.out.println("(12-16, 17-21, 22-30, 31-64, 65+)");
						System.out.print("Enter the first age group to compare: ");
						input3 = in.nextLine();
						System.out.print("Enter the second age group to compare: ");
						input4 = in.nextLine();
						System.out.println();
						compareDrugUse(input3, input4);
					}
					System.out.println("\n");
				}
			}
			else if (input.equals("2"))
			{
				while (true)
				{
					System.out.print("Enter an input to get different death statistics (a to search by age group, b for age group with highest deaths, c to compare two different age groups, x to go back): ");
					input2 = in.nextLine();
					System.out.println();
					if (input2.equalsIgnoreCase("x")) break;
					else if (input2.equalsIgnoreCase("a"))
					{
						System.out.print("Enter an age group (12-16, 17-21, 22-30, 31-64, 65+): ");
						input3 = in.nextLine();
						System.out.println(getDeathsData(input3).getAllDeaths() + "\n" + getDeathsData(input3));
					}
					else if (input2.equalsIgnoreCase("b"))
						System.out.println(getHighestDeaths());
					else if (input2.equalsIgnoreCase("c"))
					{
						System.out.println("(12-16, 17-21, 22-30, 31-64, 65+)");
						System.out.print("Enter the first age group to compare: ");
						input3 = in.nextLine();
						System.out.print("Enter the second age group to compare: ");
						input4 = in.nextLine();
						System.out.println();
						compareDeaths(input3, input4);
					}
					System.out.println("\n");
				}
			}
			else if (input.equals("4"))
			{
				while (true)
				{
					System.out.print("Enter an input to cross analyze (a to compare by age group, b to see if highest deaths and drug use are same age group, c to compare two different age groups, d see all age group comparisons, x to go back): ");
					input2 = in.nextLine();
					System.out.println();
					if (input2.equalsIgnoreCase("x")) break;
					else if (input2.equalsIgnoreCase("a"))
					{
						System.out.print("Enter an age group (12-16, 17-21, 22-30, 31-64, 65+): ");
						input3 = in.nextLine();
						System.out.println(input3+":\n"+getDeathsData(input3)+"\n"+getDrugData(input3).overallDrugUseFreq()+" drug use");
					}
					else if (input2.equalsIgnoreCase("b"))
						System.out.println(getHighestDeaths()+"\n"+getHighestDrugUse());
					else if (input2.equalsIgnoreCase("c"))
					{
						System.out.println("(12-16, 17-21, 22-30, 31-64, 65+)");
						System.out.print("Enter the first age group to compare: ");
						input3 = in.nextLine();
						System.out.print("Enter the second age group to compare: ");
						input4 = in.nextLine();
						System.out.println();
						System.out.println(input3+":\n"+getDeathsData(input3)+"\n"+getDrugData(input3).overallDrugUseFreq()+" drug use\n");
						System.out.println(input4+":\n"+getDeathsData(input4)+"\n"+getDrugData(input4).overallDrugUseFreq()+" drug use");
					}
					else if (input2.equalsIgnoreCase("d"))
					{
						System.out.println("12-16:\n"+getDeathsData("12-16")+"\n"+getDrugData("12-16").overallDrugUseFreq()+" drug use\n");
						System.out.println("17-21:\n"+getDeathsData("17-21")+"\n"+getDrugData("17-21").overallDrugUseFreq()+" drug use\n");
						System.out.println("22-30:\n"+getDeathsData("22-30")+"\n"+getDrugData("22-30").overallDrugUseFreq()+" drug use\n");
						System.out.println("31-64:\n"+getDeathsData("31-64")+"\n"+getDrugData("31-64").overallDrugUseFreq()+" drug use\n");
						System.out.println("65+:\n"+getDeathsData("65+")+"\n"+getDrugData("65+").overallDrugUseFreq()+" drug use");
					}
					System.out.println("\n");
				}
			}
			System.out.println("\n\n");
		}

		System.out.println("\n\nCONCLUSION:");
		System.out.println("From the data, it can be concluded that more drug use does in fact lead to more deaths.\nThe high number of deaths in the 65+ age range is probably from other factors that don't have to with drug use, such as age and disease.");
		System.out.println("The bigger age range of 31-64 could cause skewed results as there are a lot more people in that group, so naturally there would be more deaths and drug use.");
		System.out.println("For those reasons, I am not confident in the result that more drug use has a significant impact on the number of deaths.");
		System.out.println("A data set that would lead to a conclusion is a table to gives the amount of drug related deaths in an age group");
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

	public DrugUse getDrugData(String age)
	{
		for (Map.Entry<String, DrugUse> entry : drugsMap.entrySet())
		{
			if (entry.getKey().equals(age))
				return entry.getValue();
		}
		return null;
	}

	public YearlyDeaths getDeathsData(String age)
	{
		for (Map.Entry<String, YearlyDeaths> entry : deathsMap.entrySet())
		{
			if (entry.getKey().equals(age))
				return entry.getValue();
		}
		return null;
	}

	public double[] compareDrugUse(String age1, String age2)
	{
		DrugUse a1 = getDrugData(age1), a2 = getDrugData(age2);
		if (a1.overallDrugUseFreq() > a2.overallDrugUseFreq())
			System.out.println(age1 + " year olds use more drugs than " + age2 + " year olds\n" + a1.overallDrugUseFreq() + " compared to " + a2.overallDrugUseFreq());
		else
			System.out.println(age2 + " year olds use more drugs than " + age1 + " year olds\n" + a2.overallDrugUseFreq() + " compared to " + a1.overallDrugUseFreq());
		return new double[]{a1.overallDrugUseFreq(), a2.overallDrugUseFreq()};
	}

	public double[] compareDeaths(String age1, String age2)
	{
		YearlyDeaths a1 = getDeathsData(age1), a2 = getDeathsData(age2);
		if (a1.getAverageDeaths() > a2.getAverageDeaths())
			System.out.println(age1 + " year olds have more yearly deaths than " + age2 + " year olds\n" + a1.getAverageDeaths() + " compared to " + a2.getAverageDeaths());
					else
			System.out.println(age2 + " year olds have more yearly deaths than " + age1 + " year olds\n" + a2.getAverageDeaths() + " compared to " + a1.getAverageDeaths());
		return new double[]{a1.getAverageDeaths(), a2.getAverageDeaths()};
	}

	public String getHighestDrugUse()
	{
		double max = Double.MIN_VALUE;
		String age = "";
		for (Map.Entry<String, DrugUse> entry : drugsMap.entrySet())
			if (entry.getValue().overallDrugUseFreq()>max)
			{
				max = entry.getValue().overallDrugUseFreq();
				age = entry.getKey();
			}
		return age + "\nDrug use: " + max;
	}

	public String getHighestDeaths()
	{
		double max = Double.MIN_VALUE;
		String age = "";
		for (Map.Entry<String, YearlyDeaths> entry : deathsMap.entrySet())
			if (entry.getValue().getAverageDeaths()>max)
			{
				max = entry.getValue().getAverageDeaths();
				age = entry.getKey();
			}
		return age + "\nDeaths: " + max;
	}
}