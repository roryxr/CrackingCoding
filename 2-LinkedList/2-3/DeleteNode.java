class DeleteNode
{
	public static void main(String[] args){
		SList l = new SList();
		l.add(18);
		l.add(78);
		l.add(67);
		l.add(11);
		l.add(15);
		l.add(56);
		l.add(8);
		l.add(23);
		l.display();
		deleteNode(l.head.next.next.next);
		l.display();
	}

	public static void deleteNode(SNode n){
		if(n == null) return;
		if(n.next == null){
			n.key = 0;
			return;
		}
		n.key = n.next.key;
		n.next = n.next.next;
	}
}
