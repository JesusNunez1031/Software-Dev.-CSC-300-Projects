import java.util.Random;
import java.util.Scanner;

public class DequeTester {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        /* Creating object of linkedList */
        Deque<Integer> list = new Deque<>();
        System.out.println("Doubly Linked List Test\n");
        char ch;

        for (int i = 0; i < 10; i++) {
            list.addBack(rnd.nextInt(50) + 1);
        }
        /*  Perform list operations  */
        do {
            System.out.println("\nDoubly Linked List Operations\n");
            System.out.println("1. insert at beginning");
            System.out.println("2. insert at end");
            System.out.println("3. Remove front");
            System.out.println("4. Remove back");
            System.out.println("5. Peek front");
            System.out.println("6. Peek back");
            System.out.println("7. Get size");
            System.out.println("8. Check if empty");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.addFront(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to insert");
                    list.addBack(scan.nextInt());
                    break;
                case 3:
                    System.out.println(list.removeFront());
                    break;
                case 4:
                    System.out.println(list.removeBack());
                    break;
                case 5:
                    System.out.println(list.peekFront());
                    break;
                case 6:
                    System.out.println(list.peekBack());
                    break;
                case 7:
                    System.out.println(list.size());
                    break;
                case 8:
                    System.out.println(list.isEmpty());
                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }
            /*  Display List  */
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);

        } while (ch == 'Y' || ch == 'y');
    }
}

