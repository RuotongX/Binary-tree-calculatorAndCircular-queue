package mathematicalExpressions;

import java.util.List;
import java.util.Stack;



public class Tree {
	private static TNode root=null;
	private static String postFixString="";//result of post order traverse 
	
	public static TNode TreeBuilder(String Str) // take a String in to Building processing
	{
		if (Str.length() >= 3) {
			TNode temp = buildProcess(Str, 0);// pass String to buildProcess
			root = temp;
			return temp;
		} else {
			System.out.println("Input error found");// input size less then 3, not able to form a smallest exp
			return null;
		}
	}

	// post:return a list of list of chars, which used for indicate level of the
	// operators
	private static List<List<Character>> getLevelIndicator() {
		return opeatorLevel;
	}

	// pre:a String contains expression and 0
	// post: a TNode with a complete tree stored a In Order expression
	private static TNode buildProcess(String str, int Level) {// tree building process

		if (str.isEmpty())// if a string is empty, return null
		{
			System.out.println("inputed String is empty, Calculate error Found!");
			return null;
		} else// if it is not empty then begin to procress string
		{

			if (bracketsClosedChecker(str))// if the input has any bracket is unclose
			{// if yes, it means all breaket is OK and closed ,will spear string to a smaller
				// sub string
				// E.g (a+b)+c
				// str1 a+b str2 c
				return buildProcess(str.substring(1, str.length() - 1), 0);// use sub string to process
			}

			if (Level == getLevelIndicator().size()) {// check what level it is ?
				return buildProcessVariableOrNumber(str);// process to check input is a variable or is a number
			}

			TNode tree = null;// make a empty TNode as root of a tree
			char operator = 0;// empty operator
			int beginIndex = 0;// Begin with the first index
			int depth = 0;// depth is use to make different layout for different operator event included
							// brackets
			for (int i = 0; i <= str.length(); i++) {
				boolean merge = false;
				char oldOperator = operator;

				if (i == str.length()) // if at the end deep haven't come up the top(or the root level of the tree)
										// it means some thing wrong druing the processing
				{
					if (depth != 0) {
						System.out.println("Error! TNode can not reach to the top level");
					}

					merge = true;// start merge to stop the error process
				} else {// if here is not the end of the processing
					char ch = str.charAt(i);// process the i character of the inputed String

					if (ch == '(') {
						depth++;// if found left bracket, make tree one more level deeper e.g
								// (a+b)+c
								// +
								// / \
								// + c depth go down
								// / \
								// a b
					} else if (ch == ')') {
						depth--;// found the end of bracket go back to normal level

						if (depth < 0) {
							System.out.println("Bracket processing error found!");// if depth <0, means it can not found
																					// the right bracket
						}
					} else if (depth == 0 && getLevelIndicator().get(Level).contains(ch)) {// found which level is the
																							// opeator
						operator = ch;
						merge = true;// make the operator as a root of a subtree
					}
				}

				if (merge) {// condition is OK to merge TNodes into a subtree
					TNode TNode = buildProcess(str.substring(beginIndex, i), Level + 1);

					if (tree == null) {
						tree = TNode;
					} else {
						TNode newTree = new TNode(oldOperator);

						newTree.left = tree;
						tree.parent = newTree;

						newTree.right = TNode;
						TNode.parent = newTree;

						tree = newTree;
					}

					beginIndex = i + 1;
				}
			}

			return tree;
		}
	}

	// pre: a subString from the String input
	// post: a boolean indicated bracket is closed or not
	private static boolean bracketsClosedChecker(String str) {// check bar
		if (!(str.startsWith("(") && str.endsWith(")"))) {
			return false;
		}

		int flag = 0;
		for (int i = 1; i < str.length() - 1; i++) {
			char ch = str.charAt(i);

			if (ch == '(') {
				flag++;
			} else if (ch == ')') {
				flag--;

				if (flag < 0) {
					return false;
				}
			}
		}
		return flag == 0;// if flag = 0, it is means it has same amount of ( and ) it is ok to be process
	}

	// pre: a subString from the input String
	// post a TreeTNode contains the value of the subString
	private static TNode buildProcessVariableOrNumber(String str) {
		if (str.length() != 1) {// error handle! if it is too big to process, return null and print error
								// massage
			System.out.println("Error catch! sub-String size is not smaller enough");
			return null;
		} else {
			char ch = str.charAt(0);// Converting a single letter String in to a processable char and check it is
									// variable
									// or number
			// ----------- using ASCII to check ----------
			if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
				char variable = ch;
				return new TNode(variable);// Set up data for a new TNode and return it back

			} else if (ch >= '0' && ch <= '9') {
				int number = ch - '0';// convert ASCII to integer
				return new TNode(number);// Set up data for a new TNode and return it back
			} else {
				System.out.println("Error found! no variable and no number !");
				return null;
			}
		}
	}

	// post:print InOrder Traverse
	public void printInOrderTraverse() {
		System.out.println("In-Order format: ");
		inOrderRecursion(root);
		System.out.println();
	}

	// post: print postOrder Traverse
	public void printPostOrderTraverse() {
		System.out.println("Post-Order format: ");
		postOrderRecursion(root);
		System.out.println();
	}

	// post: print preOrder Traverse
	public void printPreOrderTraverse() {
		System.out.println("Pre-Order format: ");
		preOrderRecursion(root);
		System.out.println();
	}

	// pre:a root TNode
	// post:print inOrder Traverse
	private static void inOrderRecursion(TNode TNode)// use recursion to print in order Traverse of the tree
	{
		if (TNode == null) {
			return;
		} else {
			inOrderRecursion(TNode.left);
			System.out.print(TNode.getData());
			inOrderRecursion(TNode.right);
		}
	}

	// pre:a root TNode
	// post:print postOrder Traverse
	private static void postOrderRecursion(TNode TNode)// use recursion to print post order Traverse of the tree
	{
		if (TNode == null) {
			return;
		} else {
			postOrderRecursion(TNode.left);
			postOrderRecursion(TNode.right);
			postFixString = postFixString + TNode.getData();
			System.out.print(TNode.getData());
		}
	}

	// pre:a root TNode
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
