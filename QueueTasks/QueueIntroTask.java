//Anurag Tilwe
import java.util.*;
import java.io.*;
public class QueueIntroTask
{
	public static void main(String[]args)
	{

		Queue<String> q = new LinkedList<String>();
		Queue<String> pq = new PriorityQueue<String>(Collections.reverseOrder());

		try {
			BufferedReader input = new BufferedReader(new FileReader("randomNames.txt"));
			String text;
			while ((text=input.readLine()) != null)
			{
				q.add(text);
				pq.add(text);
			}
		} catch (IOException io) {
			System.err.println("File does not exist");
		}

		System.out.println("Position\t\tQueue\t\t\tPriority Queue");
		int c=0;
		while (!(q.isEmpty()) && !(pq.isEmpty()))
		{
			String tab = "\t\t\t";
			if (q.peek().length() >= 8)	tab = "\t\t";
			System.out.println(++c + "\t\t\t" + q.poll() + tab + pq.poll());
		}
	}
}