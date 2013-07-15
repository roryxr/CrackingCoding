package rory.array;

public class ArrayTest {
	public static void main(String[] args){
		MyArray a = new MyArray(100);
		a.insert(5.2);
		a.insert(4.6);
		a.insert(9.8);
		a.insert(2.3);
		a.insert(8.8);
		a.print();
		a.insertionSort();
		a.print();
		System.out.println(a.binarySearch(2.3));
		System.out.println(a.binarySearch(10.2));
	}
}
