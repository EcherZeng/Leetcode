package leetcode_0427;

public class binary_SerchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
	public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
    }
}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(){}
	TreeNode(int val){
		this.val = val;
	}
	TreeNode(int val,TreeNode left,TreeNode right){
		this.val = val;
		this.left = left;
		this.right = right;
	}
}