class Tree
{
	TreeNode root;
	public Tree(){
		root = null;
	}

	public void add(int value){
		TreeNode n = new TreeNode(value);
		TreeNode curr = root;
		TreeNode prev = curr;
		while(curr != null){
			prev = curr;
			if(n.key <= curr.key)curr = curr.left;
			else curr = curr.right;
		}
		if(prev == null) root = n;
		else{
			n.p = prev;
			if(n.key <= prev.key) prev.left = n;
			else prev.right = n;
		}
	}
	public TreeNode min(){
		if(root == null)return null;
		TreeNode curr = root;
		while(root.left != null) curr = root.left;
		return curr;
	}
	public TreeNode max(){
		if(root == null)return null;
		TreeNode curr = root;
		while(root.right != null) curr = root.left;
		return curr;
	}

	public void inorder(){
		inorderT(this.root);
		System.out.println();
	}

	public void inorderT(TreeNode n){
		if(n == null) return;
		inorderT(n.left);
		System.out.print(n.key + " ");
		inorderT(n.right);
	}

	public int height(){
		return getHeight(this.root);
	}

	public int getHeight(TreeNode n){
		if(n == null) return 0;
		return Math.max(getHeight(n.left), getHeight(n.right)) + 1;
	}

}
