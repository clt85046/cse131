package studio9;

import java.util.Iterator;

public class DoublyLinkedListOfInts implements IntList {
	private ListItem head,tail;
	private int size;
	
	/**
	 * constructor
	 */
	public DoublyLinkedListOfInts() {
		
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
	/**
	 * Tostring
	 */
	public String toString() {
		String ans = "[";
		// put the stuff in
		// this could be a "while" loop but let's use for
		//
		for (ListItem p = this.head; p != null; p = p.getNext()) {
			//System.out.println("sad "+p.getValue());
			ans = ans + p.getValue() + " ";
		}
		ans = ans + "]";
		return ans;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoublyLinkedListOfInts p = new DoublyLinkedListOfInts();
		p.addFirst(3);
		p.addFirst(2);
		p.addLast(4);
		p.addFirst(1);
		System.out.println("The list value is "+p);
		System.out.println("The reverse list is "+p.reverse());
		p.remove(1);
		p.remove(4);
		//System.out.println(p.size());
		System.out.println("After remove,the list value is "+p);
		p.iterator();
		
	}

	@Override
	/**
	 * 
	 */
	public Iterator<Integer> iterator() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	/**
	 * add value to the head of list
	 */
	public void addFirst(int item) {
		// TODO Auto-generated method stub
		ListItem node = new ListItem(item, null,null);
		
		if (this.size()== 0) {
			//   If the list is empty, just have head point to the
			//   new item
			this.head = node;
			this.tail = node;
		}
		else {
			// insert at the beginning
			
			// change what node points to, from null,
			//   to whatever our head points to
			node.setNext(this.head);
			this.head.setPrev(node);
			this.head = node;
		}
		// FIXME Auto-generated method stub
		

		
	}

	@Override
	/**
	 * add value to the tail of list
	 */
	public void addLast(int item) {
		// TODO Auto-generated method stub
		ListItem node = new ListItem(item, null,null);
		ListItem p = this.tail;
		if (this.size() == 0) {
			// then treat this as addFirst since it's the same thing
			this.addFirst(item);
			return;  // we are done
		}
		else{
			this.tail.setNext(node);
			node.setPrev(this.tail);
			this.tail = node;
		}
		
	}

	@Override
	/**
	 * return the size of list
	 */
	public int size() {
		// TODO Auto-generated method stub
		int ans = 0;
		for (ListItem p = this.head; p != null; p = p.getNext()) {
			ans = ans + 1;
		}
		return ans;
	}

	@Override
	/**
	 * find the index of list
	 */
	public int indexOf(int item) {
		// TODO Auto-generated method stub
		int ans = 0;
		for (ListItem p = this.head; p != null; p = p.getNext()) {
			if (p.getValue() == item)
				return ans;
			++ans;
		}
		return -1;
	}

	@Override
	/**
	 * remove value from list
	 */
	public boolean remove(int item) {
		// TODO Auto-generated method stub
		if (this.isEmpty())
			return false;
		
		// 2. the thing I want to remove happens to be the first
		//    thing in  the list
		
		// the list must be nonempty
		
		if (this.head.getValue() == item) {
			// make the head point to the next thing;
			this.head = this.head.getNext();
			return true;
		}
		
		ListItem p = this.head;
		while (p != tail) {
			// is the next item what I want?
			if (p.getNext().getValue() == item) {
				// get rid of it
				// p points around what it currently points to
				p.setNext(p.getNext().getNext());
				return true;
			}
			p = p.getNext();
		}
		return false;
	}

	@Override
	/**
	 * find if the list is empty
	 */
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.size() == 0;
	}

	@Override
	/**
	 * reverse the list
	 */
	public String reverse() {
		// TODO Auto-generated method stub
		String ans = "[";
		// put the stuff in
		// this could be a "while" loop but let's use for
		//
		for (ListItem p = this.tail; p != null; p = p.getPrev()) {
			
			ans = ans + p.getValue() + " ";
		}
		ans = ans + "]";
		return ans;
	}

}
