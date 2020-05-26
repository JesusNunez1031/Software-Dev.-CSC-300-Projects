import java.io.*;
import java.util.*;

public class FileArrayDemo {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean flag = false;

        while (flag == false) {
            try {
                System.out.println("Enter the size of integer array: ");
                int size = input.nextInt();
                int[] inputNumbers = new int[size];
                int[] outputNumbers = new int[size];

                input.nextLine();

                System.out.println("Please enter the name of the .dat file you want to write to and then read from: ");
                String outputFile = input.nextLine();

                System.out.printf("Enter %d values of your choice into the array: ", size);
                for (int i = 0; i < size; i++) {
                    inputNumbers[i] = input.nextInt();
                }

                FileArray.writeArray(outputFile, inputNumbers);
                FileArray.readArray(outputFile, outputNumbers);

                System.out.println("Numbers read from file: ");
                for (int i = 0; i < size; i++) {
                    System.out.println(outputNumbers[i]);
                }

            } catch (InputMismatchException e) {
                flag = true;

            } catch (ArrayIndexOutOfBoundsException e) {

            } catch (NegativeArraySizeException e) {

            } catch (IOException e) {

            } finally {
                System.out.println("Program Completed");
            }
        }
    }
}