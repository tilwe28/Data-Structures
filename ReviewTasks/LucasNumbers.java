//Anurag Tilwe
import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.BigInteger;
public class LucasNumbers
{
	public static void main(String[]args)
	{
		try
		{
			BufferedReader input = new BufferedReader(new FileReader("lucas.txt"));
			String text;
			while((text=input.readLine())!= null)
			{
				BigInteger aBig = new BigInteger("2");
				BigInteger bBig = new BigInteger("1");
				BigInteger xBig = new BigInteger("1");

				for(int i = 1; i<Integer.parseInt(text); i++)
				{
					xBig = aBig.add(bBig);
					aBig = bBig;
					bBig = xBig;
				}

				System.out.println(xBig.toString());
			}
		}
		catch (IOException io)
		{
			System.out.println("File does not exist");
		}
	}
}