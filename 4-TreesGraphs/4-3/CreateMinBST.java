class CreateMinBST {
	public static void main(String[] args){
		int[] a = {2, 3, 5, 7, 10, 18, 25, 36};
		Tree t = createMinBST(a);
		t.inorder();
		System.out.println("The height of the tree is: "+t.height());
	}

	public static Tree createMinBST(int[] a){
		Tree t = new Tree();
		int lb = 0, ub = a.length-1;
		createBST(t, a, lb, ub);
		return t;
	}
	public static void createBST(Tree t, int[] a, int lb, int ub){
		if(lb > ub) return;
		int mid = (lb + ub) / 2;
		t.add(a[mid]);
		createBST(t, a, lb, mid-1);
		createBST(t, a, mid+1, ub);
	}
}
