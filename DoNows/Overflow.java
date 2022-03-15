//Anurag Tilwe
public class Overflow
{
	public static void main(String[]args)
	{
		int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
		System.out.println(max + "\n" + min);
		max++;
		min--;
		System.out.println("\n" + max + "\n" + min);
		System.out.println("\n\n" + (int)(Integer.MAX_VALUE * (int)99));
	}
}