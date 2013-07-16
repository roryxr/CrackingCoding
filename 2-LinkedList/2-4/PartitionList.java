class PartitionList
{
	public static void main(String [] args){
		SList l = new SList();
		l.add(2);
		l.add(11);
		l.add(18);
		l.add(3);
		l.add(5);
		l.add(32);
		l.add(9);
		l.add(6);
		l.add(10);
		l.display();
		SList curr = new SList();
		curr.head = partitionList(l.head, 11);
		curr.display();
	}

	public static SNode partitionList(SNode n, int k){
		SNode first = null;
		SNode second = null;
		while(n != null){
			SNode next = n.next;
			if(n.key < k){
				n.next = first;
				first = n;
			} else {
				n.next = second;
				second = n;
			}
			n = next;
		}
		if(first == null) return second;
		
		SNode head = first;
		while(first.next != null){
			first = first.next;
		}
		first.next = second;
		return head;
	}
}
