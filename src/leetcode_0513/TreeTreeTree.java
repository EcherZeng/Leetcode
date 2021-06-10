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
	    //��������ӽڵ㶼Ϊ�գ�˵����ǰ�ڵ���Ҷ�ӽڵ㣬����true
	    if (left == null && right == null)
	        return true;
	    //�����ǰ�ڵ�ֻ��һ���ӽڵ�����������ӽڵ㣬�������ӽڵ��ֵ����ͬ��ֱ�ӷ���false
	    if (left == null || right == null || left.val != right.val)
	        return false;
	    //Ȼ�����ӽڵ�����ӽڵ�����ӽڵ�����ӽڵ�Ƚϣ����ӽڵ�����ӽڵ�����ӽڵ�����ӽڵ�Ƚ�
	    return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
	}

	 public static List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> res = new ArrayList<>();
		    levelHelper(res, root, 0);
		    return res;
		}

		public static void levelHelper(List<List<Integer>> list, TreeNode root, int level) {
		    //�߽������ж�
		    if (root == null)
		        return;
		    //level��ʾ���ǲ��������level >= list.size()��˵������һ���ˣ�����
		    //Ҫ�Ȱ���һ���list��ʼ������ֹ����add��ʱ����ֿ�ָ���쳣
		    if (level >= list.size()) {
		        list.add(new ArrayList<>());
		    }
		    //level��ʾ���ǵڼ��㣬������ʵ��ڼ��㣬���ǾͰ����ݼ��뵽�ڼ���
		    list.get(level).add(root.val);
		    //��ǰ�ڵ������֮����ʹ�õݹ�ķ�ʽ�ֱ���ʵ�ǰ�ڵ�������ӽڵ�
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