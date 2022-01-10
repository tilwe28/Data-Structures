//Anurag Tilwe
import java.util.*;
public class HashAndTreeSetAssignment
{
	public static void main(String[]args)
	{
		//1
		ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
		int r = (int)(Math.random()*((12-2)+1))+2;
		for (int i=0; i<r; i++)
		{
			list.add(new HashSet<Integer>());
			while (list.get(i).size()<10)
				list.get(i).add((int)(Math.random()*((30-1)+1))+1);
			System.out.println("Set " + (i+1) + " => " + list.get(i));
		}

		//2
		Set<Integer> intersectionSet = intersection(list.get(0), list.get(1));
		for (int i=2; i<list.size(); i++)
			intersectionSet = intersection(intersectionSet, list.get(i));
		System.out.println("Intersection => " + intersectionSet);

		//3
		Set<Integer> unionSet = union(list.get(0), list.get(1));
		for (int i=2; i<list.size(); i++)
			unionSet = union(unionSet, list.get(i));
		System.out.println("Union => " + unionSet);
	}

	public static Set<Integer> intersection(Set<Integer> set1, Set<Integer> set2)
	{
		Set<Integer> common = new HashSet<Integer>();
		for (Integer i : set1)
			if (set2.contains(i))
				common.add(i);
		return common;
	}

	public static Set<Integer> union(Set<Integer> set1, Set<Integer> set2)
	{
		Set<Integer> total = new TreeSet<Integer>();
		total.addAll(set1);
		total.addAll(set2);
		return total;
	}
}