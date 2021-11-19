import java.util.Stack;
public class LocationStack
{
	public LocationStack()
	{
		Stack<Location> locs = new Stack<Location>();
		for (int i = 0; i < 5; i++)
		{
			Location loc =  new Location(3,4+i);
			locs.push(loc);
			System.out.println("push =>"+loc+" to Stack   => "+locs);

		}
		while (!locs.empty())
			System.out.println("pop  =>"+locs.pop()+" from Stack => "+locs);

	}

	public static void main (String[]args)
	{
		new LocationStack();
	}
}