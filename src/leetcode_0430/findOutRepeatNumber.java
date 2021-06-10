package leetcode_0430;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findOutRepeatNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] nums = {2, 3, 1, 0, 2, 5, 3};
		//System.out.println(findRepeatNumber01(nums));
		//String s = "We are happy";
		//System.out.println(replaceSpace(s));
		//System.out.println(fib(48));
		//System.out.println(numWays(0));
		String s = "PAYPALISHIRING";
		
		String k = convert01(s,4);
		System.out.println(k);
		
	}
	public static int findRepeatNumber(int[] nums) {//数组中重复的数字 57% 78%
        int len = nums.length;
        if(len == 1)return nums[0];
        int left =0,right =1;
        Arrays.sort(nums);
        while(left<len&&right<len) {
        	if(nums[right++]!=nums[left++])continue;
        	else break;
        }
        return nums[left];
    }
	public static int findRepeatNumber01(int[] nums) {//50% 44%
		int len = nums.length;
		if(len==0)return 0;
		if(len==1)return nums[0];
		int[] array = new int[len-1];
		Arrays.sort(nums);
		for(int i=0;i+1<len;i++) array[i] = nums[i+1]-nums[i];
		for(int i=0;i<len-1;i++) {
			if(array[i]==0)return nums[i];
		}
		return 0;
	}
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		int len = matrix.length;
		int i=0,j=0;
		while(i<len) {
			int size = matrix[i].length;
			if(j<size) {
				while(j<size&&target>matrix[i][j])j++;
				if(j<size&&target==matrix[i][j])return true;
				if(j<size&&target<matrix[i][j]) {
					 if(j==0)continue;
					i +=1;
					j -=1;
					continue;
				}
			}
			i+=1;
		}
		return false;
    }
	public static boolean findNumberIn2DArray01(int[][] matrix, int target) {
	        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
	            return false;
	        }
	        int rows = matrix.length, columns = matrix[0].length;
	        int row = 0, column = columns - 1;
	        while (row < rows && column >= 0) {
	            int num = matrix[row][column];
	            if (num == target) {
	                return true;
	            } else if (num > target) {
	                column--;
	            } else {
	                row++;
	            }
	        }
	        return false;
	    }
	public static String replaceSpace(String s) {
	        return s.replace(" ","%20");
	 }
	public static int fib(int n) {//0和1开始 011235 012345
		 if(n<=0)return -1;
		 if(n<=2)return 1; 
		 int pre = 0,ans = 1;
		 for(int i=1;i<n;i++) {
			 ans +=pre;
			 pre = ans-pre;
			 System.out.print(ans+" ");
			 if(ans>100000007)ans%=1000000007;
		 }
		 return ans;
	 }
	public static int numWays(int n) {
		int a=1,b=2;
		for(int i=1;i<n;i++) {
			int sum = (a+b)%1000000007;
			a=b;
			b=sum;
		}
		return a;
	}
	public static String convert(String s, int num) {
		int numRows = num-1;
		char[][] st = new char[numRows][s.length()/2];
		char[] ch = s.toCharArray();
		int left=0,right=0;
		Boolean boo = true;
		for(int i=0;i<ch.length;i++) {
			if(boo) {
				st[left++][right]=ch[i];
				if(left==numRows)boo=false;
			}else {
				left--;
				right++;
				st[left][right]=ch[i];
				if(left==0) boo=true;
			}
		}
		int k=0;
		char[] cm = new char[5];
		for(int i=0;i<5;) {
			cm[i] = 'h';
			i+=2;
		}
		char ww = cm[1];
		
		char[] ans = new char[s.length()];
		for(int j=0;j<numRows;j++) {
			for(int p=0;p<s.length()/2;p++) {
				if(st[j][p]==ww)continue;
				ans[k++] = st[j][p];
			}
		}
		return String.valueOf(ans);
    }
	 public static String convert01(String s, int numRows) {
	        if(numRows < 2) return s;
	        List<StringBuilder> rows = new ArrayList<StringBuilder>();
	        for(int i = 0; i < numRows; i++) rows.add(new StringBuilder());
	        int i = 0, flag = -1;
	        for(char c : s.toCharArray()) {
	            rows.get(i).append(c);
	            if(i == 0 || i == numRows -1) flag = - flag;
	            i += flag;
	        }
	        StringBuilder res = new StringBuilder();
	        for(StringBuilder row : rows) res.append(row);
	        return res.toString();
	    }

}
