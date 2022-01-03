//Anurag Tilwe
public class ChallengeTasks
{
	public static void main(String[]args)
	{
		bonus();
		//two();
		//three();
		//five();
		//eight();
		//ten();
	}

	public void one()
	{

	}

	public static void two()
	{
		double tox=2, max = Double.MAX_VALUE;
		boolean found = false;
		while (tox < max)
		{
			tox*=2;

			System.out.println("2tox: " + tox);
		}
	}

	public static void three()
	{
		int max = Integer.MAX_VALUE;
		boolean found = false;
		while (!found)
		{
			found=true;
		}
		System.out.println(max);
	}

	public static void five()
	{
		int[] squares = new int[100], cubes = new int[100];
		int count=0, square=0, cube=0;
		boolean found = false;
		for (int i=0; i<100; i++)
		{
			squares[i] = i*i;
			cubes[i] = i*i*i;
		}
		for (int i=0; i<100 && !found; i++)
			for (int j=0; j<100 && !found; j++)
				if (cubes[j]-squares[i] == 13)
				{
					found = true;
					square = squares[i];
					cube = cubes[j];
				}
		System.out.println(square + " " + cube);
	}

	public static void eight()
	{
		int vowel=0, consonant=0;
		String lowestState = "";
		double lowest = 1, perc = 0;
		String[] states = {"Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Carolina","North Dakota","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"};
		for (int i=0; i<50; i++)
		{
			vowel = 0;
			consonant = 0;
			perc = 0;
			String state = states[i];
			for (int j=0; j<state.length(); j++)
			{
				if (state.toCharArray()[j] == 'a' || state.toCharArray()[j] == 'A' || state.toCharArray()[j] == 'e' || state.toCharArray()[j] == 'E' || state.toCharArray()[j] == 'i' || state.toCharArray()[j] == 'I' || state.toCharArray()[j] == 'o' || state.toCharArray()[j] == 'O' || state.toCharArray()[j] == 'u' || state.toCharArray()[j] == 'U')
					vowel++;
				else if (state.toCharArray()[j] != ' ')
					consonant++;
				perc = (double)vowel/(vowel+consonant);
			}
			if (perc < lowest)
			{
				lowest = perc;
				lowestState = states[i];
			}
		}
		System.out.println("State: " + lowestState + "\tPercentage: " + lowest);
	}

	public void nine()
	{

	}

	public static void ten()
	{
		boolean found = false;
		int num = 2520;
		while (!found)
		{
			if (num%2==0 && num%3==0 && num%4==0 && num%5==0 && num%6==0 && num%7==0 && num%8==0 && num%9==0 && num%10==0 && num%11==0 && num%12==0 && num%13==0 && num%14==0 && num%15==0)
				found = true;
			else num++;
		}
		System.out.println(num);
	}

	public static void bonus()
	{
		long num = Long.MAX_VALUE;
		boolean found = false;
		while (!found)
		{
			boolean prime = true;
			for (int i=2; i<num/2 && prime; i++)
			{
				if (num%i == 0)
					prime = false;
			}
			if (prime) found = true;
			else num--;
			System.out.println(prime + " " + num);
		}
		System.out.println(num);
	}
}