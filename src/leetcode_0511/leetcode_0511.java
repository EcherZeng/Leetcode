package leetcode_0511;

public class leetcode_0511 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] encoded = {6,5,4,6};
		int[] ans = decode(encoded);
		for(int i : ans) {
			System.out.print(i+",");
		}
	}
	public static int[] decode(int[] encoded) {
	        int n = encoded.length;
	        int[] ans = new int[n+1];
	        int ABCDE = 0; // 初始化，这个变量用于存放perm中所有数值进行异或的结果
	        for (int i = 1; i <= n + 1; i++) // perm中所有数值进行异或 
	            ABCDE ^= i;
	        int BCDE = 0; // 为了得到perm的第一个数值，需要初始化一个“BCDE”
	        for (int i = 1; i < n; i += 2) //  “BCDE”的求值，就是encoded中从1开始，步长为2地取值进行异或的结果 
	            BCDE ^= encoded[i];
	        ans[0] = ABCDE ^ BCDE; 
	        for(int i = 1;i<=n;i++) {
	        	ans[i]= ans[i-1]^encoded[i-1];
	        }
	        return ans;
	        
	}
}
