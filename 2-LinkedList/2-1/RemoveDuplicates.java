class RemoveDuplicates
{
	public static void main(String[] args){
		Node n = new Node(5);
		n.display();
		n.add(7);
		n.display();
		n.add(8);
		n.display();
		n.delete(6);
		n.display();
		n.delete(7);
		n.display();
		n.delete(8);
		n.display();
		n.delete(5);
		n.display();
	}
}

class Node{
	private int key;
	Node next;

	public Node(int val){
		key = val;
	}

	public void add(int val){
		Node curr = new Node(val);
		Node n = this;
		while(n.next != null) n = n.next;
		n.next = curr;
	}

	public void delete(int val){
		Node n = this;
		if(n.key == val){
			n = n.next;
		} else {
			while(n.next != null){
				if(n.next.key == val){
					n.next = n.next.next;
					return;
				}
			n = n.next;
			}
		}
	}

	public void display(){
		Node curr = this;
		while(curr != null){
			System.out.print(curr.key+" ");
			curr = curr.next;
		}
			System.out.println();
	}
}
