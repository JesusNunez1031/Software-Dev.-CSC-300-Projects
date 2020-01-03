import java.util.*;

public class ArrayListSortGeneric <E extends Comparable<E>> {
    public void insertionSort(ArrayList<E> x, int n) {
        // n is the number of data stored in array x
        for (int i = 1; i < n; i++)
            insert(x, i);
    }

    public void insert(ArrayList<E> x, int i) {
        // place x[i] in its proper place among sorted values x[0], x[1]...x[i-1]
        E temp = x.get(i); // save the value
        int j = i - 1;
        while (j >= 0 && temp.compareTo(x.get(j)) < 0) // determine where to place temp
        {
            x.set(j + 1, x.get(j));
            j--;
        }
        x.set(j + 1, temp);
    }
}
