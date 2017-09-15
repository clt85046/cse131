package trees;

import java.util.NoSuchElementException;

import lab9.ListItem;

/**
 * Implements a Map as an ordered list of (key,value) pairs.
 * CSE131 Lab 9
 * @author
 * @version 1.0
 * Date:
 */

public class OrderedListMap<K extends Comparable<K>,V> implements Map<K,V> {

	private OrderedListMap<K,V> map,next;
	private K key;
	private V value;
	
	public OrderedListMap(K key, V value,OrderedListMap<K,V> next){
		this.next = next;
		this.key = key;
		this.value =value;
		
		
	}
	public OrderedListMap(){
		this.map = null;
	}
	
	public void put(K key, V value) {
		// TODO 	
		OrderedListMap<K,V> newlist = new OrderedListMap<K,V>(key,value,null);
		OrderedListMap<K,V> temp = map;
		if(map==null){
			map = newlist;
		}
		else{
			while(temp.next!=null){
				if(temp.next.key.compareTo(newlist.key)<0){
					temp = temp.next;
				}
				else{
					
					if(temp.next.key.compareTo(newlist.key)==0){
						temp.next.value = newlist.value; 
						break;
					}
					else{
						newlist.next =temp.next;
						temp.next = newlist;
						break;
					}
				}
			}
			if(temp.next == null){
				temp.next = newlist;
			}
		}
		
		 
	}

	public V get(K key) {
		// TODO 
		OrderedListMap<K,V> temp = map;
		while(temp != null){
			if(key.compareTo(temp.key)==0){
				return temp.value;
			}
			temp = temp.next;
		}
		throw new NoSuchElementException();
	}

	public boolean contains(K key) {
		// TODO 
		OrderedListMap<K,V> temp = map;
		while(temp != null){
			if(key.compareTo(temp.key)==0){
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public boolean remove(K key) {
		// TODO 
		if(!contains(key)){
			return false;
		}
		OrderedListMap<K,V> temp = map;
		if(temp.key.compareTo(key) == 0){
			temp =temp.next;
			return true;
		}
		while(temp.next != null){
			if(temp.next.key.compareTo(key)==0){
				temp.next =temp.next.next;
				return true;
			}
			temp = temp.next;
		}
		return false;
	}
	
	public String toString() {
		// TODO 
		OrderedListMap<K,V> temp = map;
		while(temp.next!=null){
			System.out.println("Key is "+temp.key+" value is "+temp.value);
			temp=temp.next;
		}
		return " ";
	}


}
