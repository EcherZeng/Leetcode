package leetcode_0427;

public class dynamic_question {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {{1,1500},{4,3000},{3,2000},{1,2000},{1,1000}};
		int[][] yeying = {{3,10},{1,3},{2,9},{2,5},{1,6}};
		System.out.println(pack(yeying,6));
	}
	public static int pack(int[][] nums,int k) {//��������
		int[][] dp = new int[nums.length][k];
		for(int i=0;i<k;i++) {
			if(i+1>=nums[0][0])dp[0][i]=nums[0][1];
			else dp[0][i]=0;
		}
		for(int i=1;i<nums.length;i++) {
			for(int j=0;j<k;j++) {
				if(j+1-nums[i][0]>0) {//������ڵ���װ�µ�ǰ��Ʒ���п���λ��
					dp[i][j] = Math.max(dp[i-1][j], nums[i][1]+dp[i-1][j-nums[i][0]]);//max(��һ�����ӵ�ֵ,��ǰ��Ʒ��ֵ+ʣ��ռ��ֵ)
				}else if(j+1-nums[i][0]==0) {////������ڵ���װ�µ�ǰ��Ʒ��û�п���λ��
					dp[i][j] = Math.max(dp[i-1][j], nums[i][1]);
				}
				else{//�������װ�µ�ǰ��Ʒ
					dp[i][j] = dp[i-1][j];
				}
					
			}
		}
		for(int i=0;i<dp.length;i++) {
			for(int j:dp[i])System.out.print(j+" ");
			System.out.println("");
		}
		return dp[nums.length-1][k-1];
	}
}
