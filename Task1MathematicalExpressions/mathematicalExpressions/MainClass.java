package mathematicalExpressions;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
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
					if(i!=0) {
						if(Character.isDigit(exps[i-1])||Character.isLetter(exps[i-1])) {
							System.out.println("Input invalid, please input the value again");
							valid = false;
							counter = 1000;
							break;
						}
					}
				}
				if (exps[i] == ')') {
					counter--;
					if(i!=exps.length-1) {
					if(Character.isDigit(exps[i+1])||Character.isLetter(exps[i+1])) {
						System.out.println("Input invalid, please input the value again");
						valid = false;
						counter = 1000;
						break;
					}
					}
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
        for(int j = 0;j<exps.length;j++) {
        	if(Character.isLetter(exps[j])) {
        		String number;
        		try {
	        		System.out.println("Please input the value of '"+exps[j]+"':");
	        		number = sc.nextLine();
	        		char temp =number.charAt(0);
	        		if(!Character.isDigit(temp))
	        			throw new Exception();
	        		exps[j] = temp;
        		} catch(Exception e) {
        			System.out.println("Invalid value, program stop!");
        			return;
        		}
        	}
        }
       Tree tree = new Tree();
       tree.creatingTree(exps);
//       for(int i =0;i<tree.number.size();i++) {
//    	   System.out.println(tree.number.pop().getData());
//       }
	}
}
