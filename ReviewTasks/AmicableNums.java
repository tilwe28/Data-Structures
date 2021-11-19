//Anurag Tilwe
import java.io.*;
import java.lang.*;
import java.util.*;
public class AmicableNums
{
	public static void main(String[]args)
	{
		try
		{
			BufferedReader input = new BufferedReader(new FileReader("amicable.txt"));
			String text;
			while((text=input.readLine())!= null)
			{
				ArrayList<Integer> nums = new ArrayList<Integer>();
				String num1 = text.substring(0, text.indexOf(" "));
				String num2 = text.substring(text.indexOf(" ") + 1);
				nums.add(Integer.parseInt(num1));
				nums.add(Integer.parseInt(num2));

				getAmicable(nums);
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	public static void getAmicable(ArrayList<Integer> nums)
	{
		ArrayList<Integer> factors1 = new ArrayList<Integer>();
		ArrayList<Integer> factors2 = new ArrayList<Integer>();

		for (int i = 1; i < nums.get(0) || i < nums.get(1); i++)
		{
			if ((nums.get(0) % i == 0) && (nums.get(0)>i))
				factors1.add(i);
			if ((nums.get(1) % i == 0) && (nums.get(1)>i))
				factors2.add(i);
		}

		int sum1 = 0, sum2 = 0;
		for (int i = 0; i < factors1.size() || i < factors2.size(); i++)
		{
			if (factors1.size()>i)
				sum1+=factors1.get(i);
			if (factors2.size()>i)
				sum2+=factors2.get(i);
		}

		if (sum1 == nums.get(1) && sum2 == nums.get(0))
			System.out.println("The numbers " + sum2 + " and " + sum1 + " are amicable.");
		else
			System.out.println("The numbers " + nums.get(0) + " and " + nums.get(1) + " are not amicable.");

		System.out.print("\tFactors of " + nums.get(0) + " are");
		for (int i = 0; i < factors1.size(); i++)
		{
			if (i < factors1.size()-1)
				System.out.print(" " + factors1.get(i) + ",");
			if (i == factors1.size()-1)
				System.out.println(" and " + factors1.get(i) + ". Sum is " + sum1 + ".");
		}

		System.out.print("\tFactors of " + nums.get(1) + " are");
		for (int i = 0; i < factors2.size(); i++)
		{
			if (i < factors2.size()-1)
				System.out.print(" " + factors2.get(i) + ",");
			if (i == factors2.size()-1)
				System.out.println(" and " + factors2.get(i) + ". Sum is " + sum2 + ".");
		}
	}
}