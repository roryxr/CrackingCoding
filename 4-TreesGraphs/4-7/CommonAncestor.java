import java.util.HashSet;
class CommonAncestor
{
	public static void main(String[] args){
		int[] a = {15, 10, 8, 9, 6, 2, 7, 12, 11, 13, 18, 16, 17};
		Tree t = new Tree();
		for(int i : a) t.add(i);
		TreeNode root = t.root;
		TreeNode[] p = new TreeNode[3];
		TreeNode[] q = new TreeNode[3];
		p[0] = root.left.left;
		q[0] = root.left.right.right;
		p[1] = root.left.left.right;
		q[1] = root.right.left.right;
		p[2] = root.left.left.left;
		q[2] = new TreeNode(23);
		for(int i=0; i<3; i++){
			TreeNode result = commonAncestor(root, p[i], q[i]);
			if(result == null) System.out.println("One of the nodes is not in the tree.");
			else {
				System.out.println("The common ancestor of key " + p[i].key + " and key " + q[i].key + " is " + result.key);
			}
		}	
	}


	// This method does not extra data structure but runs in O(n) time and O(log n) space, the fisrt call of findAncestor requires 2N steps while the following requires 2N/2, 2N/4, 2N/8,... steps.
	public static boolean covers(TreeNode root, TreeNode x){
		if(root == null) return false;
		if(root == x) return true;
		return covers(root.left, x) || covers(root.right, x);
	}
	
	public static TreeNode findAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(root == null) return null;
		if(root == p || root == q) return root;

		boolean p_at_left = covers(root.left, p);
		boolean q_at_left = covers(root.left, q);

		if(p_at_left != q_at_left) return root; // p and q are on different subtrees, root must be the ancestor
		return findAncestor(p_at_left?root.left:root.right, p, q);
	}

	public static TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q){
		if(!covers(root, p) || !covers(root, q)) return null;
		else return findAncestor2(root, p, q);
	}

	// This method can be used only when each node has a pointer to its parent. Also, extra data structure was used here.(HashSet)
	public static TreeNode findAncestor2(TreeNode root, TreeNode p, TreeNode q){
		HashSet<TreeNode> hs = new HashSet<TreeNode>();
		while(p != null && p != root){
			hs.add(p);
			p = p.p;
		}
		while(q != null && q != root){
			if(hs.contains(q)) return q;
			q = q.p;
		}
		return root;
	}
}
