import java.util.*;

public class ArrayListSortGenericTester {

    public static String generateRandomString(int n) {
        int lowerLimit = 65;
        int upperLimit = 90;

        Random rand = new Random();

        StringBuffer r = new StringBuffer(n);

        for (int i = 0; i < n; i++) {
            int nextRandomChar = lowerLimit + (int) (rand.nextFloat() * (upperLimit - lowerLimit + 1));

            r.append((char) nextRandomChar);
        }
        return r.toString();
    }

    public static <E extends Comparable<E>> void main(String[] args) {
        long timeStart, timeEnd, totalTime;
        Scanner keyboard = new Scanner(System.in);
        ArrayListSortGeneric<E> insertSortAL = new ArrayListSortGeneric<>();
        System.out.print("Enter the size of the array: ");
        int size = keyboard.nextInt();

        ArrayList<Integer> numbers = new ArrayList<>(size);
        ArrayList<String> strings = new ArrayList<>(size);

        // Create the integers
        Random randy = new Random();
        for (int i = 0; i < size; i++)
            numbers.add(randy.nextInt(2000));

        // Create the strings
        for (int i = 0; i < size; i++) {
            String str = generateRandomString(3);
            strings.add(str);
        }
        System.out.print("\n");

        timeStart = System.currentTimeMillis();
        insertSortAL.insertionSort((ArrayList<E>) numbers, size);
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for the sort of numbers is %d millisecs\n", totalTime);
        System.out.print("Sorted: ");
        for (int i = 0; i < size; i++)
            System.out.printf("%s ", numbers.get(i));
        System.out.print("\n\n");

        timeStart = System.currentTimeMillis();
        insertSortAL.insertionSort((ArrayList<E>) strings, size);
        timeEnd = System.currentTimeMillis();
        totalTime = timeEnd - timeStart;
        System.out.printf("The total time for the sort of strings is %d millisecs\n", totalTime);
        System.out.print("Sorted: ");
        for (int i = 0; i < size; i++)
            System.out.printf("%s ", strings.get(i));
        System.out.print("\n");
    }
}
