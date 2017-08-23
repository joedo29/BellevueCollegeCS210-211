 /* 
  * Phuong Do (Joe)
  * Date: August 02, 2017
  * Course: CS211
  * Assignment #17
  * Purpose: work with the provided SearchTree.java to solve some exercises in BJP book: #7, #9, #12, and 
  * modify the remove() method (in the powerpoint) to make it work with SearchTree 
  */ 

// Class SearchTree stores and prints a binary search tree of
// objects of type E.  E must implement the Comparable<E>
// interface.  from Reges and Stepp, BJP 3ed.
// modified by W.P. Iverson, to not allow duplicates added
// Bellevue College, November 2015

public class SearchTree<E extends Comparable<E>> {
	private SearchTreeNode<E> overallRoot; // root of overall tree

	// post: constructs an empty search tree
	public SearchTree() {
		overallRoot = null;
	}

	// WRITE ADDITIONAL METHODS HERE:

	// Exercise #7
	// isFull method returns true if a binary tree is full and false if it is not
	public boolean isFull() {
		return isFull(overallRoot); // recursive case
	}

	// begin helper method isFull
	private boolean isFull(SearchTreeNode node) {
		if(node == null){ // empty tree is full
			return true;
		}
		if(node.left != null && node.right == null){ // return false if right node is missing
			return false;
		}
		if(node.left == null && node.right != null){ // return false if left node is missing
			return false;
		}
		return isFull(node.right) && isFull(node.left);
	} // closes isFull helper method

	
	// Exercise #9
	// equals method accepts another binary tree of integers as a parameter and compares
	// the two trees to see whether they are equal to each other
	public boolean equals(SearchTree<E> node) {
		return equals(overallRoot, node.overallRoot);
	}

	// begin helper method
	private boolean equals(SearchTreeNode<E> firstTree, SearchTreeNode<E> secondTree) {
		if(firstTree == null && secondTree != null){ // a null tree and non-null tree are not equal
			return false;
		}
		if(firstTree != null && secondTree == null){ // a null tree and non-null tree are not equal
			return false;
		}
		if(firstTree == null && secondTree == null){ // two null trees are equal
			return true;
		}
		return  equals(firstTree.left, secondTree.left) && equals(firstTree.right, secondTree.right) && firstTree.data.compareTo(secondTree.data) == 0;
	} // closes equals helper method


	// Exercise #12
	// removeLeaves method removes the leaves from a tree
	// if the method called on an empty tree, it does nothing because there are no nodes of any kind 
	public void removeLeaves() {
		overallRoot = removeLeaves(overallRoot); // recursive case
	}

	// begin helper method
	private SearchTreeNode<E> removeLeaves(SearchTreeNode<E> tree) {
		if(tree == null){ // null tree has nothing to remove so return null
			return null;
		}
		if(tree.left == null && tree.right == null){ // return null when root is the only node of a tree
			return null;
		}
		tree.right = removeLeaves(tree.right); // remove right node
		tree.left = removeLeaves(tree.left); // remove left node
		return tree;
	} // closes removeLeaves helper method


	// Building Java Programs: A Back to Basics Approach, 4th edition
	// by Stuart Reges and Marty Stepp
	// Supplements, 4th edition
	// http://www.buildingjavaprograms.com/supplements4.shtml
	// Method remove() removes a given element from the tree
	// Method remove() was edited by Phuong Do to work with SearchTree
	public void remove(E value) {
		overallRoot = remove(overallRoot, value);
	}

	// begin helper method
	private SearchTreeNode<E> remove(SearchTreeNode<E> root, E value) {
		if (root == null) {
			return null;
		} else if (root.data.compareTo(value) == 1) {
			root.left = remove(root.left, value);
		} else if (root.data.compareTo(value) == -1) {
			root.right = remove(root.right, value);
		} else {  // root.data == value; remove this node
			if (root.right == null) {
				return root.left;    // no R child; replace w/ L
			} else if (root.left == null) {
				return root.right;   // no L child; replace w/ R
			} else {
				// both children; replace w/ min from R
				root.data = getMin(root.right);
				root.right = remove(root.right, root.data);
			}
		}
		return root;
	} // closes remove's helper method 


	// Phuong Do (Joe) version
	// getMin method for remove method
	private E getMin(SearchTreeNode<E> root) {
		if(root.left == null){
			return root.right.data;
		}
		if(root.right == null){
			return root.left.data;
		} else{
			return root.left.data;
		}

	} // closes getMin method


	// Building Java Programs: A Back to Basics Approach, 4th edition
	// by Stuart Reges and Marty Stepp
	// post: prints the tree contents, one per line, following an
	//       inorder traversal and using indentation to indicate
	//       node depth; prints right to left so that it looks
	//       correct when the output is rotated.
	public void printSideways() {
		printSideways(overallRoot, 0);
	}

	// post: prints in reversed preorder the tree with given
	//       root, indenting each line to the given level
	private void printSideways(SearchTreeNode root, int level) {
		if (root != null) {
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("    ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	} // closes printSideway method








	// post: value added to tree so as to preserve binary search tree
	public void add(E value) {
		overallRoot = add(overallRoot, value);
	}

	// post: value added to tree so as to preserve binary search tree
	private SearchTreeNode<E> add(SearchTreeNode<E> root, E value) {
		if (root == null) {
			root = new SearchTreeNode<E>(value);
		} else if (root.data.compareTo(value) > 0) {
			root.left = add(root.left, value);
		} else if (root.data.compareTo(value) < 0) {
			root.right = add(root.right, value);
		}
		return root;
	}

	// post: returns true if tree contains value, returns false otherwise
	public boolean contains(E value) {
		return contains(overallRoot, value);
	}   

	// post: returns true if given tree contains value, returns false otherwise
	private boolean contains(SearchTreeNode<E> root, E value) {
		if (root == null) {
			return false;
		} else {
			int compare = value.compareTo(root.data);
			if (compare == 0) {
				return true;
			} else if (compare < 0) {
				return contains(root.left, value);
			} else {   // compare > 0
				return contains(root.right, value);
			}
		}
	}

	// post: prints the data of the tree, one per line
	public void print() {
		printInorder(overallRoot);
	}

	// post: prints the data of the tree using an inorder traversal
	private void printInorder(SearchTreeNode<E> root) {
		if (root != null) {
			printInorder(root.left);
			System.out.println(root.data);
			printInorder(root.right);
		}
	}

	private static class SearchTreeNode<E> {
		public E data;                   // data stored in this node
		public SearchTreeNode<E> left;   // left subtree
		public SearchTreeNode<E> right;  //  right subtree

		// post: constructs a leaf node with given data
		public SearchTreeNode(E data) {
			this(data, null, null);
		}

		// post: constructs a node with the given data and links
		public SearchTreeNode(E data, SearchTreeNode<E> left,
				SearchTreeNode<E> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

}
