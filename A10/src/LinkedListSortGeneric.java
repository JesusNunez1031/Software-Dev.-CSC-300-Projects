import java.util.LinkedList;

public class LinkedListSortGeneric < E extends Comparable<E>> {
	PrintBackwardsLList<E> list;
    public void insertionSort(PrintBackwardsLList<E> list, int n) {
        // n is the number of data stored in array x
        for (int i = 1; i < n; i++)
            insert(list, i);
    }

    public  void insert(PrintBackwardsLList<E> list, int i) {
        // place x[i] in its proper place among sorted values x[0], x[1]...x[i-1]
        E temp = list.get(i); // save the value
        int j = i - 1;
        while (j >= 0 && temp.compareTo(list.get(j)) < 0) // determine where to place temp
        {
            list.set(j + 1, list.get(j)); //shift right
            j--;
        }
        list.set(j + 1, temp);
    }
}
