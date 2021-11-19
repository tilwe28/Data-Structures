//Anurag Tilwe
import java.io.*;
import java.lang.*;
import java.util.*;
public class CodeBreaker
{

	public static void main(String[] args)
	{
		ArrayList<String> guesses = new ArrayList<String>();
		String solution;

		File name = new File("codeBreaker.txt");
		try
		{
			BufferedReader input = new BufferedReader(new FileReader(name));
			solution=input.readLine();
			String text;
			while((text=input.readLine())!= null)
				guesses.add(text);
			checkGuess(guesses, solution);
		}
		catch (IOException io)
		{
			System.out.println("File does not exist");
		}
	}

	public static void checkGuess(ArrayList<String> guess, String solution)
	{
		for (int i = 0; i < guess.size(); i++)
		{
			System.out.println("Code: " + solution);
			System.out.println("Guess: " + guess.get(i));

			int[] correct = checkCorrect(guess.get(i), solution);
			System.out.println("Color Correct - Correctly Placed: " + correct[0]);
			System.out.println("Color Correct - Inorrectly Placed: " + correct[1]);
			System.out.println();
		}
	}

	public static int[] checkCorrect(String guess, String solution)
	{
		int countCorrect = 0, countColor = 0;
		char[] colors = solution.toCharArray();

		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				if (colors[i] == guess.charAt(j))
				{
					if (i==j)
						countCorrect++;
					else
						countColor++;
					break;
				}

		int[] correct = {countCorrect, countColor};
		return correct;
	}
}