import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderIntegersWithArrayList {
    private static void print(String text) {
        System.out.println(text);
    }

    private static void readFile(String file) {
        //List to sort the values read in
        List<Integer> list = new ArrayList<>();
        try {
            //Read in File
            Scanner input = new Scanner(new File(file));

            //Check for empty Files
            if(!input.hasNextLine()) {
                throw new Exception();
            }
            list.add(input.nextInt());
            int i = 0;
            while (input.hasNextLine()) {
                int nextNum = input.nextInt();
                if(nextNum <= list.get(0)){
                    list.add(0,nextNum);
                } else {
                    for (i = list.size()-1; i >= 0; i--) {
                        if (nextNum >= list.get(i)) {
                            list.add(i+1, nextNum);
                            break;
                        }
                    }
                }
                i++;
            }
            input.close();
        } catch(IOException exception) {
            print( "\u001B[31m" + exception + "\u001B[32m" + "\nFile path does not exist, please make sure the file path is correct in main method");
        } catch (Exception e) {
            print("File entered is empty, enter a new file.");
        }
        print("Numbers in file sorted: \n" + list.toString());
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        print("Enter a file to read from: ");
        String file = input.nextLine();
        readFile(file);

    }
}
