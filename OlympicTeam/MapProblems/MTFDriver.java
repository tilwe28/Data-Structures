import java.io.*;
import java.util.*;
public class MTFDriver
{
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);

		MapToFile mtf = new MapToFile("StateAndCapital.txt");
		mtf.read();
		System.out.println("Before changes:");
		mtf.print();

		System.out.println("\n\n");

		System.out.println("Here you can make changes to what the capital of a state is by typing in the state and then the new capital!");
		System.out.println("To stop making changes type (x)\n");
		System.out.print("State to have new capital: ");
		String inputState = in.nextLine(), inputCapital = "";
		while (!inputState.equalsIgnoreCase("x"))
		{
			if (mtf.getMap().containsKey(inputState))
			{
				System.out.print("New capital for " + inputState + ": ");
				inputCapital = in.nextLine();
				mtf.getMap().put(inputState, inputCapital);
				System.out.println("Done!\n");
			}
			else System.out.println("State does not exist.\n");
			System.out.print("State to have new capital: ");
			inputState = in.nextLine();
		}
		mtf.write();
		System.out.println("You have finished making edits!");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException ie) {
			System.err.println("Thread error");
		}
		System.out.println("\n\n");

		System.out.println("After changes:");
		mtf.print();
	}
}