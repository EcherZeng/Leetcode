package leetcode_0517;

public class MyPow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * double x = 2.000; int n = 10; System.out.println(myPow1(x,n));
		 */
		String a = "hello world";
		System.out.println(lengthOfLastWord(a));
	}
	public static double myPow(double x, int n) {
			double ans =x;
			if(n==0)return 1;
			if(n>1) {
				ans = x;
				for(int i=2;i<=n;i++) {
					ans *= x;
				}
			}else if(n<0) {
				ans = (double)1/x;
				for(int i=-2;i>=n;i--) {
					ans /= x;
				}
			}
			
			return ans;
    }
	public static double myPow1(double x, int n) {//快速幂+迭代
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    public static double quickMul(double x, long N) {
        double ans = 1.0;
        // 贡献的初始值为 x
        double x_contribute = x;
        // 在对 N 进行二进制拆分的同时计算答案
        while (N > 0) {
            if (N % 2 == 1) {
                // 如果 N 二进制表示的最低位为 1，那么需要计入贡献
                ans *= x_contribute;
            }
            // 将贡献不断地平方
            System.out.println(ans+" "+x_contribute);
            x_contribute *= x_contribute;
            // 舍弃 N 二进制表示的最低位，这样我们每次只要判断最低位即可
            N /= 2;
        }
        return ans;
    }
    public static int lengthOfLastWord(String s) {
    	int len = s.length();
    	int ans = 0;
    	String m = " ";
    	char[] jump = m.toCharArray();
    	boolean last = false;
    	char[] temp = s.toCharArray();
    	for(int i=len-1;i>=0;i--) {
    		if(temp[i]!=jump[0]) {
    			ans++;
    			last = true;
    		}else {
    			if(last)break;
    			continue;
    		}
    	}
    	return ans;
    }
    public static int lengthOfLastWord1(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();
        return ans.toString();
    }

}
