package leetcode_0513;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeTreeTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static int maxDepth(TreeNode root) {
		return root == null ? 0:Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
	public boolean isValidBST1(TreeNode root) {
		if(root==null)return true;
		if(root.left!=null&&root.val<=root.left.val||root.right!=null&&root.val>=root.right.val) {
			return false;
		}
		return isValidBST(root.left)&&isValidBST(root.right);
	}

	public boolean isValidBST(TreeNode root) {
		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	public boolean isValidBST(TreeNode node, long lower, long upper) {
		if (node == null) {
			return true;
		}
		if (node.val <= lower || node.val >= upper) {
			return false;
		}
		return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
	}
	public static boolean isSymmetric(TreeNode root) {
		if(root==null)return true;
		 return isSymmetricHelper(root.left, root.right);
    }
	public static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
	    //如果左右子节点都为空，说明当前节点是叶子节点，返回true
	    if (left == null && right == null)
	        return true;
	    //如果当前节点只有一个子节点或者有两个子节点，但两个子节点的值不相同，直接返回false
	    if (left == null || right == null || left.val != right.val)
	        return false;
	    //然后左子节点的左子节点和右子节点的右子节点比较，左子节点的右子节点和右子节点的左子节点比较
	    return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	}

	 public static List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> res = new ArrayList<>();
		    levelHelper(res, root, 0);
		    return res;
		}

		public static void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
		    //边界条件判断
		    if (root == null)
		        return;
		    //level表示的是层数，如果level >= list.size()，说明到下一层了，所以
		    //要先把下一层的list初始化，防止下面add的时候出现空指针异常
		    if (level >= list.size()) {
		        list.add(new ArrayList<>());
		    }
		    //level表示的是第几层，这里访问到第几层，我们就把数据加入到第几层
		    list.get(level).add(root.val);
		    //当前节点访问完之后，再使用递归的方式分别访问当前节点的左右子节点
		    levelHelper(list, root.left, level + 1);
		    levelHelper(list, root.right, level + 1);
		}

}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}