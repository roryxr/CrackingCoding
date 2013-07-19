import java.util.Stack;
import java.util.ArrayList;
class SetOfStacksApp
{
	public static void main(String[] args){
		int[] a = {4, 6, 7, 11, 3, 10, 5, 9};
		SetOfStacks sos = new SetOfStacks(3);
		for(int i : a){
			sos.push(i);
			System.out.println(sos.peek() + " was pushed on the stack");
		}
		try{
			for(int i=0; i<a.length; i++){
				System.out.println(sos.pop() + " was poped from the stack");
			}
			sos.pop();
		}catch(Exception e){
			System.out.println(e);
		}
	}
}

class SetOfStacks
{
	ArrayList<MyStack> stacks;
	private int capacity;
	public SetOfStacks(int cap){
		capacity = cap;
		stacks = new ArrayList<MyStack>();
	}
	public void push(int val){
		if(stacks.size() == 0 || stacks.get(stacks.size()-1).isFull()){
			MyStack s = new MyStack(capacity);
			stacks.add(s);
			s.push(val);
		} else {
			stacks.get(stacks.size()-1).push(val);
		}
	}
	public int pop() throws Exception{
		if(stacks.size() == 0){
			throw new Exception("stack is empty");
		} else{
			int popVal = stacks.get(stacks.size()-1).pop();
			if(stacks.get(stacks.size()-1).isEmpty()){
				stacks.remove(stacks.size()-1);
			}
			return popVal;
		}
	}
	public int peek(){
		if(stacks.size() != 0) return stacks.get(stacks.size()-1).peek();
		else return 100;
	}
}

class MyStack extends Stack<Integer>
{
	private int capacity;
	public MyStack(int capacity){
		this.capacity = capacity;
	}
	public boolean isFull(){
		if(this.size() == capacity) return true;
		return false;
	}
}
