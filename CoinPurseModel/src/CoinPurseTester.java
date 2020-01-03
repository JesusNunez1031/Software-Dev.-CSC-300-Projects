import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoinPurseTester {

    public static void print(String text){
        System.out.println(text);
    }

    //Method to read in file and process purses
    public static void readFile(String file) throws IOException {
        //List to store the equality results
        List<String> eList = new ArrayList<>();

        try {
            //Read in File
            //Path path = Paths.get(file);
           // File doc = new File(file);
            Scanner input = new Scanner(new File(file));

            int numOfPurses = input.nextInt();  // Number of purses

            //Original Purse object, Purse 1 used to compare with other purses
            CoinPurse originalPurse = new CoinPurse(input.nextInt(), input.nextInt(), input.nextInt(), input.nextInt());

            //Purse object
            CoinPurse purse = new CoinPurse(0, 0, 0, 0);
            print("Number of Purses: " + numOfPurses);
            print("Coin purse 1 has the following coins and values: ");
            print(originalPurse.toString());
            print(originalPurse.moneyFromQuarters());
            print(originalPurse.moneyFromDimes());
            print(originalPurse.moneyFromNickels());
            print(originalPurse.moneyFromPennies());
            print(originalPurse.totalAmount());

            System.out.println();

            int i = 2;
            while (input.hasNextLine()) {
                print("Coin purse " + i + " has the following coins and values: ");
                purse.setQuarter(input.nextInt());
                purse.setDime(input.nextInt());
                purse.setNickel(input.nextInt());
                purse.setPenny(input.nextInt());
                print(purse.toString());
                print(purse.moneyFromQuarters());
                print(purse.moneyFromDimes());
                print(purse.moneyFromNickels());
                print(purse.moneyFromPennies());
                print(purse.totalAmount());
                eList.add("Purse 1 and Purse " + i + " are " + originalPurse.isEqual(purse));

                System.out.println();
                i++;
            }
            input.close();
        } catch(IOException exception) {
            print( "\u001B[31m" + exception + "\u001B[32m" + "\nFile path does not exist, please make sure the file path is correct in main method");
        }
        //Iterate through list of purses to print out equality
        for(int j = 0; j < eList.size();j++){
            print(eList.get(j));
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        print("Enter the name of the file to read from: " + "\u001B[32m" + "[.txt file extension is assumed] ");
        String file = input.nextLine();
        readFile(file + ".txt");
    }
}
