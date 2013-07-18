class MergeLinkedList
{
	public static void main(String[] args){
		int[] a1 = {1, 3, 6, 8, 11};
		int[] a2 = {2, 4, 5, 9, 10, 12};
		int[] b1 = {4, 5, 7, 9, 19};
		int[] b2 = {1, 2, 4, 6, 10};
		SList la1 = new SList();
		for(int i : a1) la1.add(i);
		SList la2 = new SList();
		for(int i : a2) la2.add(i);
		SList lb1 = new SList();
		for(int i : b1) lb1.add(i);
		SList lb2 = new SList();
		for(int i : b2) lb2.add(i);
		SList la3 = new SList();
		SList lb3 = new SList();
		la1.display();
		la2.display();
		la3.head = mergeList(la1.head, la2.head);
		System.out.print("Merged List: ");
		la3.display();
		lb1.display();
		lb2.display();
		lb3.head = mergeList(lb1.head, lb2.head);
		System.out.print("Merged List: ");
		lb3.display();
	}

	public static SNode mergeList(SNode n1, SNode n2){
		SNode head = null, curr = null;
		if(n1 == null) return n2;
		else if(n2 == null) return n1;
		else {
			if(n1.key <= n2.key){
				head = n1;
				curr = n1;
				n1 = n1.next;
			} else {
				head = n2;
				curr = n2;
				n2 = n2.next;
			}
		}

		while(n1 != null && n2 != null){
			if(n1.key <= n2.key){
				curr.next = n1;
				n1 = n1.next;
			} else {
				curr.next = n2;
				n2 = n2.next;
			}
			curr = curr.next;
		}
		if(n1 == null){
			curr.next = n2;
		} else {
			curr.next = n1;
		}
		return head;
	}
}
