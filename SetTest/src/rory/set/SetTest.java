package rory.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> set1 = new HashSet<String>();
		Set<Integer> set2 = new TreeSet<Integer>();
		Set<String> set3 = new LinkedHashSet<String>();
		set1.add("It");
		set1.add(null);
		set1.add("is");
		set1.add("a");
		set1.add("a");
		set1.add("good");
		set1.add("day");
		set3.add("It");
		set3.add(null);
		set3.add("is");
		set3.add("a");
		set3.add("good");
		set3.add("good");
		set3.add("day");
		set2.add(8);
		set2.add(5);
		set2.add(10);
		set2.add(2);
		set2.add(2);
		set2.add(7);
		displaySet(set1);
		displaySet(set2);
		displaySet(set3);
	}
	public static void displaySet(Set<?> s){
		Iterator<?> itr1 = s.iterator();
		while(itr1.hasNext()){
			System.out.print(itr1.next()+" ");
		}
		System.out.println();
	}

}
