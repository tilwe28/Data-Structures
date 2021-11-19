//Anurag Tilwe
import java.util.*;
import java.lang.*;
import java.io.*;

public class Sets
{

	public static void main(String[]args)
	{

		ArrayList<Integer[]> lines1 = new ArrayList<Integer[]>();
		ArrayList<Integer[]> lines2 = new ArrayList<Integer[]>();
		ArrayList<Integer[]> lines3 = new ArrayList<Integer[]>();
		int numSets = 0;

		try {

			BufferedReader input = new BufferedReader(new FileReader("InputSets.txt"));
			String text;
			while ((text=input.readLine()) != null)
			{

				String[] line = text.split(" ");
				Integer[] nums = new Integer[line.length];
				for (int i = 0; i < line.length; i++)
					nums[i] = Integer.parseInt(line[i]);

				if (numSets % 3 == 0)
					lines1.add(nums);
				else if (numSets % 3 == 1)
					lines2.add(nums);
				else if (numSets % 3 == 2)
					lines3.add(nums);

				numSets++;
			}

		}
		catch (IOException io)
		{
			System.out.println("File does not exist");
		}

		for (int i = 0; i < numSets/3; i++)
		{
			ArrayList<Integer> nums = findIntersection(lines1.get(i), lines2.get(i), lines3.get(i));
			System.out.print("Set " + (i+1) + " intersection = {");
			for (int j = 0; j < nums.size(); j++)
				if (j == 0)
					System.out.print(nums.get(j));
				else System.out.print(", " + nums.get(j));
			System.out.println("}");
		}

	}

	public static ArrayList<Integer> findIntersection(Integer[] set1, Integer[] set2, Integer[] set3)
	{
		ArrayList<Integer> intersectionNums = new ArrayList<Integer>();

		for (int i = 0; i < set1.length; i++)
			for (int j = 0; j < set2.length; j++)
				for (int k = 0; k < set3.length; k++)
					if (set1[i] == set2[j] && set2[j] == set3[k])
						intersectionNums.add(set3[k]);

		Collections.sort(intersectionNums);

		return intersectionNums;
	}

}