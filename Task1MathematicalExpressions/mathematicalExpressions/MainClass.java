package mathematicalExpressions;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		TNode tree = new TNode();
		Scanner sc = new Scanner(System.in);
		String expression = null;
		char[] exps = null;
		boolean valid = true;
		System.out.println("Please input your Expression:");
		do {
			int counter = 0;
			expression = sc.nextLine();
			expression = expression.replaceAll(" ", "");
			exps = expression.toCharArray();
			for (int i = 0; i < exps.length; i++) {
				if (exps[i] == '(') {
					counter++;
				}
				if (exps[i] == ')') {
					counter--;
				}
				if (counter < 0) {
					System.out.println("Input invalid, please input the value again");
					valid = false;
					counter = 1000;
					break;
				}
				if (exps[i] == '*' || exps[i] == '+' || exps[i] == '-' || exps[i] == '/') {
					if (i == exps.length - 1) {
						System.out.println("Input invalid, please input the value again");
						valid = false;
						counter = 1000;
						break;
					}
					if (exps[i + 1] == '*' || exps[i + 1] == '+' || exps[i + 1] == '-' || exps[i + 1] == '/'
							|| exps[i + 1] == ')') {
						valid = false;
						counter = 1000;
						System.out.println("Input invalid, please input the value again");
						break;
					}
				}
				if (Character.isLetter(exps[i])) {
					if (i == 0) {

					} else if (Character.isLetter(exps[i - 1])) {
						System.out.println("Input invalid, please input the value again");
						valid = false;
						counter = 1000;
						break;
					}
				}
				if (Character.isDigit(exps[i])) {
					if (i == 0) {

					} else if (Character.isDigit(exps[i - 1])) {
						System.out.println("Input invalid, please input the value again");
						valid = false;
						counter = 1000;
						break;
					}
				}
			}
			if (counter == 1000) {

			} else if (counter != 0) {
				System.out.println("Input invalid, please input the value again");
				valid = false;
			} else {
				valid = true;
			}
		} while (valid == false);
//		creatingTree(tree, exps);
	}
}
// private static TNode addLeaf(TNode tree,char[] exps,int i) {
// TNode leftleaf = new TNode(exps[i-1],tree);
// if(exps[i+2] !=')') {
// TNode rightleaf = new TNode(exps[i+2],tree);
// tree.setLeft(leftleaf);
// tree.setRight(rightleaf);
// return rightleaf;
// }
// }
// if (Character.isDigit(num[i]))

// tree = createBracket(tree,exps,i);
// if(exps[i+3] =='(') {
// TNode rightside = new TNode();
// rightside = createBracket(rightside,exps,i+3);
// }