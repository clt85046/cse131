package imageprocessor;

import java.util.NoSuchElementException;

import javax.swing.JLabel;



/**Created by Logan Sorrentino on 6/19/2012**/

public class DoublyLinkedList implements java.io.Serializable {

	private int size;
	private PicListItem head; //First list item
	private PicListItem tail; //Last list item
	public boolean tailNext;

	public DoublyLinkedList(){
		size=0;
		head= new PicListItem(null, -2);
		tail= new PicListItem(null, -1);
		tail.next= null;
		tail.prev=head;
		head.next=tail;
		head.prev=null;
	}

	private void incrementSize(){
		size++;
	}
	
	private void decrementSize(){
		size--;
	}

	public int getSize(){
		return size;
	}
	
	public PicListItem getHead(){
		return head;
	}
	
	public PicListItem getTail(){
		return tail;
	}
	

	public void add(PicListItem listItem){
		PicListItem temp= tail.prev;
		temp.next=listItem;
		listItem.prev=temp;
		listItem.next=tail;
		tail.prev=listItem;
		incrementSize();
			
	}
	
	public void remove(PicListItem listItem){
//		PicListItem l = head.next;
//		while(l != listItem){
//			if(l==tail){
//				System.out.println("Remove unsuccessful.");
//				return;
//			}
//			listItem = listItem.next;
//		}
//		l.prev.next= l.next;
//		l.next.prev= l.prev;
//		decrementSize();
		listItem.prev.next=listItem.next;
		listItem.next.prev=listItem.prev;
		decrementSize();
	}
	
	public PicListItem find(int ID){
		PicListItem l = head.next;
		while( ID!=(l.getID())){ 
			l = l.next;
			if(l==null){
				throw new NoSuchElementException();
			}
		}
		return l;
	}


	public String readList(){
		int i=0;
		String list="";
		if(size>0){
			PicListItem temp= tail.next;
			while(i<size){
				list+= "List item (" + i + ") is:" + temp.file;
				temp=temp.next;
			}
		}
		return list;
	}


}
