//Anurag Tilwe
import java.util.*;
import java.lang.*;
import java.io.*;
public class Diamond
{

	public static void main(String[]args)
	{

		int[] diamond = new int[5];

		try {

			BufferedReader input = new BufferedReader(new FileReader("InputDiamond.txt"));
			String text;
			while ((text=input.readLine()) != null)
			{
				String[] nums = text.split(" ");
				for (int i = 0; i < 5; i++)
					diamond[i] = Integer.parseInt(nums[i]);

				drawDiamond(diamond);
			}

		}
		catch (IOException io)
		{
			System.out.println("File does not exist");
		}

	}

	public static void drawDiamond(int[] diamond)
	{
		String[][] background = new String[diamond[0]][diamond[1]];
		for (int r = 0; r < diamond[0]; r++)
			for (int c = 0; c < diamond[1]; c++)
				background[r][c] = "o";

		int start = diamond[4], end = diamond[4];
		for (int r = diamond[3]; r < diamond[0]; r++)
		{
			for (int c = 0; c < diamond[1]; c++)
				if (start <= c && c <= end)
					background[r][c] = "x";

			if (r-diamond[3] < diamond[2]-1)
			{
				start--;
				end++;
			} else {
				start++;
				end--;
			}
		}

		for (int r = 0; r < background.length; r++)
		{
			for (int c = 0; c < background[0].length; c++)
				System.out.print(background[r][c]);
			System.out.println();
		}
	}

}