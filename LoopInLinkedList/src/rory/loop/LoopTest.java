package rory.loop;

import java.util.Iterator;
import java.util.LinkedList;

public class LoopTest {
	public static void main(String[] args){
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(5);
		list.add(12);
		list.add(89);
		list.add(2);
		list.add(35);
		displayList(list);
	}
	
	public static void displayList(LinkedList<Integer> list){
		Iterator<Integer> itr = list.iterator();
		while(itr.hasNext()){
			System.out.print(itr.next() + " ");
		}
		System.out.println();
	}
}
