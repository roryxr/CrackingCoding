class CheckSubtree
{
	public static void main(String[] args){
		int[] a = {15, 10, 8, 6, 9, 2, 7, 12, 11, 13, 18, 16, 17};
		int[] b = {12, 11, 13};
		int[] c = {11, 12, 13};
		Tree t1 = new Tree();
		Tree t2 = new Tree();
		Tree t3 = new Tree();
		for(int i : a) t1.add(i);
		for(int i : b) t2.add(i);
		for(int i : c) t3.add(i);
		if(isSubtree2(t1.root, t2.root)) System.out.println("is subtree");
		else System.out.println("is not subtree");
		if(isSubtree2(t1.root, t3.root)) System.out.println("is subtree");
		else System.out.println("is not subtree");
	}

	// This method creates strings to put preorder traversal and inorder traversal results for each tree and compare if the small string is a substring of the large one. Time complexity is in O(m+n) where m is the size of first tree and n is the size of second tree. Space complexity is O(m+n)
	public static boolean isSubtree(TreeNode root1, TreeNode root2){
		if(root2 == null) return true;
		if(root1 == null) return false;
		String s1_preorder = getTreeStringPreorder(root1, "");
		String s2_preorder = getTreeStringPreorder(root2, "");
		String s1_inorder = getTreeStringInorder(root2, "");
		String s2_inorder = getTreeStringInorder(root2, "");
		if(isSubstring(s1_preorder, s2_preorder) && isSubstring(s1_inorder, s2_inorder)) return true;
		else return false;	
	}

	public static String getTreeStringPreorder(TreeNode root, String s){
		if(root == null){
			s += "0";
			return s;
		} 
		s += String.valueOf(root.key);
		s = getTreeStringPreorder(root.left, s);
		s = getTreeStringPreorder(root.right, s);
		return s;
	}

	public static String getTreeStringInorder(TreeNode root, String s){
		if(root == null){
			s += "0";
			return s;
		} 
		s = getTreeStringInorder(root.left, s);
		s += String.valueOf(root.key);
		s = getTreeStringInorder(root.right, s);
		return s;
	}

	public static boolean isSubstring(String s1, String s2){
		return s1.contains(s2);
	}

	// This method find the node in the big tree which has the same key value as the key of root of the small tree. Then cut from the node of big tree and check if the subtree is identical with the small tree.
	public static boolean isSubtree2(TreeNode root1, TreeNode root2){
		if(root2 == null) return true;
		return subTree(root1, root2);
	}

	public static boolean subTree(TreeNode r1, TreeNode r2){
		if(r1 == null) return false;
		if(r1.key == r2.key){
			if(checkSame(r1, r2)) return true;
		}
		return subTree(r1.left, r2) || subTree(r1.right, r2);
	}

	public static boolean checkSame(TreeNode r1, TreeNode r2){
		if(r1 == null && r2 == null) return true;
		if(r1 == null || r2 == null) return false;
		if(r1.key != r2.key) return false;
		else return (checkSame(r1.left, r2.left) && checkSame(r1.right, r2.right));
	}
	
}
