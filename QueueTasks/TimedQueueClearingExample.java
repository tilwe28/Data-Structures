import java.util.*;

class TimedQueueClearingExample {
  public static void main(String[] args) {

    // Create Queue of Integers
    Queue<Integer> q = new LinkedList<Integer>();

    int j = 1;
    int empties = 0;
    while (j <= 100){  // Load a new Queue Element every loop
      q.add(j++);
      delay(100);  // Pause for 0.1 seconds
      // 50% of the time (if not empty) remove up to 4 elements
      if (Math.random() < 0.5){
          int r = (int)(Math.random()*5); // remove 0-4 if present
          for (int i = 0; i < r; i++){
            if (!q.isEmpty())
              System.out.println("Removed -> "+q.poll()+" new Queue size = "+q.size());
            else{
              System.out.println("Queue Empty");
              empties++;
            } // end else
          } // end for

      }//end if
      j++;
    } // end while
	System.out.println("Number of surplus polls = "+empties);
     
  }

  public static void delay(long ms){
    try {
      // thread to sleep for ms milliseconds
      Thread.sleep(ms);
    } catch (Exception e) {
      System.out.println(e);
    }
  }
 


}