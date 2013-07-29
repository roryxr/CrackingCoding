class CheckSum {
	public static void main(String[] args){
		int[] a = {6, 3, 8, 2, -1, 7, 1, -3, -2, 9, 0};
		Tree t = new Tree();
		for(int i : a) t.add(i);
		checkSum(t.root, -3);
	}

	public static void checkSum(TreeNode root,int sum, int path[], int level){
		if(root == null) return;
		path[level] = root.key;
		int x = 0;
		for(int i=level; i>=0; --i){
			x += path[i];
			if(sum == x) printPath(path, i, level);
		}


		checkSum(root.left, sum, path, level+1);
		checkSum(root.right, sum, path, level+1);
		
		// path[level] deleted
	}

	public static void checkSum(TreeNode root, int sum){
		if(root == null) return;
		int[] path = new int[height(root)];
		checkSum(root, sum, path, 0);
	}

	public static int height(TreeNode n){
		if(n == null) return 0;
		return 1 + Math.max(height(n.left), height(n.right));
	}

	public static void printPath(int[] path, int start, int end){
		for(int i=start; i<=end; i++)
			System.out.print(path[i] + " ");
		System.out.println();
	}
}
