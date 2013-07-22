class CheckBalance
{
	public static void main(String[] args){
		int[] a = {8, 5, 3, 2, 6, 12};
		Tree t = new Tree();
		for(int i : a) t.add(i);
		preorder(t.root);
		System.out.println();
		if(isBalanced(t.root))System.out.println("Tree is balanced.");
		else System.out.println("Tree is not balanced.");
	}

	public static boolean isBalanced(TreeNode root){
		if(checkHeight(root) == -1) return false;
		else return true;
	}

 // This method runs in O(n) time and O(log n) space
	public static int checkHeight(TreeNode root){
		if(root == null) return 0;
		int leftHeight = checkHeight(root.left);
		if(leftHeight == -1) return -1;
		int rightHeight = checkHeight(root.right);
		if(rightHeight == -1) return -1;
		int diff = leftHeight - rightHeight;
		if(Math.abs(diff) > 1) return -1;
		else return Math.max(leftHeight, rightHeight)+1;
	}

	public static void preorder(TreeNode root){
		if(root == null) return;
		System.out.print(root.key+" ");
		preorder(root.left);
		preorder(root.right);
	}
}
