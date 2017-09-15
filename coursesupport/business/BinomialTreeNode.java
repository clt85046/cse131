package business;

public class BinomialTreeNode {

	public BinomialTreeNode(Money value, BinomialTreeNode left, BinomialTreeNode right, BinomialTreeNode parentLeft, BinomialTreeNode parentRight) {
		
		this.left = left;
		this.right = right;
		this.parentLeft = parentLeft;
		this.parentRight = parentRight;
		this.value = value;
	}
	
	public Money value;
	public BinomialTreeNode left, right, parentLeft, parentRight;
}
