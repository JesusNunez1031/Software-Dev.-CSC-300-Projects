import java.util.*;
public class TestLLists
{
	public static void main(String [] args)
	{
		final int NUM_DATA = 100000;
		LList <Integer>linkList = new LList<Integer>();
		ArrayList <Integer>arrList = new ArrayList<Integer>();

		// First we will be inserting in the front
		//First for the Linked List
		long start = System.currentTimeMillis(); //for the LList
		for (int i = 0; i < NUM_DATA; i++)
			linkList.add(0,i);
		long elapsed = System.currentTimeMillis() - start;
		System.out.printf("Linked List when adding to front: %d ms\n", elapsed);

		//Now for the ArrayList
		start = System.currentTimeMillis(); // ArrayList
		for (int i = 0; i < NUM_DATA; i++)
			arrList.add(0, i );
		elapsed = System.currentTimeMillis() - start;
		System.out.printf("ArrayList adding to front: %d ms\n", elapsed);

		//Now we are inserting at the rear
		//First the Linked List
		linkList.clear();
		start = System.currentTimeMillis();
		for (int i = 0; i < NUM_DATA; i++)
			linkList.add(i);
		elapsed = System.currentTimeMillis() - start;
		System.out.printf("Linked List when adding to rear: %d ms\n", elapsed);

		//Now the ArrayList
		arrList.clear();
		start = System.currentTimeMillis(); // ArrayList
		for (int i = 0; i < NUM_DATA; i++)
			arrList.add(i);
		elapsed = System.currentTimeMillis() - start;
		System.out.printf("ArrayList when adding to rear: %d ms\n", elapsed);
	}
}
