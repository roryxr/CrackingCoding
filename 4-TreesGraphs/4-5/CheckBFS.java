class CheckBST
{
	public static final int MIN_VALUE = 0;
	public static final int MAX_VALUE = 100;
	public static void main(String[] args){
		int[] a = {8, 5, 3, 6, 2, 12};
		Tree t = new Tree();
		for(int i : a) t.add(i);
		//t.root.right = new TreeNode(7);
		System.out.println(checkBST3(t.root, MIN_VALUE, MAX_VALUE));
	}

	public static int cnt = 0;
	// This method is just an implementation of inorder traversal algorithm but uses extra array
	public static boolean checkBST(TreeNode root, int size){
		int[] array = new int[size];
		inorderBST(root, array);
		for(int i=0; i<size-1; i++)
			if(array[i] > array[i+1])return false;
		return true;
	}

	public static void inorderBST(TreeNode root, int[] a){
		if(root == null) return;
		inorderBST(root.left, a);
		a[cnt++] = root.key;
		inorderBST(root.right, a);
	}

	public static int lastValue = 0;	
	// This method also uses inorder traversal, but without using extra space.
	public static boolean checkBST2(TreeNode root){
		if(root == null) return true;
		if(!checkBST2(root.left)) return false;
		if(lastValue > root.key)	return false; 
		lastValue = root.key;
		if(!checkBST2(root.right)) return false;
		return true;
	}

	// This method uses a range to check if left.key <= root.key < right.key
	public static boolean checkBST3(TreeNode root, int min, int max){
		if(root == null) return true;
		if(root.key < min || root.key > max) return false;
		if(!checkBST3(root.left, min, root.key)) return false;
		if(!checkBST3(root.right, root.key, max)) return false;
		return true;
	}
}

