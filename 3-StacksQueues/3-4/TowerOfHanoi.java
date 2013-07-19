import java.util.Stack;
import java.lang.Integer;
import java.util.ArrayList;
class TowerOfHanoi
{
	public static void main(String [] args){
		int n = 7;
		ArrayList<Stack<Integer>> tower = new ArrayList<Stack<Integer>>();
		for(int i=0; i<3; i++){
			Stack<Integer> s = new Stack<Integer>();
			tower.add(s);
		}
		for(int i=n; i>0; i--){
			tower.get(0).push(i);
		}
		moveDisk(n, tower, tower.get(0), tower.get(2), tower.get(1));
	}

	public static void moveDisk(int n, ArrayList<Stack<Integer>> tower, Stack<Integer> org, Stack<Integer> dest, Stack<Integer> mid){
		if(n <= 0)return;
		moveDisk(n-1, tower, org, mid, dest);
		int item = org.pop().intValue();
		dest.push(item);
		System.out.println("Move item " + item + " from Tower " + (tower.indexOf(org)+1) + " to Tower " + (tower.indexOf(dest)+1));
		moveDisk(n-1, tower, mid, dest, org);
	}
}


