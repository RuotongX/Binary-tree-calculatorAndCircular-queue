package mathematicalExpressions;

public class TNode {
	public char data;
	public TNode parent;
	public TNode left;
	public TNode right;
	
	public TNode() {
		data = (Character) null;
		parent = left = right = null;
	}
	public TNode(char input,TNode p) {
		data = input;
		parent = p;
		left = right = null;
	}
	public TNode left() {
		return this.left;
	}
	public TNode right() {
		return this.right;
	}
	public TNode parent() {
		return this.parent;
	}
	public void setLeft(TNode Left) {
		this.left = Left;
	}
	public void setRight(TNode right) {
		this.right = right;
	}
	public void setParent(TNode parent) {
		this.parent = parent;
	}
	public char value() {
		return this.data;
	}
	public void setValue(char input) {
		this.data = input;
	}
	public boolean hasParent() {
		if(parent != null) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean hasleft() {
		if(left != null) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean hasright() {
		if(right != null) {
			return true;
		}
		else {
			return false;
		}
	}
}
