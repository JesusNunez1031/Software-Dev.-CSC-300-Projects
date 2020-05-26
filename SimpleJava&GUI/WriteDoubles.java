import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;
import java.util.Scanner;

public class WriteDoubles {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        Random rand = new Random(5);
        double[] array = new double[15];

        for(int i = 0;i < array.length;i++){
            array[i] = rand.nextInt(100);
        }

        System.out.println("SampleIO");
        int counter = 1;
        for(double value : array) {
            System.out.println(counter + " " + value);
            counter += 1;
        }

        System.out.println("Enter the name of the Random Acess output file: ");
        String file = input.nextLine();
        
        RandomAccessFile outFile = new RandomAccessFile(file, "rw");

        System.out.println("Writing data to the file...");

        for(double value : array){
            outFile.writeDouble(value);
        }

        System.out.println("Done");
        outFile.close();
    }

}