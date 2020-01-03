import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String args[]) {
        Random randy = new Random();
        for(int i = 0; i < 20;i++) {
            System.out.println(randy.nextInt((1000 - 10) + 1) + 10);
        }
    }
}
