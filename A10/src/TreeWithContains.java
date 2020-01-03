// class Tree definition

public class TreeWithContains<E extends Comparable<E>> {
    private TreeNode<E> root;

    // constructor initializes an empty Tree of integers
    public TreeWithContains() {
        root = null;
    }

    // insert a new node in the binary search tree
    public void insertNode(E insertValue) {
        if (root == null) {
            root = new TreeNode<E>(insertValue); // create root node
        } else {
            root.insert(insertValue); // call the insert method
        }
    }

    //Helper method to recursively find a node
    public boolean containsNodeHelper(TreeNode<E> node, E value) {
        if (node == null) {
            return false;
        }

        if (value.compareTo(node.data) == 0) {
            return true;
        }

        return value.compareTo(node.data) < 0 ? containsNodeHelper(node.leftNode, value) : containsNodeHelper(node.rightNode, value);
    }

    public boolean contains(E value) {
        return containsNodeHelper(root, value);
    }

    // Clear tree by setting root to null, java garbage collector automatically clears all objects with no references
    public void clearTree() {
        root = null;
    }
}
