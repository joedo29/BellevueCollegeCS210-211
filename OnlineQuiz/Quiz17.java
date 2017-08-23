/* 
 * Phuong Do (Joe)
 * Date: August 03, 2017
 * Course: CS211
 * Quiz 17
 * Purpose: A. slightStutter(); a public non-recursive method that changes this tree to add stutter nodes on the left 
 * when possible, otherwise add a stutter node on the right, but if both left and right are not null then the node cannot be stuttered.  See example below.
 * B. slightStutter(IntTreeNode root); a private recursive method helper, returns an IntTreeNode, that does the tree traversal 
 * and modification for public slightStutter
 */ 

// Simple binary tree class that includes methods to construct a
// tree of ints, to print the structure, and to print the data
// using a preorder, inorder or postorder traversal.  The trees
// built have nodes numbered starting with 1 and numbered
// sequentially level by level with no gaps in the tree.  The
// documentation refers to these as "sequential trees."
//
// from buildingjavaprograms.com


import java.util.*;

public class IntTree {
	private IntTreeNode overallRoot;

	// pre : max > 0
	// post: constructs a sequential tree with given number of
	//       nodes
	public IntTree(int max) {
		if (max <= 0) {
			throw new IllegalArgumentException("max: " + max);
		}
		overallRoot = buildTree(1, max);
	}

	public IntTree() {
		overallRoot = null;
	}

	// constructor added so we can build page 1029 reference trees
	public IntTree(IntTreeNode given) {
		overallRoot = given;
	}






	//Exercise #7, Chapter 17
	public boolean isFull() {
		return isFull(overallRoot);
	}

	private boolean isFull(IntTreeNode node) {
		if(node == null)
			return true;

		if(node.left == null && node.right != null)
			return false;

		if(node.left != null && node.right == null)
			return false;

		return isFull(node.left) && isFull(node.right);
	}
	//    public boolean isFull() {
	//    	return (overallRoot == null || isFull(overallRoot));
	//	}
	//
	//	private boolean isFull(IntTreeNode root) {
	//    		if(root.left == null && root.right == null) {
	//        		return true;
	//    		} else {
	//        		return (root.left != null && root.right != null && isFull(root.left) && isFull(root.right));
	//    		}
	//	}  









	// post: returns a sequential tree with n as its root unless
	//       n is greater than max, in which case it returns an
	//       empty tree
	private IntTreeNode buildTree(int n, int max) {
		if (n > max) {
			return null;
		} else {
			return new IntTreeNode(n, buildTree(2 * n, max),
					buildTree(2 * n + 1, max));
		}
	}

	// post: prints the tree contents using a preorder traversal
	public void printPreorder() {
		System.out.print("preorder:");
		printPreorder(overallRoot);
		System.out.println();
	}

	// post: prints the tree contents using a preorder traversal
	// post: prints in preorder the tree with given root
	private void printPreorder(IntTreeNode root) {
		if (root != null) {
			System.out.print(" " + root.data);
			printPreorder(root.left);
			printPreorder(root.right);
		}
	}

	// post: prints the tree contents using a inorder traversal
	public void printInorder() {
		System.out.print("inorder:");
		printInorder(overallRoot);
		System.out.println();
	}

	// post: prints in inorder the tree with given root
	private void printInorder(IntTreeNode root) {
		if (root != null) {
			printInorder(root.left);
			System.out.print(" " + root.data);
			printInorder(root.right);
		}
	}

	// post: prints the tree contents using a postorder traversal
	public void printPostorder() {
		System.out.print("postorder:");
		printPostorder(overallRoot);
		System.out.println();
	}

	// post: prints in postorder the tree with given root
	private void printPostorder(IntTreeNode root) {
		if (root != null) {
			printPostorder(root.left);
			printPostorder(root.right);
			System.out.print(" " + root.data);
		}
	}

	// post: prints the tree contents, one per line, following an
	//       inorder traversal and using indentation to indicate
	//       node depth; prints right to left so that it looks
	//       correct when the output is rotated.
	public void printSideways() {
		printSideways(overallRoot, 0);
	}

	// post: prints in reversed preorder the tree with given
	//       root, indenting each line to the given level
	private void printSideways(IntTreeNode root, int level) {
		if (root != null) {
			printSideways(root.right, level + 1);
			for (int i = 0; i < level; i++) {
				System.out.print("    ");
			}
			System.out.println(root.data);
			printSideways(root.left, level + 1);
		}
	} // closes printSideway method

	// equals method
	public boolean equals(IntTree t2) {
		return equals(overallRoot, t2.overallRoot);
	}

	// begin helper method
	private boolean equals(IntTreeNode n1, IntTreeNode n2) {
		if(n1 == null && n2 == null)
			return true;

		if(n1 == null && n2 != null)
			return false;

		if(n1 != null && n2 == null)
			return false;

		return n1.data == n2.data && equals(n1.left, n2.left) &&
				equals(n1.right, n2.right);
	} // closes equals method


	// begin add method
	public void add(int someValue)
	{
		add(overallRoot, someValue);
	}
	private IntTreeNode add(IntTreeNode someNode, int someValue)
	{
		//if the tree is empty, create root node
		if(someNode == null)
		{
			someNode = new IntTreeNode(someValue);
		}
		else if(someValue <= someNode.data)
		{
			//add left
			someNode.left = add(someNode.left, someValue);
		}
		else
		{
			//add right
			someNode.right = add(someNode.right, someValue);
		}

		return someNode;
	} // closes add method

	// 



	private int getMin(IntTreeNode root) {
		if(root.left == null){
			return root.right.data;
		}
		if(root.right == null){
			return root.left.data;
		} else{
			return root.left.data;
		}
	}
	// Removes the given value from this BST, if it exists.
	public void remove(int value) {
		overallRoot = remove(overallRoot, value);
	}

	// remove method
	private IntTreeNode remove(IntTreeNode root, int value) {
		if (root == null) {
			return null;
		} else if (root.data > value) {
			root.left = remove(root.left, value);
		} else if (root.data < value) {
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
	} // closes remove method 
	public void removeLeaves() {
		overallRoot = removeLeaves(overallRoot);
	}

	private IntTreeNode removeLeaves(IntTreeNode node) {
		if(node == null)
			return null;

		if(node.left == null && node.right == null)
			return null;

		node.left = removeLeaves(node.left);
		node.right = removeLeaves(node.right);
		return node;
	} // closes removeLeaves method

	// non-recursive method
	public void slightStutter() {
		overallRoot = slightStutter(overallRoot);
	} // closes slightSutter non-recursive method

	// helper method
	private IntTreeNode slightStutter(IntTreeNode root){
		if(root == null){
			return null;
		}

		if(root.left == null && root.right == null){
			return null;
		}
		add(root.right, root.right.data);
		add(root.left, root.left.data);

		return root;
	} // closes helper method


}