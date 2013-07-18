import java.util.Stack;
class StackWithMinApp
{
	public static void main(String[] args){
		StackWithMin2 s = new StackWithMin2();
		int[] a = {5, 6 ,10, 3, 2};
		for(int i : a){
			s.push(i);
			System.out.println(i+" pushed, min = "+ s.min());
		}
		for(int i=0; i<a.length; i++){
			System.out.println(s.pop() +" poped, min = "+ s.min());
		}
	}
}

 // This method creates a class NodeWithMin that keeps track of the min value
class StackWithMin extends Stack<NodeWithMin>
{
	private static int ERROR_VALUE = 100;
	public void push(int val){
		int min = min();
		if(val < min) min = val;
		super.push(new NodeWithMin(val, min));
	}
	/*
	public int pop(){
		if(!isEmpty()){
			return super.pop().value;
		}
	}
	*/

	public int min(){
		if(isEmpty()) return ERROR_VALUE;
		else return peek().min;
	}
}

	// This method uses another stack to keep the min value which is a little better in space
class StackWithMin2 extends Stack<Integer>{
	private static int ERROR_VALUE = 100;
	Stack<Integer> min = new Stack<Integer>();
	public void push(int val){
		if(this.isEmpty()) min.push(val);
		else{
			if(val <= min.peek()) min.push(val);
		}
		super.push(val);
	}

	public Integer pop(){
		if(this.peek() == min.peek()) min.pop();
		return super.pop();
	}

	public int min(){
		if(this.isEmpty())return ERROR_VALUE;
		return min.peek();
	}
}

class NodeWithMin{
	public int min;
	public int value;
	public NodeWithMin(int val, int min){
		value = val;
		this.min = min;
	}
}
