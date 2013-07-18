class MergeList{
	public static void main(String[] args){
		int [] a1 = {1, 3 ,4 ,5, 8 ,11, 56, 89, 150};
		int [] a2 = {2, 8, 9, 10, 22, 44, 77, 100};
		mergeList(a1, a2);
	}
	
	public static void mergeList(int [] a1, int [] a2){
		int size = a1.length+a2.length;
		int [] list = new int[size];
		int l1 = a1.length;
		int l2 = a2.length;
		int p1 = 0, p2 = 0, p = 0;
		while(p1 < l1 && p2 < l2){
			if(a1[p1] <a2[p2])
				list[p++] = a1[p1++];
			 else 
				list[p++] = a2[p2++];
		}
		if(p1 < l1){
			for(int i=p1; i<l1; i++)
				list[p++] = a1[p1++];
		} else {
			for(int i=p2; i<l2; i++)
				list[p++] = a2[p2++];
		}
		
		for(int i=0; i<size; i++){
			System.out.print(list[i] + " ");
		}
		System.out.println();
	}
}
