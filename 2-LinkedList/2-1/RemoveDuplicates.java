import java.util.Hashtable;
class RemoveDuplicates
{
	public static void main(String[] args){
		SList n = new SList();
		n.add(5);
		n.display();
		n.add(7);
		n.display();
		n.add(8);
		n.display();
		n.delete(7);
		n.display();
		removeDups1(n);
		n.display();
		n.add(6);
		n.add(8);
		n.add(5);
		n.add(5);
		n.display();
		removeDups2(n);
		n.display();
	}

	/* Using a hash table makes the time complexity O(n) which is efficient */
	public static void removeDups1(SList l){
		Hashtable<Integer, Boolean> table = new Hashtable<Integer, Boolean>();
		SNode n = l.head;
		SNode curr = null;
		while(n != null){
			if(table.containsKey(n.key)){
				curr.next = n.next;
			} else {
				table.put(n.key, true);
				curr = n;
			}
			n = n.next;
		}
	}

	/* If no buffer is allowed, it runs in O(n^2) time with O(1) space with the following method */
	public static void removeDups2(SList l){
		SNode first = l.head;
		SNode second;
		if(first == null) return;
		while (first != null){
			second = first;
			while(second.next != null){
				if(first.key == second.next.key){
					second.next = second.next.next;
				} else {
					second = second.next;
				}
			}
			first = first.next;
		}
	}
}

