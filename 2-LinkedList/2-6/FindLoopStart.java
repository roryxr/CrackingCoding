class FindLoopStart
{
	public static void main(String[] args){
		int[] val = {3, 5, 6, 71, 21, 4, 9, 11, 23, 41, 10, 54};
		SList l = new SList();
		for(int i : val) l.add(i);
		l.display();
		if(hasLoop(l.head)){
			SNode nLoopStart = findLoopStart(l.head);
			System.out.println("Loop start value is: " + nLoopStart.key);
		} else {
			System.out.println("The list does not have a loop");
		}

		makeLoop(l.head, 5); //make a loop at fifth node
		if(hasLoop(l.head)){
			SNode nLoopStart = findLoopStart(l.head);
			System.out.println("Loop start value is: " + nLoopStart.key);
		} else {
			System.out.println("The list does not have a loop");
		}
	}

	public static boolean hasLoop(SNode n){
		SNode slow = n, fast = n;
		while(fast != null && fast.next !=null){
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) return true;
		}
		return false;
	}

	public static SNode findLoopStart(SNode head){
		if(hasLoop(head)){
			SNode slow = head.next, fast = slow.next;
			while(fast != slow){
				fast = fast.next.next;
				slow = slow.next;
			}
			fast = head;
			while(fast != slow){
				fast = fast.next;	
				slow = slow.next;
			}
			return fast;
		} else return null;
	}

	public static void makeLoop(SNode n, int i){
		int cnt = 0;
		SNode target = null;
		SNode prev = null;
		while(n != null){
			cnt++;
			prev = n;
			if(cnt == i) target = n;
			n = n.next;
		}
		prev.next = target;
	}
}
