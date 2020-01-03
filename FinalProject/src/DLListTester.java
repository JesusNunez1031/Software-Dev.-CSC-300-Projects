import java.util.Random;
import java.util.Scanner;

public class DLListTester {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();
        /* Creating object of linkedList */
        DLList<Integer> list = new DLList<Integer>();
        System.out.println("Doubly Linked List Test\n");
        char ch;

        for (int i = 0; i < 10; i++) {
            list.add(rnd.nextInt(50) + 1);
        }
        /*  Perform list operations  */
        do {
            System.out.println("\nDoubly Linked List Operations\n");
            System.out.println("1. insert at beginning");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. check empty");
            System.out.println("6. get size");
            System.out.println("7. Set index to specific value");
            System.out.println("8. Get value from specified index");

            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter integer element to insert");
                    list.addAtStart(scan.nextInt());
                    break;
                case 2:
                    System.out.println("Enter integer element to insert");
                    list.add(scan.nextInt());
                    break;
                case 3:
                    System.out.println("Enter integer element to insert");
                    int num = scan.nextInt();
                    System.out.println("Enter position");
                    int pos = scan.nextInt();
                    if (pos < 1 || pos > list.size())
                        System.out.println("Invalid position\n");
                    else
                        list.add(num, pos);
                    break;
                case 4:
                    System.out.println("Enter position");
                    int p = scan.nextInt();
                    if (p < 1 || p > list.size())
                        System.out.println("Invalid position\n");
                    else
                        list.remove(p);
                    break;
                case 5:
                    System.out.println("Empty status = " + list.isEmpty());
                    break;
                case 6:
                    System.out.println("Size = " + list.size() + " \n");
                    break;
                case 7:
                    System.out.println("Enter the index to modify");
                    int indx = scan.nextInt();
                    if (indx < 0 || indx > list.size())
                        System.out.println("Invalid position\n");
                    else
                        System.out.println("Enter the value");
                    int val = scan.nextInt();
                    list.set(indx, val);
                    break;
                case 8:
                    System.out.println("Enter the index to get a value from");
                    int ind = scan.nextInt();
                    if (ind < 0 || ind > list.size())
                        System.out.println("Invalid position\n");
                    else
                        System.out.printf("The value of index %d is %d", ind, list.get(ind));
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
