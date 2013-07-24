import java.util.ArrayList;
import java.util.LinkedList;
class CreateLists {
	public static void main(String[] args){
		int[] a = {8, 5, 3, 6, 2, 12, 15};
		Tree t = new Tree();
		for(int i : a) t.add(i);
		ArrayList<LinkedList<TreeNode>> lists = createLists2(t.root);
		for(LinkedList<TreeNode> s : lists){
			for(TreeNode n : s)
				System.out.print(n.key + " ");
			System.out.println();
		}
	}

	public static ArrayList<LinkedList<TreeNode>> createLists(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		createDepthLists(root, lists, 0);
		return lists;
	}

	// This method uses preorder traversal algorithm to add each node to the LinkedList of each level and add these linked list to an arraylist. This runs in O(n) time and uses extra O(log n) space for recursive calls. However, since the whole arraylist was returned the space complexity is still in O(n).
	public static void createDepthLists(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level){
		if(root == null) return;
		LinkedList<TreeNode> l = null;
		if(lists.size() <= level){
			l = new LinkedList<TreeNode>();
			lists.add(l);
		} else {
			l = lists.get(level);
		}
		l.add(root);
		createDepthLists(root.left, lists, level+1);
		createDepthLists(root.right, lists, level+1);
	}

	// Another method can use BFS algorithm. It runs in O(n) time and O(n) space.
	public static ArrayList<LinkedList<TreeNode>> createLists2(TreeNode root){
		ArrayList<LinkedList<TreeNode>> lists = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> l = new LinkedList<TreeNode>();
		lists.add(l);
		l.add(root);
		while(l.size() != 0){
			LinkedList<TreeNode> parents = l;
			l = new LinkedList<TreeNode>();
			for(TreeNode n : parents){
				if(n.left != null) l.add(n.left);
				if(n.right != null) l.add(n.right);
			}
			if(l.size() != 0) lists.add(l);
		}
		return lists;
	}
}
