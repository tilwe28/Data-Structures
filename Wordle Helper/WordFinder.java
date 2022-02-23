//Anurag Tilwe
import java.util.*;
import java.io.*;
public class WordFinder
{
	private final ArrayList<String> words, goodWords;
	private Scanner in;

	public WordFinder(String file, int l)
	{
		words = new ArrayList<String>();
		goodWords = new ArrayList<String>();
		in = new Scanner(System.in);

		//Loads ArrayList with all 5 letter words
		try {
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			while ((text=input.readLine())!=null)
				words.add(text);
		} catch (IOException io) {
			System.err.println("File does not exist.");
		}//loading data

		//Communicating with user
		System.out.println("INSTRUCTIONS\nEnter a capital letter for a letter in the correct spot\nEnter a lowercase letter for a letter in the word but not in that position\nEnter a \"-\" for spot with no information\nEnter \"x\" to exit");
		while (true)
		{
			goodWords.clear();
			System.out.print("\n"+l+" letter word: ");
			String s = in.nextLine();
			if (s.equalsIgnoreCase("x")) break;	//Ends when user enters "x"
			while (s.length()!=l && !s.equalsIgnoreCase("x"))	//Makes sure input is a valid 5 letter entry
			{
				System.out.print("\nEntry invalid. Enter "+l+" letter word: ");
				s = in.nextLine();
			}
			if (s.equalsIgnoreCase("x")) break;	//Ends when user enters "x"

			//Fills arrays with letters in correct position and letters in the word but not sure where
			String[] correct = new String[l], almost = new String[l];
			int correctCount = 0, almostCount = 0;
			for (int i=0; i<s.length(); i++)
			{
				if (Character.isUpperCase(s.charAt(i)))
				{
					correct[i] = s.charAt(i)+"";
					correctCount++;
				}
				if (Character.isLowerCase(s.charAt(i)))
				{
					almost[i] = s.charAt(i)+"";
					almostCount++;
				}
			}

			//Fills in goodWords ArrayList with words that satisfy the given conditions
			boolean add = false;
			for (int i=0; i<words.size(); i++)
			{
				String w = words.get(i);
				int correctCountCheck = correctCount, almostCountCheck = almostCount;
				for (int j=0; j<l; j++)
				{
					if ((w.charAt(j)+"").equalsIgnoreCase(correct[j]))
						correctCountCheck--;
					else if (almost[j] != null)
						if (w.contains(almost[j]))
							almostCountCheck--;
				}
				if (correctCountCheck==0 && almostCountCheck==0)
					goodWords.add(w);
			}

			printArray(correct);
			printArray(almost);

			System.out.println("\nPotential answers for the wordle:");
			for (String gw : goodWords)
				System.out.println(gw);
		}
	}//WordFinder

	public void printArray(String[] arr)
	{
		for (String s : arr)
		{
			if (s == null) System.out.print("_");
			else System.out.print(s);
		}
		System.out.println();
	}//printArray

	public static void main(String[]args)
	{
		WordFinder wf = new WordFinder("WordBank.txt", 5);
	}//main
}