package leetcode_0429;

public class canCrossRiver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] stones = {0,1,2,3,6,9,10,13,17};
		System.out.println(canCross01(stones));
	}
	public static boolean canCross(int[] stones) {
		int n = stones.length; 
        // �������飬�����б�ʾ��Ӧʯ�ӵı�ţ��б�ʾ��һ���ľ���
        boolean[][] dp = new boolean[n][n];
        // ��ʼ״̬һ����Ϊtrue
        dp[0][0] = true;
        
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                // ����ʯ�ӵľ���������ŵ�ʱ�򣬱�Ȼ������ȥ(����һ����������Ĺ�ϵ)
                if (k > j + 1) {
                    break;
                }
                // j��Ӧ����һ�����ڵ�ʯ��λ�ã��ж���[k��1]�ķ�Χ�����Ƿ��ܹ������j����i
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                
                // ����������ĩβ��ʱ�򣬽���һ���жϣ��ж��Ƿ����������һ��ʯ��
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        
        return false;
	}
	public static boolean canCross01(int[] stones) {
        int n = stones.length;
        boolean[][] dp = new boolean[n][n];
        dp[0][0] = true;
        for (int i = 1; i < n; ++i) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
        }
        for (int i = 1; i < n; ++i) {
            for (int j = i - 1; j >= 0; --j) {
                int k = stones[i] - stones[j];
                if (k > j + 1) {
                    break;
                }
                dp[i][k] = dp[j][k - 1] || dp[j][k] || dp[j][k + 1];
                if (i == n - 1 && dp[i][k]) {
                    return true;
                }
            }
        }
        return false;
    }
	
}
