package trees;

public class TreeNode<K extends Comparable<K>,V>{
	K key;
	V value;
	TreeNode<K, V> left;
	TreeNode <K, V> right;
	boolean deleted;
		
	/**
	 * Creates a single list item.
	 * @param number the value to be held in the item
	 * @param next a reference to the next item in the list
	 */
	TreeNode(K key, V value) {
		this.key = key;
		this.value   = value;
		this.left = null;
		this.right = null;
		boolean deleted = false;
	}
	
//	public boolean contains(int x){
//		
//		return false;
//	}
		
}