package leetcode_0607;

public class targetSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {2,3,1,5};
		System.out.println(findTargetSumWays(nums,1));
	}
	public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int diff = sum - target;
        if (diff < 0 || diff % 2 != 0) {
            return 0;
        }
        int n = nums.length, neg = diff / 2;
        int[][] dp = new int[n + 1][neg + 1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            for (int j = 0; j <= neg; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= num) {
                    dp[i][j] += dp[i - 1][j - num];
                }
            }
        }
        for(int[] a: dp) {
        	for(int i : a) {
        		System.out.print(i+",");
        	}
        	System.out.println(" ");
        }
        return dp[n][neg];
	}
}
