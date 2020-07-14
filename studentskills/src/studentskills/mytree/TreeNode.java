package studentskills.mytree;

/**
 * when passed a generic key value pair will insert or search for the key in the given tree
 * @param <K>
 * @param <V>
 */
public class TreeNode<K extends Comparable, V> {
	K key;
	V value;
	TreeNode left;
	TreeNode right;

	//this is default implementation for root node
	public TreeNode(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public TreeNode(K key, V value, TreeNode left, TreeNode right) {
		this.key = key;
		this.value = value;
		this.left = left;
		this.right = right;
	}

	/* A recursive function to insert a new key in Tree*/
	TreeNode insert(TreeNode node, K key, V value) {
		if (node == null) {
			node = new TreeNode<>(key, value, null, null);
			return node;
		}
		/* Otherwise, recur down the tree */
		if (node.key.compareTo(key) > 0) {
			node.left = insert(node.left, key, value);
		} else if (node.key.compareTo(key) < 0)
			node.right = insert(node.right, key, value);
		else
			node.value = value;

		return node;
	}
// to search in tree
	TreeNode get(K key) {
		if (this.key.compareTo(key) < 0)
			return left == null ? null : left.get(key);
		else if (this.key.compareTo(key) > 0)
			return right == null ? null : right.get(key);
		else
			return this;
	}
}
