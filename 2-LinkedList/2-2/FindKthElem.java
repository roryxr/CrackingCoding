class FindKthElem
{
	public static void main(String[] args){
		SList l = new SList();
		int k = 1;
		l.add(4);
		l.add(5);
		l.add(12);
		l.add(8);
		l.add(2);
		l.add(4);
		l.add(11);
		l.add(25);
		l.add(58);
		l.add(10);
		l.add(7);
		l.display();
		findKth1(l.head,k);
		IntWrapper i = new IntWrapper();
		SNode n = findKth2(l.head, k, i);
		System.out.println(n.key);
		SNode n1 = findKth3(l.head, k);
		System.out.println(n1.key);
	}
	
	/* This method can only print that element because the value and the counter cannot be returned at the same time */
	public static int findKth1(SNode n, int k){
		if(n == null) return 0;
		int i = findKth1(n.next, k)+1;
		if(k == i){
			System.out.println(n.key);
		}
		return i;
	}

	/* This methods uses a wrapper class to allow the kth to last element to be returned
	 * Recursive solutions take O(n) space due to recursive calls
	 */
	public static SNode findKth2(SNode n, int k, IntWrapper i){
		if(n == null) return null;
		SNode node = findKth2(n.next, k, i);
		i.value++;
		if(i.value == k){
			return n;
		}
		return node;
	}

	/* Iterative method: use two pointers with k elements apart, when second pointer hits the end of the list, the first pointer will point at kth to last element*/
	public static SNode findKth3(SNode n, int k){
		if(k <= 0) return null;
		SNode first = n, second = n;
		for(int i=0; i<k; i++){
			if(second == null) return null;
			second = second.next;
		}
		if(second == null) return null;
		while(second != null){
			second = second.next;
			first = first.next;
		}
		return first;
	}
}

class IntWrapper{
	public int value = 0;
}
