package exercises9;

public class SinglyLinkedListWithSentinels {
	

	private ListNode<Integer> head;
	public SinglyLinkedListWithSentinels() {
		head = new ListNode<Integer>(7);
	}
	
	public void addFirst(int val){
		ListNode<Integer> p = new ListNode<Integer>(val);
		p.next = head.next;
		head.next = p;
	}
	
	public void addLast(int val){
		ListNode<Integer> p = new ListNode<Integer>(val);
		ListNode<Integer> q = head;
		while(q.next!=null){
			q = q.next;
		}
		q.next = p;
	}
	public String toString() {
		String ans ="[";
		for (ListNode<Integer> p = head.next; p != null;p = p.next){
			ans+=p.value+" " ;
		}
		ans = ans +"]";
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedListWithSentinels p =new SinglyLinkedListWithSentinels();
		p.addFirst(131);
		p.addFirst(132);
		p.addLast(33);
		//p.remove(14);
		System.out.println(p);
	}
	

}
