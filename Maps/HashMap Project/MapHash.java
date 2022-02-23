//Anurag Tilwe
/*
 * NOTE:  This MapHash does not support null keys
 * This is a shortcut, so a null value at a key in the
 * key Object[] represents the absence of that key
 *
 * Methods:
 * - put (K key, V value) returns previous value (or null)
 * - get (K key) returns value
 * - containsKey(K key) returns boolean if key is present (not null)
 * - keySet() returns a Set<K> based on all keys (not null)
 * - getSize() returns current size of the map
 * - remove(K key) removes key and value and returns value V
 */
import java.util.*;  //No using maps, but you can make a keySet
public class MapHash<K,V>
{
	public static final int DEFAULT_MAP_SIZE =  13000000;
	private int mapSize;
	private Object[] keys, vals;
	private int size;

	public MapHash(int capacity)
	{
		mapSize = capacity;
		keys = new Object[mapSize]; //Parallel Arrays based on
		vals = new Object[mapSize]; //hash index
		size=0;
	}

	public MapHash() { this(DEFAULT_MAP_SIZE); } //Set to default value

	private int hash(K s) { return Math.abs(s.hashCode()%mapSize); } //This is used to keep index values in range

	public V put(K key, V value)
	{
		int index = hash(key);
		V oldValue = null;
		if (keys[index]!=null) oldValue = (V)vals[index];
		else size++;
		keys[index] = key;
		vals[index] = value;
		return oldValue;
	}

	public V get(K key) { return (V)vals[hash(key)]; }

	public boolean containsKey(K key)
	{
		if (keys[hash(key)] == null) return false;
		else return true;
	}

	public Set<K> keySet()
	{
		Set<K> set = new HashSet<K>();
		for (int i=0; i<keys.length; i++)
			if (keys[i] != null) set.add((K)keys[i]);
		return set;
	}

	public int size() { return size; }

	public V remove(K key)
	{
		size--;
		int index = hash(key);
		V value = (V)vals[index];
		keys[index] = null;
		vals[index] = null;
		return value;
	}

	public static void main(String[]args)
	{
		MapHash<String,String> map = new MapHash<String,String>();
		map.put("Bachman Turner","Overdrive");
		map.put("Mad","Hatter");
		map.put("I love rock and roll","So put another dime in the jukebox baby");
		System.out.println(map.get("Bachman Turner"));
		System.out.println(map.get("Mad"));
		System.out.println(map.get("I love rock and roll"));

		System.out.println("\nKey Set:");
		for (String s: map.keySet())
		  	System.out.println(s);

		MapHash<Character,Integer> frq = new MapHash<Character,Integer>();
		String s = "This is a sentence, how many of each character does it have?";
		for (int i = 0; i < s.length(); i++){
			  Character c = s.charAt(i);
			  if (frq.containsKey(c)){
					frq.put(c,frq.get(c)+1);
			  }
			  else
					frq.put(c,1);
		}

		// Print Frequency Table
		System.out.println("Original Freq Table, size = "+frq.size());
		for (Character c: frq.keySet())
		  	System.out.println(c+" -> "+frq.get(c));

		// Remove Spaces and keys that occur exactly 3 times
		frq.remove(' ');

		for (Character c: frq.keySet())
		  	if (frq.get(c) == 3)
			  	frq.remove(c);

		System.out.println("\nAdjusted Freq Table, size = "+frq.size());
		for (Character c: frq.keySet())
      		System.out.println(c+" -> "+frq.get(c));
	}

}