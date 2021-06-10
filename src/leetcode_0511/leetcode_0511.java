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
	        int ABCDE = 0; // ��ʼ��������������ڴ��perm��������ֵ�������Ľ��
	        for (int i = 1; i <= n + 1; i++) // perm��������ֵ������� 
	            ABCDE ^= i;
	        int BCDE = 0; // Ϊ�˵õ�perm�ĵ�һ����ֵ����Ҫ��ʼ��һ����BCDE��
	        for (int i = 1; i < n; i += 2) //  ��BCDE������ֵ������encoded�д�1��ʼ������Ϊ2��ȡֵ�������Ľ�� 
	            BCDE ^= encoded[i];
	        ans[0] = ABCDE ^ BCDE; 
	        for(int i = 1;i<=n;i++) {
	        	ans[i]= ans[i-1]^encoded[i-1];
	        }
	        return ans;
	        
	}
}
