/*
Find Minimum Sum Path
*/
public class Min_Sum_Path {
	// divide conquer
	public static int minSumPath(TreeNode root) {
		if (root == null) {
			return 0;
		}
		
		int sum = root.val;
		int left = minSumPath(root.left);
		int right = minSumPath(root.right);
		
		if (left <= right) {
			sum += minSumPath(root.left);
		} else {
			sum += minSumPath(root.right);
		}
		return sum;
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			val = x;
		}
	}
	
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(15);
		TreeNode n2 = new TreeNode(10);
		TreeNode n3 = new TreeNode(20);
		TreeNode n4 = new TreeNode(6);
		TreeNode n5 = new TreeNode(7);
		TreeNode n6 = new TreeNode(22);
		TreeNode n7 = new TreeNode(2);
		TreeNode n8 = new TreeNode(16);
		TreeNode n9 = new TreeNode(0);
		TreeNode n10 = new TreeNode(5);
		TreeNode n11 = new TreeNode(3);
		
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.left = n6;
		n5.left = n7;
		n5.right = n8;
		n7.left = n9;
		n7.right = n10;
		n8.left = n11;
		
		System.out.print(minSumPath(n1));
	}
}
