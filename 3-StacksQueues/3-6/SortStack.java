import java.util.Stack;
class SortStack
{
	public static void main(String[] args){
		int[] a  = {4, 2, 6, 11, 8, 9, 5};
		Stack<Integer> s = new Stack<Integer>();
		for(int i : a)
		{
			System.out.print(i+" ");
			s.push(i);
		}
		System.out.println();
		s = sortStack2(s);
		for(int i=0; i<a.length; i++){
			System.out.print(s.pop() + " ");
		}
		System.out.println();
	}

	//This method uses 3 stacks
	public static Stack<Integer> sortStack(Stack<Integer> s){
		Stack<Integer> buffer = new Stack<Integer>();
		Stack<Integer> res = new Stack<Integer>();
		while(!buffer.isEmpty() || !s.empty()){
			res.push(s.pop());
			while(!s.isEmpty()){
				if(res.peek() > s.peek()){
					buffer.push(res.pop());
					res.push(s.pop());
				} else {
					buffer.push(s.pop());
				}
			}
			while(!buffer.isEmpty()) s.push(buffer.pop());
		}
		return res;
	}
	
	// This method uses 2 stacks and runs in O(n^2) time and O(n) space
	public static Stack<Integer> sortStack2(Stack<Integer> s){
		Stack<Integer> res = new Stack<Integer>();
		while(!s.isEmpty()){
			int temp = s.pop();
			while(!res.empty() && res.peek() > temp){
				s.push(res.pop());
			}
			res.push(temp);
		}
		return res;
	}
}
