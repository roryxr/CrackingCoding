package rory.array;

public class MyArray {
	private double[] myarray;
	private int nelem;
	public MyArray(int size){
		myarray = new double[size];
		nelem = 0;
	}
	
	public double get(int n){
		return myarray[n];
	}
	
	public void insert(double val){
		myarray[nelem] = val;
		nelem++;
	}
	
	public void delete(int n){
		int i;
		for(i=n; i<nelem-1; i++){
			myarray[i] = myarray[i+1];
		}
		nelem--;
	}
	
	public int doBinarySearch(double val, int lb, int ub){
		int mid = (lb+ub)/2;
		if(lb>ub) return -1;
		else if(myarray[mid] == val) return mid;
		else if(myarray[mid] >= val) return doBinarySearch(val, lb, mid-1);
		else return doBinarySearch(val, mid+1, ub);
	}
	
	public int binarySearch(double val){
		int lb = 0;
		int ub = nelem-1;
		return doBinarySearch(val, lb, ub);
	}
	
	public void insertionSort(){
		int i;
		int j;
		for(i=1; i<nelem; i++){
			j = i;
			while(j>0 && myarray[j] < myarray[j-1]){
				swap(j, j-1);
				j--;
			}
		}
	}
	
	public void bubbleSort(){
		int i;
		int j;
		for(i=0; i<nelem-1; i++){
			for(j=0; j<nelem-1-i; j++){
				if(myarray[j]>myarray[j+1]){
					swap(j, j+1);
				}
			}
		}
	}
	
	public void swap(int n1, int n2){
		double temp;
		temp = myarray[n1];
		myarray[n1] = myarray[n2];
		myarray[n2] = temp;
	}
	
	public void print(){
		int i;
		for(i=0; i<nelem-1; i++)
			System.out.print(myarray[i] + " ");
		System.out.println();
	}
}
