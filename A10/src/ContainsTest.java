import java.util.Random;

public class ContainsTest {
    public static void main(String[] args) {
		TreeWithContains<Integer> tree = new TreeWithContains<Integer>();
		Random randy = new Random();
		for (int j = 0; j < 3; j++) {
			// create Objects to store in tree
			int totalNodes = randy.nextInt(99) + 20;
			System.out.printf("Will be inserting %d nodes\n", totalNodes);
			System.out.println("Inserting the following values: ");
			for (int i = 0; i < totalNodes; i++) {
				int number = randy.nextInt(100);
				System.out.printf("%d ", number);
				tree.insertNode(number);
			}
			System.out.println();
			int value = randy.nextInt(100);
			if(tree.contains(value)){
				System.out.printf("The tree contains %d", value);
			} else {
				System.out.printf("The tree does not contain %d", value);
			}
			System.out.printf("\n\n");
			tree.clearTree();
		}
	}
}
