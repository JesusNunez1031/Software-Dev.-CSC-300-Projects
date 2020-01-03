import java.util.Random;

public class DepthTest {
	public static void main(String[] args) {
		TreeWithDepth<Integer> tree = new TreeWithDepth<Integer>();
		Random randy = new Random();
		// create Objects to store in tree
		int totalNodes = randy.nextInt(100) + 20;
		System.out.printf("Will be inserting %d nodes\n\n", totalNodes);
		System.out.println("Inserting the following values: ");
		for (int i = 0; i < totalNodes; i++) {
			int number = randy.nextInt(100);
			System.out.printf("%d ", number);
			tree.insertNode(number);
		}

		System.out.printf("%n%nPreorder traversal%n");
		tree.preorderTraversal();
		System.out.printf("%n%ninorder traversal%n");
		tree.inorderTraversal();
		System.out.printf("%n%nPostorder traversal%n");
		tree.postorderTraversal();
		System.out.printf("%n%nTree has a depth of %d", tree.getDepth());
	}
}
