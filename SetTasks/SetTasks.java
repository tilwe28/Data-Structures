//Anurag Tilwe
import java.util.*;
public class SetTasks
{
	public static void main(String[]args)
	{
		one();
		two();
		three();
	}

	public static void one()
	{
		String num = "1562836047588678243489701526384857673";
		int index=0;
		HashSet<Integer> digits = new HashSet<Integer>();
		HashSet<Integer> complete = new HashSet<Integer>();
		for (int i=0; i<=9; i++)
			complete.add(i);
		for (int i=0; i<num.length(); i++)
		{
			digits.add(Integer.parseInt(String.valueOf(num.toCharArray()[i])));
			if (digits.containsAll(complete))
			{
				index = i;
				break;
			}
		}
		System.out.println(index);
	}

	public static void two()
	{
		HashSet<Integer> bdays = new HashSet<Integer>();
		HashSet<Integer> complete = new HashSet<Integer>();

		for (int i=1; i<=365; i++)
			complete.add(i);
		int sum = 0;
		for (int i=0; i<100; i++)
		{
			int count=0;
			while (!bdays.containsAll(complete))
			{
				bdays.add((int)(Math.random()*((365-1)+1))+1);
				count++;
			}
			sum+=count;
			bdays.clear();
		}
		System.out.println((double)sum/100);
	}

	public static void three()
	{
		String text = "From the reef-fringed coast of New Caledonia, the Coral Sea stretches into the South Pacific. Slender native pines, listing like whimsical Christmas trees, punctuate the shoreline. The landscape, one of the most biodiverse on the planet, is astonishingly beautiful until the crest of a hill where a different vista unfolds: a gouged red earth pierced by belching smokestacks and giant trucks rumbling across the lunar-like terrain. This is Goro, the largest nickel mine on a tiny French territory suspended between Australia and Fiji that may hold up to a quarter of the world's nickel reserves. It also poses a critical test for Tesla, the world’s largest electric vehicle maker, which wants to take control of its supply chain and ensure that the minerals used for its car batteries are mined in an environmentally and socially responsible fashion.";
		text = text.toLowerCase().replaceAll("-", " ").replaceAll("\\p{Punct}", "");
		TreeSet<String> words = new TreeSet<String>();
		for (int i=0; i<text.split(" ").length; i++)
			words.add(text.split(" ")[i]);
		for (int i=0; i<13; i++)
			words.pollFirst();
		System.out.println(words.pollFirst());
	}
}