package business;

public class BinomialTree {

	public BinomialTree(double volatility, double rate, int time, int periods) {
		this.periods = periods;
		deltaT = (double)time / (double)periods;
		up = Math.exp(Math.sqrt(deltaT) * volatility);
		down = 1 / up;
		double p = Math.exp(rate*deltaT) - down / (up - down);
		p0 = Math.exp(-rate * deltaT) * p;
		p1 = Math.exp(-rate * deltaT) * (1 - p);
	}
	
	public void americanCall() {
		BinomialTreeNode curr = root;
		Money zero = new Money(0);
		while(curr.left != null)
		{
			curr = curr.left;
		}
		
		for(int i = 0; i < periods+1; i++) {
			if(curr.value.minus(strike).compareTo(zero) <= 0);
			curr.value = zero;
		}
		
		
	}
	
	public void americanPut() {

	}
	
	public void europeanCall() {
		BinomialTreeNode curr = root;
		Money zero = new Money(0);
		while(curr.left != null)
		{
			curr = curr.left;
		}
		
		for(int i = 0; i < periods+1; i++) {
			if(curr.value.minus(strike).compareTo(zero) <= 0);
			curr.value = zero;
		}
	}
	
	public void europeanPut() {
		BinomialTreeNode curr = root;
		Money zero = new Money(0);
		while(curr.left != null)
		{
			curr = curr.left;
		}
		
		for(int i = 0; i < periods+1; i++) {
			if(strike.minus(curr.value).compareTo(zero) <= 0);
			curr.value = zero;
		}
	}
	
	public void calculateValues(boolean call, boolean american) {
		BinomialTreeNode curr, row = root;
		Money comp, zero = new Money(0);
		
		while(row.left != null)
		{
			row = row.left;
		}
		
		for(int i = 0; i <= periods; i++) 
		{
			curr = row;
			for(int j = periods - i; j >= 0; j--) 
			{
				
				if(call) 
					comp = curr.value.minus(strike);
				else 
					comp = strike.minus(curr.value);
				if(i == 0)
				{
					if(comp.compareTo(zero) <= 0)
						curr.value = zero;
				}
				else
				{
					curr.value = curr.left.value.times(p0).plus(curr.right.value.times(p1));
					
					if(american)
						if(comp.compareTo(curr.value) > 0)
							curr.value = comp;
				}
			}
		}
		row = row.parentRight;
	}
	
	public void buildTree(Money stock, Money strike) {
		this.stock = stock;
		this.strike = strike;
		
		BinomialTreeNode curr, temp;
		root = new BinomialTreeNode(stock, null, null, null, null);
		
		for(int i = 0; i < periods; i++)
		{
			int j = 0;
			curr = root;
			while (j < i)
			{
				curr = curr.left;
				j++;
			}
			
			curr.left = new BinomialTreeNode(curr.value.times(down), null, null, null, curr);
			temp = new BinomialTreeNode(curr.value.times(up), null, null, curr, null);
			curr.right = temp;
			while(curr.parentRight != null) 
			{
				curr = curr.parentRight.right;
				temp.parentRight = curr;
				curr.left = temp;
				curr.right = new BinomialTreeNode(curr.value.times(up), null, null, curr, null);
				temp = curr.right;
			}
		}
	}
	
	public void rebuildTree() {
		buildTree(stock, strike);
	}
	
	public String toString() {
		return inOrder(root, 0);
	}
	
	public String inOrder(BinomialTreeNode node, int depth) {
		String result = "";
		String spacer = "";
		for(int i = 0; i < depth; i++)
		{
			 spacer += "\t";
		}
		if(node.left == null)
		{
			//result += spacer + "\t()\n";
			result += spacer + "(" + node.value.toString() + ")\n";
			if(node.right != null)
			{
				result += inOrder(node.right, depth + 1);
			}
			//else
				//result += spacer + "\t()\n";
		}
		else
		{
			if(node.parentLeft == null)
				result += inOrder(node.left, depth + 1);
			result += spacer + "(" + node.value.toString() + ")\n";
			if(node.right != null)
			{
				result += inOrder(node.right, depth + 1);
			}
			//else
				//result += spacer + "\t()\n";
		}
		return result;
	}
	
	private double deltaT, up, down, p0, p1;
	private int periods;
	private BinomialTreeNode root;
	private Money stock, strike;
	
	public static void main(String args[]) {
		BinomialTree bt = new BinomialTree(.40, .05, 1, 4);
		bt.calculateValues(true, true);
		System.out.println(bt);
	}
}

