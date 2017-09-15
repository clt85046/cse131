package exercises9;

public class SinglyLinkedList {
		private ListNode<Integer> head;
		
		public SinglyLinkedList(){
			this.head = null;
			
		}
		
		public void addFirst(int val){
			ListNode<Integer> i = new ListNode<Integer>(val);
			if(this.head == null){
				this.head = i;
			}
			else{
				this.head.next = i;
			}
		}
		
		public void addLast(int val){
			ListNode<Integer> i = new ListNode<Integer>(val);
			if (this.head == null){
				this.addFirst(val);
			}
			else{
				ListNode<Integer> p = head;
				while(p.next!= null){
					p = p.next;
				}
				p.next = i;
				
			}
			
		}
		
		public void remove(int val) {
			
			if(this.head ==null) {
				return;
			}
			else{
				if(this.head.value == val){
					this.head = head.next;
				}
				else{
					ListNode<Integer> p = head;
					while(p.next.value!= val){
						p = p.next;
					}
					p.next = p.next.next;
					
				}
			}
			
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyLinkedList p =new SinglyLinkedList();
		p.addFirst(11);
		p.addFirst(14);
		p.addFirst(15);
		p.addLast(33);
		//p.remove(14);
		System.out.println(p);
	}

	@Override
	public String toString() {
		String ans ="[";
		for (ListNode<Integer> p = head; p != null;p = p.next){
			ans+=p.value+" " ;
		}
		ans = ans +"]";
		return ans;
	}

}
