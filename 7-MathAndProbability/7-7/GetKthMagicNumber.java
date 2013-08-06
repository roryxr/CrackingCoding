import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Scanner;
public class GetKthMagicNumber {
	public static void main(String[] args){
		System.out.print("Enter the value k to get the kth magic number: ");
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		ArrayList<Integer> magic = getKthMagicNumber(k);
		System.out.println("The kth magic number is: " + magic.get(k));
		System.out.println("Magic Number List:  ");
		printMagic(magic);
	}

	public static void printMagic(ArrayList<Integer> magic){
		for(int i : magic){
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static ArrayList<Integer> getKthMagicNumber(int k){
		if(k < 0){
			return null;
		}
		int val = 0;
		LinkedList<Integer> list3 = new LinkedList<Integer>();
		LinkedList<Integer> list5 = new LinkedList<Integer>();
		LinkedList<Integer> list7 = new LinkedList<Integer>();
		ArrayList<Integer> magic = new ArrayList<Integer>();
		list3.addLast(1);
		for(int i=0; i<=k; i++){
			int v3 = list3.size() > 0? list3.peek():Integer.MAX_VALUE;
			int v5 = list5.size() > 0? list5.peek():Integer.MAX_VALUE;
			int v7 = list7.size() > 0? list7.peek():Integer.MAX_VALUE;
			val = Math.min(v3, Math.min(v5, v7));
			magic.add(val);

			if(val == v3){
				list3.removeFirst();
				list3.addLast(val*3);
				list5.addLast(val*5);
			}	else if(val == v5){
				list5.removeFirst();
				list5.addLast(val*5);
			} else {
				list7.removeFirst();
			}
			list7.addLast(val*7);
		}
		return magic;
	}
}
