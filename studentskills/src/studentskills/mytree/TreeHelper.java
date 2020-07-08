package studentskills.mytree;


import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TreeHelper {
	private List<Observer> observers = new ArrayList<Observer>();
	/* Class containing left and right child of current node and key value*/
	class Node implements SubjectI,Observer {
		int key;
		StudentRecord record;
		Node left, right;

		public Node(int item,StudentRecord value) {
			key = item;
			record= value;
			left = right = null;
		}

		@Override
		public void update() {

		}

		@Override
		public void register(Observer o) {

		}

		@Override
		public void unregister(Observer o) {

		}

		@Override
		public void notifyObserver() {

		}
	}
	// Root of BST
	Node root,root1,root2;


	// Constructor
	public TreeHelper() {
		root = null;
	}

	// This method mainly calls insertRec()
	public void insert(StudentRecord value) throws CloneNotSupportedException {

		StudentRecord record1 = (StudentRecord) value.clone();
		StudentRecord record2 = (StudentRecord) value.clone();
		root = insertRec(root, value);
		root1=insertRec(root1,record1);
		root2=insertRec(root2,record2);
	}

	/* A recursive function to insert a new key in BST */
	Node insertRec(Node root, StudentRecord value) {

		int key=value.bnumber;
		/* If the tree is empty, return a new node */
		if (root == null) {
			root = new Node(key,value);
			return root;
		}

		/* Otherwise, recur down the tree */
		if (key < root.record.bnumber) {
			root.left = insertRec(root.left, value);
		}
		else if (key > root.record.bnumber)
			root.right = insertRec(root.right, value);
		else if (key == root.record.bnumber) {
			root.record.bnumber = value.bnumber;
			root.record.firstname = value.firstname;
			root.record.lastname=value.lastname;
			root.record.gpa=value.gpa;
			root.record.major=value.major;
			root.record.skills.add(String.valueOf(value.skills));

		}

		/* return the (unchanged) node pointer */
		return root;
	}
	public void searchrec(int key) {

		root = search(root, key);
		System.out.println(root.record);
	}
	// A utility function to search a given key in BST
	public Node search(Node root, int key)
	{
		// Base Cases: root is null or key is present at root
		if (root==null || root.record.bnumber==key)
			return root;

		// val is greater than root's key
		if (root.record.bnumber > key)
			return search(root.left, key);

		// val is less than root's key
		return search(root.right, key);
	}


	// This method mainly calls InorderRec()
	public void inorder() {
		inorderRec(root);
	}

	// A utility function to do inorder traversal of BST
	void inorderRec(Node root) {
		if (root != null) {
			inorderRec(root.left);
			System.out.println(root.record);
			inorderRec(root.right);
		}
	}
}