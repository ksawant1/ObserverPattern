package studentskills.mytree;

public class Tree<K extends Comparable, V> {

	/* Class containing left and right child of current node and key value*/
		TreeNode<K, V> root;


	/**
	 * if node is null it creates a new node at that position
	 * else recursively calls insertNode until it finds a null posiiton
	 * @param key
	 * @param value
	 */
	void insertNode(K key, V value) {
		/* If the tree is empty, return a new node */

		if (root == null)
			root = new TreeNode(key, value);
		else
			root.insert(root, key, value);
	}

	/**
	 * finds the key(bnumber) if present in tree
	 * calls the getNode() method
	 * @param key
	 * @return node
	 */
	public V getValue(K key) {
		TreeNode node = getNode(key);
		return node == null ? null : (V) node.value;
	}

	private TreeNode getNode(K key) {
		return root == null ? null : root.get(key);
	}

	// This method mainly calls inorder()
	public void inorder() {
		inorder(root);
	}

	public String getInOrderTree() {
		StringBuilder builder = new StringBuilder();
		inorder(builder, root);
		return builder.toString();
	}
	/**
	 * A utility function to do inorder traversal of Tree and print the node value
	 * @param node
	 */

	private void inorder(TreeNode node) {
		//System.out.println(root);
		if (node != null) {
			inorder(node.left);
			System.out.println(node.value);
			inorder(node.right);
		}
	}

	private void inorder(StringBuilder builder,TreeNode node) {
		if (node != null) {
			inorder(builder, node.left);
			builder.append(node.value);
			inorder(builder, node.right);
		}
	}
}


