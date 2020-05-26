import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class ReadRandomDoubles {

    public static void main(String[] args) throws IOException {
        boolean flag = false;
        Scanner input = new Scanner(System.in);
        String file = "";

        while(!flag) {
            try {
                System.out.println("Enter the name of the file: ");
                file = input.nextLine();

                RandomAccessFile inFile = new RandomAccessFile(file, "r");

                for(int i = 0;i < 15;i++) {
                    double value = inFile.readDouble();
                    if(i == 2) {
                    System.out.println("Third entry is " + " " + value);
                    }
                    if(i == 5){
                        System.out.println("Sixth entry is " + " " + value);
                    }
                    if(i == 7) {
                        System.out.println("Eigth entry is " + " " + value);
                    }
                }
                inFile.close();

            } catch (FileNotFoundException e){
                System.out.println("File " + file + " was not found");
                System.out.println("Please renter: ");
                file = input.nextLine();
            }finally {
                flag = true;
            }

        }
    }

}