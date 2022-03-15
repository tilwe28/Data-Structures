//Anurag Tilwe
import java.util.*;
public class PIDay
{
	public static void main(String[] args)
	{
		String pi = "3.1415926535897932384626433832795028841971693993751058209749445923078164062862089986280348253421170679";
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (Character c : pi.toCharArray())
		{
			if (map.containsKey(c))
				map.put(c, map.get(c)+1);
			else
				map.put(c, 1);
		}

		System.out.println(map);

		int maxCount = Integer.MIN_VALUE, maxValue = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet())
		{
			if (entry.getValue() > maxCount)
			{
				maxCount = entry.getValue();
				maxValue = Integer.parseInt(entry.getKey() + "");
			}
		}

		System.out.println(maxValue + " occurred the most at " + maxCount + " times.");
	}
}