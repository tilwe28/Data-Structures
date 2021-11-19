import java.util.*;
import java.io.*;
public class StackAssignment1
{
	public static void main(String[]args)
	{
		BinaryConverter bc = new BinaryConverter("BinaryInput.txt");
		System.out.println("\n\n");
		ReverseString rs = new ReverseString("RSInput.txt");
		System.out.println("\n\n");
		Municipalities m = new Municipalities("NJMunicipalities.csv");
	}
}

class BinaryConverter
{
	public BinaryConverter(String file)
	{

		System.out.println("Binary Converter\n----------------");

		Stack<Integer> binary = new Stack<Integer>();
		ArrayList<Integer> nums = new ArrayList<Integer>();

		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			while((text=input.readLine())!= null)
			{
				nums.add(Integer.parseInt(text));
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}

		while (!(nums.isEmpty()))
		{
			int num = nums.remove(0);
			while (num > 0)
			{
				for (int i=0; i<4; i++)
				{
					binary.push(num%2);
					num /= 2;
				}
			}
			while (!(binary.isEmpty()))
				System.out.print(binary.pop());
			System.out.println();
		}
	}
}

class ReverseString
{

	Stack<Character> reversed;

	public ReverseString(String file)
	{

		System.out.println("Reverse a String\n----------------");

		reversed = new Stack<Character>();

		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			while((text=input.readLine())!= null)
			{
				for (int i=0; i<text.length(); i++)
					reversed.push(text.toCharArray()[i]);
				reverse();
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}
	}

	void reverse()
	{
		while (!(reversed.isEmpty()))
			System.out.print(reversed.pop());
		System.out.println();
	}
}

class Municipalities
{

	private ArrayList<Stack<Municipality>> m;

	public Municipalities(String file)
	{

		System.out.println("Municipalities\n--------------");

		boolean landfill = false;

		m = new ArrayList<Stack<Municipality>>();
		for (int i=0; i<21; i++)
			m.add(new Stack<Municipality>());

		try
		{
			BufferedReader input = new BufferedReader(new FileReader(file));
			String text;
			while((text=input.readLine())!= null)
			{
				String a[] = text.split(",");
				if (a[1].equals("Burlington"))//1
					m.get(0).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Cumberland"))//2
					m.get(1).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Somerset"))//3
					m.get(2).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Essex"))//4
					m.get(3).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Camden"))//5
					m.get(4).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Monmouth"))//6
					m.get(5).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Morris"))//7
					m.get(6).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Middlesex"))//8
					m.get(7).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Bergen"))//9
					m.get(8).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Hunterdon"))//10
					m.get(9).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Ocean"))//11
					m.get(10).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Salem"))//12
					m.get(11).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Atlantic"))//13
					m.get(12).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Cape May"))//14
					m.get(13).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Union"))//15
					m.get(14).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Gloucester"))//16
					m.get(15).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Warren"))//17
					m.get(16).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Sussex"))//18
					m.get(17).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Mercer"))//19
					m.get(18).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Passaic"))//20
					m.get(19).push(new Municipality(a[0], a[1], a[2]));
				else if (a[1].equals("Hudson"))//21
					m.get(20).push(new Municipality(a[0], a[1], a[2]));
			}
		}
		catch (IOException io)
		{
			System.err.println("File does not exist");
		}

		// PRINTS ALL MUNICIPALITIES
		/*for (int i=0; i<m.size(); i++)
			while (!(m.get(i).isEmpty()))
				System.out.println(m.get(i).pop());*/

		//System.out.println("\n\n\n");

		for (int i=0; i<m.size() && !landfill; i++)
		{
			int r = (int)(Math.random()*((20-0)+1));
			System.out.println("Selected " + m.get(r).peek().getCounty() + " County");

			while (!(m.get(r).isEmpty()) && !landfill)
			{
				Municipality mC = m.get(r).pop();
				System.out.print(mC.getType() + " of " + mC.getName() + " rolled ");

				int d = (int)(Math.random()*((6-1)+1))+1;
				if (d == 1)
				{
					System.out.println(d + ". They get the Landfill!");
					landfill = true;
				} else System.out.println(d + ". No Landill!");
			}
			System.out.println();
		}

		if (!landfill)
			System.out.println("Landfill went to Pennsylvania");
	}
}