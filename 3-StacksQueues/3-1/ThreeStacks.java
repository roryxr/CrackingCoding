class ThreeStacks
{	
	public static void main(String[] args){
		myStack s = new myStack(3);
		try{
			s.push(1, 4);
			s.push(0, 6);
			s.push(0, 8);
			System.out.println("peek value: " + s.peek(1));
			s.pop(0);
			System.out.println("peek value: " + s.peek(0));
			s.pop(0);
			System.out.println("peek value: " + s.peek(0));
		} catch(Exception e){
			System.out.println(e);
		}
	}
}

class myStack
{
	private int stackSize;
	private int[] buffer;
	private int[] stackPointers = {-1, -1, -1};
	public myStack(int size){
		stackSize = size;
		buffer = new int[stackSize*3];
	}

	public void push(int index, int val) throws Exception{
		if(stackPointers[index] == stackSize-1){
			throw new Exception("out of space");
		} else {
			stackPointers[index]++;
			buffer[index*stackSize+stackPointers[index]] = val;
			System.out.println(val+" was pushed on stack " + index);
		}
	}

	public int pop(int index) throws Exception{
		if(stackPointers[index] == -1){
			throw new Exception("stack is empty");
		} else {
			stackPointers[index]--;
			return buffer[index*stackSize+stackPointers[index]+1];
		}
	}

	public int peek(int index) throws Exception{
		if(stackPointers[index] == -1){
			throw new Exception("stack if emtpy");
		} else {
			return buffer[index*stackSize+stackPointers[index]];
		}
	}
}
