import java.util.*;
public class ReviewTask
{
    public static void main(String[] args)
    {
        //1
        ArrayList<Integer> nums = new ArrayList<Integer>();
        int randSize = (int)(Math.random()*((150-50)+1))+50;
        for (int i=0; i<randSize; i++)
            nums.add((int)(Math.random()*((100-1)+1))+1);
        
        //2
        System.out.println(nums + "\n");

        //3
        int size;
            //a
        if (Math.sqrt(nums.size()) % 1 == 0)
            size = (int)Math.sqrt(nums.size());
        else size = (int)Math.sqrt(nums.size()) + 1;
        int[][] arr = new int[size][size];
            //b
        while (!nums.isEmpty())
        {
            int r = (int)(Math.random()*((size-1-0)+1))+0, c = (int)(Math.random()*((size-1-0)+1))+0, i = (int)(Math.random()*((nums.size()-1-0)+1))+0;
            if (arr[r][c] == 0)
                arr[r][c] = nums.remove(i);
        }

        //4
        for (int r=0; r<size; r++)
        {
            for (int c=0; c<size; c++)
                System.out.print(arr[r][c] + " ");
            System.out.println();
        }
        System.out.println();

        //5
        Stack<Integer> stack = new Stack<Integer>();
        for (int c=0; c<arr.length; c++) for (int r=0; r<arr[0].length; r++)
            stack.push(arr[r][c]);

        //6
        System.out.println(stack + "\n");

        //7
        Set<Integer> set = new HashSet<Integer>();
        while (!stack.isEmpty())
            set.add(stack.pop());

        //8
        System.out.println(set + "\n");

        //9
        Queue<Integer> q = new PriorityQueue<Integer>();
        Iterator<Integer> itr = set.iterator();
        while (itr.hasNext())
            q.add(itr.next());
        set.clear();

        //10
        System.out.println(q + "\n");

        //11
        TreeMap<Integer, TreeSet<Integer>> map = new TreeMap<Integer, TreeSet<Integer>>();
        TreeSet<Integer> curr = new TreeSet<Integer>();
        Integer lastEven = 0;
        while (!q.isEmpty())
        {
            if (q.peek() % 2 == 0)
            {
                lastEven = q.peek();
                map.put(q.poll(), new TreeSet<Integer>());
            } else map.get(lastEven).add(q.poll());
        }

        //12
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet())
            System.out.println(entry.getKey() + ": " + entry.getValue());

    }
}