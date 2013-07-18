class SList
{
	public SNode head;
	public SList(){
		head = null;
	}
	public SList(SNode n){
		head.next = n;
	}

	public void add(int val){
		SNode n = new SNode(val);
		if(head == null) head = n;
		else {
			SNode curr = head;
			while(curr.next != null){
				curr = curr.next;
			}
			curr.next = n;
		}
	}

	public void delete(int val){
		if(head == null) return;
		if(head.key == val) head = head.next;
		else{
			SNode curr = head;
			SNode prev;
			while(curr.next != null){
				prev = curr;
				curr = curr.next;
				if(curr.key == val){
					prev.next = curr.next;
					return;
				}
			}
		}
	}

	public void display(){
		SNode curr = head;
		while(curr != null){
			System.out.print(curr.key+"-->");
			curr = curr.next;
		}
		System.out.println("null");
	}
}
