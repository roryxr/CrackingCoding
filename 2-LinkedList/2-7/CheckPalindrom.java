import java.util.Stack;
class CheckPalindrom
{
	public static void main(String[] args){
		int[] val1 = {1, 3, 4, 5, 2, 1};
		int[] val2 = {9, 3, 4, 5, 6, 5, 4, 3, 9};
		SList l1 = new SList();
		SList l2 = new SList();
		for(int i : val1) l1.add(i);
		for(int i : val2) l2.add(i);
		l1.display();
		if(isPalindrom3(l1.head))
			System.out.println("l1 is a palindrom");
		else
			System.out.println("l1 is not a palindrom");
		l2.display();
		if(isPalindrom3(l2.head))
			System.out.println("l2 is a palindrom");
		else
			System.out.println("l2 is not a palindrom");
	}

	// Use stack to check, runs in O(n) time and O(n) space
	public static boolean isPalindrom(SNode n){
		SNode fast=n, slow=n;
		Stack<Integer> stk = new Stack<Integer>();
		while(fast != null && fast.next != null){
			stk.push(slow.key);
			fast = fast.next.next;
			slow = slow.next;
		}
		// odd number of nodes, skip the middle one
		if(fast != null){
			slow = slow.next;
		}
		while(slow != null){
			if(slow.key != stk.pop()) return false;
			slow = slow.next;
		}
		return true;
	}

	// reverse the list and check
	public static boolean isPalindrom2(SNode n){
		SNode newNode = reverseList(n);
		SList l = new SList();
		l.head = newNode;
		l.display();

		SNode fast = n, slow = n;
		while(fast != null && fast.next != null){
			if(slow.key != newNode.key) return false;
			slow = slow.next;
			fast = fast.next.next;
			newNode = newNode.next;
		}
		return true;
	}

	public static SNode reverseList(SNode n){
		SNode last = n;
		SNode dummy = new SNode(0);
		while(n != null){
			SNode newNode = new SNode(n.key);
			newNode.next = dummy.next;
			dummy.next = newNode;
			n = n.next;
		}
		return dummy.next;
	}

	// check palindrom recursively
	public static boolean isPalindrom3(SNode n){
		Result s = isPalindromRecurse(n, length(n));
		return s.result;
	}

	public static Result isPalindromRecurse(SNode n, int len){
		assert(len == 2): "Length reaches" + len;
		if(n == null || len == 0){
			return new Result(null, true);
		} else if (len == 1){
			return new Result(n.next, true);
		} else if (len == 2){
			return new Result(n.next.next, n.key == n.next.key);
		}

		Result res = isPalindromRecurse(n.next, len-2);
		if(!res.result || res.node == null){
			return res;
		} else {
			res.result = n.key == res.node.key;
			res.node = res.node.next;
			return res;
		}
	}

	public static int length(SNode n){
		int len = 0;
		while(n != null){
			len++;
			n = n.next;
		}
		return len;
	}
}

class Result
{
	public SNode node;
	public boolean result;
	public Result(SNode n, boolean res){
		node = n;
		result = res;
	}
}
