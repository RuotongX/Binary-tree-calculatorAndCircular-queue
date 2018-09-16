package mathematicalExpressions;
import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String expression = null;
		char[] exps = null;
		System.out.println("Please input your Expression:");
		expression = sc.nextLine();
		exps = expression.toCharArray();
		for(int i = 0;i<exps.length;i++) {
			System.out.println(exps[i]);
		}
	}
}
//if (Character.isDigit(num[i]))