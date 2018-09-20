package mathematicalExpressions;

import java.util.Stack;

public class Tree {
	Stack<TNode> number = new Stack<TNode>();
	Stack<TNode> operator = new Stack<TNode>();
	public TNode creatingTree(char[] exps) {
		operator.push(new TNode('#', null, null, null));
		for (int i = 0; i < exps.length; i++) {
			if (Character.isDigit(exps[i])) {
				number.push(new TNode(exps[i], null, null, null));
				continue;
			}
			if (isOperator(exps[i]) || exps[i] == '(') {
				Character top = operator.get(operator.size()-1).getData();
				while(getPriority(top,exps[i])<0){
					if(top == '#') {
						return number.pop();
					}
					TNode temp = operator.pop();
					TNode right = number.pop();
					TNode left = number.pop();
					temp.setLeft(left);
					temp.setRight(right);
					number.push(temp);
					top = operator.get(operator.size()-1).getData();
				}
				operator.push(new TNode(exps[i],null,null,null));
				continue;
			}
			if(exps[i] == ')') {
				Character top = (Character) operator.get(operator.size()-1).getData();
				while(top!='(') {
					TNode temp = operator.pop();
					TNode right = number.pop();
					TNode left = number.pop();
					temp.setLeft(left);
					temp.setRight(right);
					number.push(temp);
					top = operator.get(operator.size()-1).getData();
				
				}
				operator.pop();
				continue;
			}
		}
		return null;
	}

	private boolean isOperator(char c) {
		if(c=='*'||c=='+'||c=='/'||c=='-') {
			return true;
		}
		else {
			return false;
		}
	}
	private int getPriority(char top,char input) {
		if(input =='*'||input =='/') {
			if(top == '+'||top=='-') {
				return 1;
			}
			else {
				return -1;
			}
		} 
		else {
			return -1;
		}
	}
}
