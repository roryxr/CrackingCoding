class AddNodes
{
	public static void main(String [] args){
		int[] a = {7,1,7};
		int[] b = {5,9,2};
		SList l1 = new SList();
		SList l2 = new SList();
		for(int i : a) l1.add(i);
		for(int j : b) l2.add(j);
		l1.display();
		l2.display();
		SNode n = addNodes(l1.head, l2.head, 0);
		SList l = new SList();
		l.head = n;
		l.display();
	}

	public static SNode addNodes(SNode n1, SNode n2, int carry){
		if(n1 == null && n2 == null && carry == 0) return null;
		int result = carry;
		if(n1 != null){
			result += n1.key;
		}
		if(n2 != null){
			result += n2.key;
		}
		SNode newNode = new SNode(result % 10);
		newNode.next = addNodes(n1==null? null:n1.next, n2==null? null:n2.next, result >= 10? 1:0);
		return newNode;
	}
}
