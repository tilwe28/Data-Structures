//Anurag Tilwe
import java.io.*;
import java.util.*;
public class PiChallenge
{
	public static void main(String[]args)
	{
		String text="";
		int longest=0, current=1, position=0;
		char letter=' ';
		ArrayList<Integer> streaks = new ArrayList<Integer>();
		try
		{
			BufferedReader input = new BufferedReader(new FileReader("PI.txt"));
			text=input.readLine().replace(" ", "");
			letter = text.charAt(0);
			for (int i=1; i<text.length(); ++i)
			{
				if (text.charAt(i) == text.charAt(i-1))
					current++;
				else current=1;
				if (current > longest)
				{
					longest = current;
					letter = text.charAt(i);
					position = i-longest;
				}
			}
		} catch (IOException io)
		{
			System.err.println("File does not exist");
		}
		System.out.println(longest + " " + letter + " " + position);
	}
}