class FindNext
{
	public static void main(String[] args){
		int[] a = {15, 10, 18, 8, 6, 2, 7, 9, 12, 13, 11, 16, 17};
		Tree t = new Tree();
		for(int i : a) t.add(i);
		TreeNode curr = t.root.left.right.right;
		TreeNode next = findNext(curr);
		if( next != null)
			System.out.println("The next of key "+curr.key+" is " + next.key);
		else
			System.out.println("No successor was found");
	}

	public static TreeNode findNext(TreeNode n){
		if(n == null) return null;
		if(n.right != null) return findSucc(n.right);
		if(n.p == null) return null;
		else {
			TreeNode p = n.p;
			while(p != null && p.right == n){
				n = p;
				p = p.p;
			}
			return p;
		}
	}

	public static TreeNode findSucc(TreeNode root){
		System.out.println("function called" + root.key);
		while(root.left != null) root = root.left;
		return root;
	}
}
