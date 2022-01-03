import java.util.*;
public class SuperListRunner
{

	public SuperListRunner()
	{
		//This is to test your code. If it works, you should get my answers!
		Queue<Integer> stack=new LinkedList<Integer>();
		System.out.println(stack.poll());
		SuperList<Integer> list=new SuperList<Integer>();
		list.add(10);
    System.out.println(list);
		list.add(0,5);
		list.add(list.size()-1,8);
		list.add(1,12);
		list.add(20);
		list.add(25);
		list.add(4,100);
		list.add(0,0);
		list.add(list.size()-1,1000);	//Should put 1000 in front of 25 (which had been the end)
		list.add(list.size(),555);	//should make 555 the last number in the list (the end)
		System.out.println("Size: "+list.size());
		System.out.println("List: "+list);

		System.out.println("Get tests: ");
		System.out.println("index 0: "+list.get(0));
		System.out.println("index 3: "+list.get(3));
		System.out.println("Peek (queue): "+list.queuePeek());
		System.out.println("Peek (stack): "+list.stackPeek());


		System.out.println("\nRemove tests: ");
		System.out.println("Remove index 2: "+list.remove(2));
		System.out.println("Remove index 3: "+list.remove(3));
		System.out.println("Remove index 0: "+list.remove(0));
		System.out.println("Remove index list.size()-1: "+list.remove(list.size()-1));

		System.out.println(list);
    /*
		SuperList<Integer> temp=new SuperList<Integer>();
		while(list.size()>0)
			temp.add(0,list.remove(0));
		System.out.println(list);
		System.out.println(temp);

		list=temp;
    */
		System.out.println("\nRemove values at indexes 2, 3, 0, and then size()-1 respectively.");
		System.out.println("\tList: "+list);


		System.out.println("Pop and Poll tests: ");
		System.out.println("Popped: "+list.pop());
		System.out.println("Polled: "+list.poll());
		System.out.println("Pop a value and then poll a value.");
		System.out.println("\tList: "+list);

		System.out.println("\nContains Test:");
		System.out.println("\tContains 4: "+list.contains(4));
		System.out.println("\tContains 20: "+list.contains(20));

		System.out.println("\nHere is the list, \"unstacked\": ");
		SuperList<Integer> tempList=new SuperList<Integer>();
		String output="[";
		while(!list.isEmpty())
		{
			int num=list.pop();
			output+=num;
			try
			{
				if (list.stackPeek() != null)
				output+=", ";
			}catch(EmptyStackException e) {}
			tempList.add(num);
		}
		output+="]";
		list=tempList;
		System.out.println("Stack: "+output);

		System.out.println("\nnHere is the list, \"unqueued\": ");
		SuperList<Integer> tempListQ=new SuperList<Integer>();
		output="[";
		while(!list.isEmpty())
		{
			int num=list.poll();
			output+=num;
			if(list.queuePeek()!=null)
				output+=", ";
			tempListQ.push(num);
		}
		output+="]";
		list=tempListQ;
		System.out.println("Queue: "+output);

		System.out.println();
		list.clear();
		System.out.println("\nClear List!");
			System.out.println("\tList: "+list);

		SuperList<String> stringList=new SuperList<String>();
		stringList.add("St1");
		stringList.add("St2");
		stringList.add("St3");
		System.out.println("String List: "+stringList);
	}
	public static void main(String[] args)
	{
		SuperListRunner app=new SuperListRunner();
	}

}