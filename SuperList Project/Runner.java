//Anurag Tilwe
public class Runner
{
	public static void main(String[]args)
	{
		//Filling SuperList with 30 random integers
		System.out.println("ArrayList SuperList");
		SuperList<Integer> slArr = new SuperList<Integer>();
		for (int i=0; i<30; i++)
			slArr.add((int)(Math.random()*((1000-1)+1))+1);
		System.out.println(slArr);
		System.out.println("Size: " + slArr.size());

		//Stack functioning SuperList
		System.out.println("\n\nStack SuperList");
		SuperList<Integer> slStack = new SuperList<Integer>();
		while (!(slArr.isEmpty()))
			slStack.push(slArr.remove(0));
		System.out.println(slStack);

		//Queue functioning SuperList
		System.out.println("\n\nQueue SuperList");
		SuperList<Integer> slQueue = new SuperList<Integer>();
		while (!(slStack.isEmpty()))
			slQueue.add(slStack.pop());
		System.out.println(slQueue);

		//Refilling ArrayList functioning SuperList at random indexes
		System.out.println("\n\nRefilling ArrayList Randomly");
		for (int i=0; i<slQueue.size(); i++)
			slArr.add(null);
		while (!(slQueue.isEmpty()))
		{
			int r = (int)(Math.random()*((slArr.size()-1-0)+1)), oldSize = slArr.size();
			if (slArr.get(r)==null)
			{
				slArr.remove(r);
				if (r != oldSize-1)
					slArr.add(r, slQueue.poll());
				else slArr.add(slQueue.poll());
			}
		}
		System.out.println(slArr);

		System.out.println("\n");

		//Sum
		int sum = 0;
		for (int i=0; i<slArr.size(); i++)
			sum += slArr.get(i);
		System.out.println("Sum: " + sum);

		//Sum of even indexes
		sum = 0;
		for (int i=0; i<slArr.size(); i+=2)
			sum += slArr.get(i);
		System.out.println("Sum of even indexes: " + sum);

		//Sum of odd indexes
		sum = 0;
		for (int i=1; i<slArr.size(); i+=2)
			sum += slArr.get(i);
		System.out.println("Sum of odd indexes: " + sum);

		//Adding duplicates of even values
		System.out.println("\n\nDuplicates of even values");
		int size = slArr.size();
		for (int i=0; i<size; i++)
			if (slArr.get(i)%2==0)
				slArr.add(slArr.get(i));
		System.out.println(slArr);

		//Removing value that are divisibile by 3
		System.out.println("\n\nRemoved values divisible by 3");
		for (int i=0; i<slArr.size(); i++)
			if (slArr.get(i)%3==0)
			{
				slArr.remove(i);
				i--;
			}
		System.out.println(slArr);

		//Inserting 55555 into 4th index
		System.out.println("\n\nInserted 55555 into 4th position");
		slArr.add(3, 55555);
		System.out.println(slArr);

		//Sorting in descending order
		System.out.println("\n\nSorted in descending order");
		for (int i=0; i<slArr.size()-1; i++)
		{
			int currentMax = slArr.get(i), index = i;
			for (int j=i+1; j<slArr.size(); j++)
				if (slArr.get(j) > currentMax)
				{
					currentMax = slArr.get(j);
					index = j;
				}
			slArr.add(i, slArr.remove(index));
		}
		System.out.println(slArr);

		//Searching for median
		System.out.println("\n\nMedian search");
		int l=0, r=slArr.size()-1;
		System.out.println("Size: " + slArr.size());
		if (slArr.size()%2==1)
		{
			int median = slArr.get(slArr.size()/2);
			while (l<=r)
			{
				int mid = l+(r-l)/2;
				if (slArr.get(mid).equals(median))
				{
					System.out.println("Median: " + median);
					break;
				}
				if (slArr.get(mid)>median)
					l=mid+1;
				if (slArr.get(mid)<median)
					r=mid-1;
			}
		}
		else {
			double median = ((double)(double)slArr.get(slArr.size()/2)+(double)slArr.get(slArr.size()/2-1))/2;
			System.out.println("Median: " + median);
			int sum1=0, sum2=0;
			for (int i=0; i<slArr.size()/2; i++)
				sum1 += slArr.get(i);
			for (int i=slArr.size()/2; i<slArr.size(); i++)
				sum2 += slArr.get(i);
			System.out.println("Sum before \"median\": " + sum1);
			System.out.println("Sum after \"median\": " + sum2);
		}

		//SuperList of String
		System.out.println("\n\nSuperList of String");
		SuperList<String> slString = new SuperList<String>();
		String sentence = "Hello my name is Gaurav and I learned how to find the jacobian of transformations today.";
		for (int i=0; i<sentence.split(" ").length; i++)
			slString.add(sentence.split(" ")[i]);
		System.out.println(slString);

		//Removing words that are have 3 or less characters
		System.out.println("\n\nRemoved strings with 3 or less characters");
		for (int i=0; i<slString.size(); i++)
			if (slString.get(i).length() <= 3)
			{
				slString.remove(i);
				i--;
			}
		System.out.println(slString);

		//Sorting in ascending order
		System.out.println("\n\nSorted in ascending order");
		slString = insertionSort(slString);
		System.out.println(slString);

		System.out.println("\n");

		//Average word length
		sum = 0;
		for (int i=0; i<slString.size(); i++)
			sum += slString.get(i).length();
		System.out.println("Average word length: " + (double)sum/slString.size());
	}

	private static SuperList<String> insertionSort(SuperList<String> sl)
	{
		for (int i = 1; i < sl.size(); i++)
		{
			String current = sl.get(i);
			int j = i-1;
			while (j>=0 && (sl.get(j).compareTo(current))==1)
			{
				sl.set(j+1, sl.get(j));
				j--;
			}
			sl.set(j+1, current);
    	}
    	return sl;
	}
}