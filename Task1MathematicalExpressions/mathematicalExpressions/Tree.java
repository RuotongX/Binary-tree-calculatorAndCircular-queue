package mathematicalExpressions;

public class Tree {
	private void creatingTree(TNode tree, char[] exps) {
		int starter = 0;
		int ender = 0;
		int counter = 0;
		TNode parent = new TNode();
		int i = 0;
		while(i<exps.length) {
			tree.setValue(exps[i]);
			char depender = exps[i];
			if(Character.isDigit(exps[i])) {
				depender = '0';
			}
			switch(depender) {
			case '*':
			case '/':
			case '+':
			case '-':
			case '(':
				if(parent.hasleft()) {
					TNode right = new TNode(exps[i+2],parent);
					parent.setRight(right);
					TNode left = new TNode(exps[i+1],right);
					right.setLeft(left);
					left.setLeft(tree);
					tree.setParent(left);
					TNode rightr = new TNode(exps[i+3],right);
					right.setRight(rightr);
					tree = 
				} else {
					parent.setLeft(tree);
					tree = parent;
				}
//			case ')':
//				TNode right = tree;
//				parent.setRight(right);
//				tree = parent;
			case '0':
				
		}
			i++; 
//			tree = createBracket(tree, exps, starter);
//			for(int j= starter;j>0;j--) {
//				TNode le = (exps[j],tree);
//				tree = getleftnode(tree);
//				tree.setLeft(le);
//			}
//			for(int k = ender;k>exps.length;k++) {
//				tempexps[starter+k-ender] = exps[k];
//			}
//			counter--;
//			creatingTree
//		}
//
	}

//	private TNode createBracket(TNode tree, char[] exps, int i) {
//		tree.left = new TNode('(', tree);
//		tree.setValue(exps[i + 1]);
//		TNode parent = new TNode();
//		parent.setValue(exps[i + 2]);
//		tree.setParent(parent);
//		TNode right = new TNode('0', parent);
//		i = i + 4;
//		char temp = exps[i];
//		if (temp == ')') {
//			right.setValue(exps[i - 1]);
//			TNode rl = new TNode(')', parent);
//			parent.setRight(right);
//			right.setRight(rl);
//		} else {
//			while (temp != ')') {
//				right.setValue(exps[i]);
//				TNode leftleaf = new TNode(exps[i - 1], right);
//				parent.setRight(right);
//				right.setLeft(leftleaf);
//				TNode rightleaf;
//				if (exps[i + 2] != ')') {
//					rightleaf = new TNode(exps[i + 2], right);
//				} else {
//					rightleaf = new TNode(')', right);
//				}
//				right.setRight(rightleaf);
//				temp = exps[i + 2];
//				i = i + 2;
//				parent = right;
//			}
//		}
//		return right;
//	}
//
//	private TNode getleftnode(TNode node) {
//		while (node.hasParent()) {
//			node = node.parent;
//		}
//		while (node.hasleft()) {
//			node = node.left;
//		}
//		return node;
	}
}
