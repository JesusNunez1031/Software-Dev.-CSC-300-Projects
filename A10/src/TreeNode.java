class TreeNode<E extends Comparable<E>> {
	TreeNode<E> leftNode; // similar to linked list
	E data;
	TreeNode<E> rightNode;

	// Constructor initializes data and makes a leaf node
	public TreeNode(E nodeData) {
		data = nodeData;
		leftNode = rightNode = null;// node has no children
	}

// locate insertion point and insert new node; ignore dup ] 1 11, 
	public void insert(E insertValue) {
		// insert in left subtree
		if (insertValue.compareTo(data) < 0) {
			// insert new TreeNode
			if (leftNode == null) {
				leftNode = new TreeNode<E>(insertValue);
			}

			else {
				// continue traversing left subtree recursively
				leftNode.insert(insertValue);

			}
		}
		// insert in right subtree
		else if (insertValue.compareTo(data) > 0) {
			// insert new TreeNode
			if (rightNode == null) {
				rightNode = new TreeNode<E>(insertValue);
			} else {
				// continue traversing right subtree recursively
				rightNode.insert(insertValue);
			}
		}
	}
}