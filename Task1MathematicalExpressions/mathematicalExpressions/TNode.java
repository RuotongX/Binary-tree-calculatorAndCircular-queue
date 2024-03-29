package mathematicalExpressions;
/**
 * This is the Node class which is used for tree class.
 * @author RuotongXu
 *
 * @param <E>
 */
public class TNode<E> {
	public E data;
	public TNode parent;
	public TNode left;
	public TNode right;
	
	public TNode() {
		data = null;
		parent = left = right = null;
	}
	public TNode(E input) {
		data = input;
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
	public E value() {
		return this.data;
	}
	public void setValue(E input) {
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
	
	public TNode getparent() {
		return parent;
	}
	public char getData() {
		char c = (Character)data;
		return c;
	}
}
