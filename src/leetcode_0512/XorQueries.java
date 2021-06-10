package leetcode_0512;

public class XorQueries {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {16};
		int[][] queries = {{0,0},{0,0},{0,0}};
		int[] ans = xorQueries(arr,queries);
		for(int i:ans)System.out.println(i+",");
	}
	public static int[] xorQueries(int[] arr, int[][] queries) {//
		int[] ans = new int[queries.length];
		for(int i=0;i<ans.length;i++)ans[i]=0;//全赋值为0
		int k=0;
		
		for(int i = 0;i<queries.length;i++) {
			int left = queries[i][0],right = queries[i][1];
			if(left<0||right>=arr.length)return ans;
			int xor = 0;
			for(int j=left;j<=right;j++) {
				xor ^=arr[j];
			}
			ans[k++]=xor;
		}
		return ans;
    }
	public static int[] xorQueries1(int[] arr, int[][] queries) {//前缀和方法
        int n = arr.length;
        int[] xors = new int[n + 1];
        for (int i = 0; i < n; i++) {
            xors[i + 1] = xors[i] ^ arr[i];
        }
        int m = queries.length;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            ans[i] = xors[queries[i][0]] ^ xors[queries[i][1] + 1];
        }
        return ans;
    }


}
