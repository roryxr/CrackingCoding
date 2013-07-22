import java.util.Stack;
class MyQueueApp
{
	public static void main(String[] args){
		int [] a  = {2, 42, 21, 33, 4, 6, 9, 10};
		MyQueue<Integer> q = new MyQueue<Integer>();
		System.out.print("Enqueue List: ");
		for(int i : a){
			System.out.print(i+" ");
			q.enqueue(i);
		}
		System.out.println();
		for(int i=0; i<a.length; i++) System.out.print(q.dequeue()+" ");
		System.out.println();
	}
}

class MyQueue<T>
{
	Stack<T> main;
	Stack<T> buffer;
	public static int ERROR_VALUE = 10000;
	
	public MyQueue(){
		main = new Stack<T>();
		buffer = new Stack<T>();
	}
	public void enqueue(T i)
	{
		if(main.isEmpty()) main.push(i);
		else{
			while(!main.isEmpty()) buffer.push(main.pop());
			main.push(i);
			while(!buffer.isEmpty()) main.push(buffer.pop());
		}
	}

	public T dequeue(){
		if(main.isEmpty()){
			return null;
		} else {
			return main.pop();
		}
	}
}
