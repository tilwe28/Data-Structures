//Anurag Tilwe
import java.util.*;
import java.io.*;
public class TeamScoresProblem
{
	public static void main(String[]args)
	{
		Map<String, int[]> map = new HashMap<String, int[]>();
		try {
			BufferedReader input = new BufferedReader(new FileReader("TeamScores.csv"));
			input.readLine();//Heading
			String text;
			while ((text=input.readLine()) != null)
			{
				String[] data = text.split(",");
				map.put(data[0], new int[]{Integer.parseInt(data[1]), Integer.parseInt(data[2])});
			}
		} catch (IOException io) {
			System.err.println("File does not exist.");
		}
		//for (Map.Entry<String, int[]> entry : map.entrySet())
		//	System.out.println(entry.getKey() + " " + entry.getValue()[0] + " " + entry.getValue()[1]);
		double[] x = new double[map.size()], y = new double[map.size()];
		int i=0;
		for (Map.Entry<String, int[]> entry : map.entrySet())
		{
			x[i] = entry.getValue()[1];
			y[i] = entry.getValue()[0];
			i++;
		}

		LinearRegression lr = new LinearRegression(x, y);
		System.out.println(lr);

		Scanner in = new Scanner(System.in);
		boolean cont = true;
		while (cont)
		{
			System.out.print("Enter a team name: ");
			String team = in.nextLine();
			if (team.equalsIgnoreCase("x")) { cont=false; break; }
			if (map.containsKey(team))
			{
				System.out.println("Predicted: " + lr.predict(map.get(team)[1]));
				System.out.println("Actual: " + map.get(team)[0]);
			} else System.out.println("Team not found.");
			System.out.println();
		}
	}
}