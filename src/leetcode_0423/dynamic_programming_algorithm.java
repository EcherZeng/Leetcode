package leetcode_0423;

import java.util.ArrayList;
import java.util.List;

public class dynamic_programming_algorithm {
	
	//�ݹ�ʽ����¥��
	public static int climbStairs(int n) {
        if(n<1)return 0;
        if(n<3)return n;
        return climbStairs(n-1)+climbStairs(n-2);
    }
	public static int climbStairs_dp(int n) {
		int pre = 1;
		int aft = 2;
		if(n<1)return 0;
		if(n<3)return n;
		while(n-2>0) {
			aft +=pre;
			pre = aft-pre;
			n--;
		}
		return aft;
	} 
	public static int climbStairs_dp02(int n) {
		int[] nums = new int[n];
		if(n<1)return 0;
		if(n<3)return n;
		nums[0] = 1;
		nums[1] = 2;
		for(int i=2;i<n;i++) {
			nums[i] = nums[i-1]+nums[i-2];
		}
		return nums[n-1];
	}
	public static void main(String[] args) {
		//int stairs = 45;
		//System.out.print(climbStairs_dp02(stairs));
		
		//BuyStocks bs = new BuyStocks();
		//int[] prices = {7,12,1,3,6,7};
		//System.out.print(bs.maxProfit01(prices));
		
		//MaxSubArray msa = new MaxSubArray();
		//int[] nums = {-6,4,-2,3,-2};
		//int[] nums = {5,4,-1,7,8};
		RoB Rob = new RoB();
		int[] nums = {1,2,3,1};
		//System.out.print(msa.maxSubArray(nums));
		System.out.print(Rob.rob(nums));
	}
}
/**
 * �������Ҫ���2�������ʱ��û���й�Ʊ���������dp[1][0]����ô�������������

��һ��������ǵ�2�����Ǽ�û��Ҳû������ô���������ǵ�1��û���й�Ʊ���������dp[2-1][0]��

�ڶ���������ǵ�2����������һ֧��Ʊ����ô���������ǵ�1����й�Ʊ�������������Ǹ��ģ�����Ҳ��һ���ǵ�1�쿪ʼ���еģ��п����ڵ�1��֮ǰ���Ѿ������ˣ����ϵ�2��������Ʊ���������dp[0][1]+prices[1]��

���ߣ����ݽṹ���㷨
���ӣ�https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/xn8fsh/?discussion=MoFL0j
��Դ�����ۣ�LeetCode��
����Ȩ���������С���ҵת������ϵ���߻����Ȩ������ҵת����ע��������
 * @author P1337575
 *
 */
class BuyStocks{
	public  int maxProfit(int[] prices) {
	    if (prices == null || prices.length == 0)return 0;
	    int length = prices.length;
	    int[][] dp = new int[length][2];
	    //�߽�����
	    dp[0][0]= 0;
	    dp[0][1] = -prices[0];
	    for (int i = 1; i < length; i++) {
	        //���ƹ�ʽ
	        dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
	        dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
	    }
	    //��ӹ���ɣ����϶�������û���й�Ʊ����Ż����Ҳ��������ȥ��
	    return dp[length - 1][0];
	}
	public  int maxProfit01(int[] prices) {
		int len = prices.length;
		if(prices ==null||len==0)return 0;
		int sell = 0;
		int buy = -prices[0];
		for(int i=1;i<len;i++) {
			sell = Math.max(sell, buy+prices[i]);
			buy = Math.max(-prices[i], buy);
		}
		return sell;
	}
	public  int maxProfit02(int[] prices) {
	    if (prices == null || prices.length == 0)
	        return 0;
	    int maxPro = 0;//��¼�������
	    int min = prices[0];//��¼�����з��ʹ�����Сֵ
	    for (int i = 1; i < prices.length; i++) {
	        min = Math.min(min, prices[i]);
	        maxPro = Math.max(prices[i] - min, maxPro);
	    }
	    return maxPro;
	}
}
class MaxSubArray{
	public int maxSubArray_buyStocks(int[] nums) {
		int pre =0,aft =0,len = nums.length;
		int[] prices = new int[len-1];
		if(len<2||nums ==null)return 0;
		for(int i=0;i<len-2;i++) {
			prices[i] = nums[i+1]-nums[i];
		}
		for(int i=0;i<len-2;i++) {
			pre = Math.max(pre, 0) + prices[i];
			aft = Math.max(pre, aft);
		}
		return aft;
	}
	public int maxSubArray(int[] nums) {
		int pre =0,aft =nums[0],len = nums.length;
		if(len==0||nums ==null)return 0;
		for(int i=0;i<len;i++) {
			pre = Math.max(pre, 0) + nums[i];
			aft = Math.max(pre, aft);
			System.out.println("pre:"+pre+" aft:"+aft);
		}
		return aft;
	}
	public int maxSubArray01(int[] num) {
	    int length = num.length;
	    int[] dp = new int[length];
	    //�߽�����
	    dp[0] = num[0];
	    int max = dp[0];
	    for (int i = 1; i < length; i++) {
	        //ת�ƹ�ʽ
	        dp[i] = Math.max(dp[i - 1], 0) + num[i];
	        //��¼���ֵ
	        max = Math.max(max, dp[i]);
	    }
	    return max;
	}
}
class RoB{
	public int rob(int[] nums) {
		int len =nums.length;
		if(len == 0 || nums==null)return 0;
		if(len == 1)return nums[0];
		int pre=0;
		int[] aft = new int[len];
		aft[0] = nums[0];
		for(int i=1;i<len;i++) {
			aft[i] = Math.max(pre, pre+nums[i]);
			pre = Math.max(pre, aft[i-1]);
			System.out.println("aft:"+aft[i]+" pre:"+pre);
		}
		return Math.max(aft[len-1], pre);
	}
}
