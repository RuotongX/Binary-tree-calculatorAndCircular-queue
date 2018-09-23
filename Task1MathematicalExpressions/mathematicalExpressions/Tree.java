package mathematicalExpressions;

import java.util.ArrayList;
import java.util.Stack;

/**
 * This class is used to create a binary tree, print them in different order and
 * calculate the result
 * 
 * @author RuotongXu
 *
 */
public class Tree {
	static String postString = "";
	TNode tree;
	ArrayList<TNode> element = new ArrayList();

	public Tree(char[] exps) {// This is the contractor of this class, which takes the input char array
								// becomes nodes into a arraylist
		for (int i = 0; i < exps.length; i++) {
			TNode temp = new TNode(exps[i]);
			element.add(temp);
		}
	}

	public TNode createtree() {// This method is used to create a binary tree, after the subtree created the
								// three leave are deleted, and the node which contains these three elements will be added into this array.
		int i = 0;
		for (int z = 0; z < element.size(); z++) {// The first loop is to find all brackets, make them to each sub tree
													// fist ,because they have the first priority
			if (element.get(i).getData() == ')') {
				element.remove(i);
				i--;
				ArrayList<TNode> brak = new ArrayList();
				while (element.get(i).getData() != '(') {
					brak.add(element.get(i));
					element.remove(i);
					i--;
				}
				TNode parent = this.bracket(brak);
				element.set(i, parent);
			}
			i++;
		}
		i = 0;
		for (int x = 0; x < element.size(); x++) {// The second loop is to find all multiple and divide operates, make
													// them to each sub tree ,because they have the second priority
			while (element.get(i).getData() == '*' || element.get(i).getData() == '/') {
				TNode left = element.get(i - 1);
				TNode right = element.get(i + 1);
				TNode parent = element.get(i);
				parent.setLeft(left);
				parent.setRight(right);
				left.setParent(parent);
				right.setParent(parent);
				element.set(i - 1, parent);
				element.remove(i);
				element.remove(i);
				if (i == element.size()) {
					break;
				}
			}
			i++;
		}
		i = 0;
		for (int y = 0; y < element.size(); y++) {
			while (element.get(i).getData() == '+' || element.get(i).getData() == '-') {// The third loop is to find all
																						// plus and minus operates, make
																						// them to each sub tree
																						// ,because they have the third
																						// priority
				TNode left = element.get(i - 1);
				TNode right = element.get(i + 1);
				TNode parent = element.get(i);
				parent.setLeft(left);
				parent.setRight(right);
				left.setParent(parent);
				right.setParent(parent);
				element.set(i - 1, parent);
				element.remove(i);
				element.remove(i);
				if (i == element.size()) {
					break;
				}
			}
			i++;
			tree = element.get(0);
		}

		return element.get(0);// Coz all other sub-tree becomes in to one tree so the array only have one
								// element

	}

	private TNode bracket(ArrayList<TNode> brak) {// This is used the same way as the createtree method to create the
													// sub tree in bracket, because it start from ')', so the loop start
													// from array size -1 to 0
		int i = brak.size() - 1;
		for (int x = brak.size() - 1; x >= 0; x--) {
			while (brak.get(i).getData() == '*' || brak.get(i).getData() == '/') {
				TNode left = brak.get(i + 1);
				TNode right = brak.get(i - 1);
				TNode parent = brak.get(i);
				parent.setLeft(left);
				parent.setRight(right);
				left.setParent(parent);
				right.setParent(parent);
				brak.set(i - 1, parent);
				brak.remove(i);
				brak.remove(i);
				if (i == brak.size()) {
					break;
				}
			}
			i--;
			if (i == -1) {
				break;
			}
		}
		i = brak.size() - 1;
		for (int y = brak.size(); y >= 0; y--) {
			while (element.get(i).getData() == '+' || brak.get(i).getData() == '-') {
				TNode left = brak.get(i + 1);
				TNode right = brak.get(i - 1);
				TNode parent = brak.get(i);
				parent.setLeft(left);
				parent.setRight(right);
				left.setParent(parent);
				right.setParent(parent);
				brak.set(i - 1, parent);
				brak.remove(i);
				brak.remove(i);
				if (i == brak.size()) {
					break;
				}
			}
			i--;
			if (i == -1) {
				break;
			}
		}
		return brak.get(0);
	}

	public void result() {// Call the calculate method to work out the result and print it out.
		System.out.println("The result is: " + this.calculate(tree));

	}

	private double calculate(TNode tree) {// This method is used to get the String result from the post order and
											// convert the char to double value, check the operator and give the result out.
		if (tree == null) {
			return 0.0;
		}
		char[] exps = postString.toCharArray();
		Stack<Double> stack = new Stack<>();
		for (int i = 0; i < exps.length; i++) {
			if (Character.isDigit(exps[i])) {
				stack.push(Double.valueOf(exps[i] - '0'));
			} else {
				double left = stack.pop();
				double right = stack.pop();
				switch (exps[i]) {
				case '+':
					stack.push(right + left);
					break;
				case '-':
					stack.push(right - left);
					break;
				case '/':
					stack.push(right / left);
					break;
				case '*':
					stack.push(right * left);
					break;
				}
			}
		}
		return stack.pop();
	}

	// post:print InOrder Traverse
	public void printInOrderTraverse() {
		System.out.println("In-Order : ");
		inOrderRecursion(tree);
		System.out.println();
	}

	// // post: print postOrder Traverse
	public void printPostOrderTraverse() {
		System.out.println("Post-Order : ");
		postOrderRecursion(tree);
		System.out.println();
	}

	// // post: print preOrder Traverse
	public void printPreOrderTraverse() {
		System.out.println("Pre-Order : ");
		preOrderRecursion(tree);
		System.out.println();
	}

	// // post:print inOrder Traverse
	private static void inOrderRecursion(TNode TNode) {
		if (TNode == null) {
			return;
		} else {
			inOrderRecursion(TNode.left);
			System.out.print(TNode.getData());
			inOrderRecursion(TNode.right);
		}
	}

	// // post:print postOrder Traverse
	private static void postOrderRecursion(TNode TNode) {
		if (TNode == null) {
			return;
		} else {
			postOrderRecursion(TNode.left);
			postOrderRecursion(TNode.right);
			postString = postString + TNode.getData();
			System.out.print(TNode.getData());
		}
	}

	// post:print preOrder Traverse
	private static void preOrderRecursion(TNode TNode) {
		if (TNode == null) {
			return;
		} else {
			System.out.print(TNode.getData());
			preOrderRecursion(TNode.left);
			preOrderRecursion(TNode.right);
		}
	}
}
