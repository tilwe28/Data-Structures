//Anurag Tilwe
import java.util.*;
import java.io.*;
public class MapProblemSet1
{
	public static void main(String[]args)
	{
		problem1();
		System.out.println("\n\n");
		problem2();
	}

	public static void problem1()
	{
		System.out.println("Problem 1: 2 Digit combinations in Golden ratio");

		Map<String, Integer> twoDigitCombos = new HashMap<String, Integer>();
		String goldenNumberDecimals = "61803398874989484820458683436563811772030917980576286213544862270526046281890244970720720418939113748475408807538689175212663386222353693179318006076672635";
		String[] nums = goldenNumberDecimals.split("");

		for (int i=1; i<nums.length; i++)
		{
			if (twoDigitCombos.containsKey(nums[i-1]+nums[i]))
				twoDigitCombos.put((nums[i-1]+nums[i]), twoDigitCombos.get(nums[i-1]+nums[i])+1);
			else twoDigitCombos.put((nums[i-1]+nums[i]), 1);
		}
		System.out.print(twoDigitCombos.size() + " 2-digit combinations");

		for (Map.Entry<String, Integer> entry : twoDigitCombos.entrySet())
			if (entry.getValue() > 4)
				System.out.print(", " + entry.getKey() + " occured " + entry.getValue() + " times");
		System.out.println();
	}

	public static void problem2()
	{
		System.out.println("Problem 2: TreeMap to Organize Bowling Data");

		Map<Integer, PriorityQueue<Bowler>> bowlers = new TreeMap<Integer, PriorityQueue<Bowler>>();

		try {
			BufferedReader input = new BufferedReader(new FileReader("BowlingData.txt"));
			String text;
			while ((text=input.readLine()) != null)
			{
				int score = Integer.parseInt(text.split(" ")[2]);
				Bowler b = new Bowler(text.split(" ")[0], text.split(" ")[1], score);
				if (bowlers.containsKey(score))
				{
					bowlers.get(score).add(b);
					bowlers.put(score, bowlers.get(score));
				}
				else {
					PriorityQueue<Bowler> pq = new PriorityQueue<Bowler>();
					pq.add(b);
					bowlers.put(score, pq);
				}
			}
		} catch (IOException io) {
			System.err.println("File does not exist");
		}
		for (Map.Entry<Integer, PriorityQueue<Bowler>> entry : bowlers.entrySet())
		{
			System.out.print(entry.getKey() + "= [");
			while (!entry.getValue().isEmpty())
			{
				if (entry.getValue().size() != 1)
					System.out.print(entry.getValue().poll() + ", ");
				else System.out.println(entry.getValue().poll() + "]");
			}
		}
	}
}

class Bowler implements Comparable<Bowler>
{
	String firstName, lastName;
	int score;

	public Bowler(String firstName, String lastName, int score)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.score = score;
	}

	public String getFirstName() { return firstName; }
	public String getLastName() { return lastName; }
	public int score() { return score; }

	public int compareTo(Bowler other)
	{
		if (lastName.compareTo(other.getLastName()) != 0)
			return lastName.compareTo(other.getLastName());
		return firstName.compareTo(other.getFirstName());
	}

	public String toString() { return firstName + " " + lastName; }
}