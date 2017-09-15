package trees;

import java.util.NoSuchElementException;

/**
 * Implements a Map as a binary search tree of (key,value) pairs.
 * CSE131 Lab 9
 * @author
 * @version 1.0
 * Date:
 */

public class TreeMap<K extends Comparable<K>,V> implements Map<K,V> {
	TreeNode<K,V> head;
	String full = "";
	
	TreeMap(){
		this.head = null;
	}
		
		
	

	public void put(K key, V value) {
		// TODO
		TreeNode<K, V> node = new TreeNode<K,V>(key, value);
		TreeNode<K,V> m = head;
		
		if(head == null) {
			head = node;
		}
		else {
			boolean added = false;
			while(m.key.compareTo(key)!=0) {
				if(m.key.compareTo(key)>0) {
					if(m.left == null) {
						m.left = node;
						added = true;
						break;
					} 
					m = m.left;
				} 
				else {
					if(m.key.compareTo(key)<0) {
						if(m.right == null) {
							m.right = node;
							added = true;
							break;
						} 
						m = m.right;
					} 
				}
			}
			if(m.key.compareTo(key)==0) {
				m.value = node.value;
				added = true;
			} 
}
		
	}

	public V get(K key) {
		// TODO 
		TreeNode<K,V> m = head;
		boolean added = false;
		if(contains(key)==false)
			throw new NoSuchElementException();
		while(m.key.compareTo(key)!=0) {
			if(m.key.compareTo(key)>0) {
				if(m.left.key.compareTo(key)==0) {
					return m.left.value;
				} 
				m = m.left;					
			} 
			else {
				if(m.right.key.compareTo(key)==0) {
					return m.right.value;
				} 
				m = m.right;
			}
		}
		return m.value;
	}

	public boolean contains(K key) {
		// TODO 
		TreeNode<K,V> m = head;
		if(m.key.compareTo(key)==0)
			return true;
		while(m.key.compareTo(key)!=0) {
			if(m.key.compareTo(key)>0) {
				if(m.left == null)
					return false;
				if(m.left.key.compareTo(key)==0) {
					if(m.deleted == false)
						return true;
					else
						return false;
				} 
				m = m.left;					
			} 
			else if(m.key.compareTo(key)<0){
				if(m.right == null)
					return false;
				if(m.right.key.compareTo(key)==0)
					if(m.deleted == false)
						return true;
					else
						return false;
				m = m.right;
			}
		}
		return false;
	}

	public boolean remove(K key) {
		// TODO 
		head = remove(head, key);
		return true;
	}
	
	private TreeNode<K,V> remove(TreeNode<K,V> p, K key)
	{
		if (p == null)  
			throw new RuntimeException("Nothing in the list");
		else
			if (key.compareTo(p.key) < 0)
				p.left = remove(p.left, key);
			else if (key.compareTo(p.key) > 0)
				p.right = remove (p.right, key);
			else
			{
				if (p.left == null) 
					return p.right;
				else if (p.right == null) 
					return p.left;
				else
				{
					// get data from the rightmost node in the left subtree
					p.key = retrieveData(p.left);
					// delete the rightmost node in the left subtree
					p.left =  remove(p.left, p.key) ;
				}
			}
		return p;
}
	
	private K retrieveData(TreeNode<K, V> p)
	{
		while (p.right != null) 
			p = p.right;
		return p.key;
	}

	public String toString() {
		String tabs = "";
		tabs = HelperString(tabs, head);
		return tabs;
	}
	
	public String HelperString(String tabs, TreeNode<K,V> pointer){
		String holder = "";
		if(pointer.right != null){
			holder = holder + HelperString(tabs + '\t', pointer.right);
		}
		
		if(pointer.deleted == false)
			holder = holder +tabs  + "(" + pointer.key + " " + pointer.value + ")" + '\n';
		else
			holder = holder +tabs  + "()" + '\n';
		
		if(pointer.left != null){
			holder = holder + HelperString (tabs + '\t', pointer.left);
		}
		return holder;
		
}

}
