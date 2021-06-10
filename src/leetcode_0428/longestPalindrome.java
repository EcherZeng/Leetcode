package leetcode_0428;

import java.util.HashMap;
import java.util.Map;

public class longestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "bb";
		System.out.println(longestpalindrome01(s));
	}
	public static String longestpalindrome(String s) {//Ѱ������Ĵ�
		Map<Character,Integer> map = new HashMap<>();
		char[] c = s.toCharArray();
		int len = c.length,le =0;
		if(len==0||s.isEmpty())return null;
		String ans = s.substring(0,1);
		int index =0;
		for(int i=0 ;i<len;i++) {
			char ch = c[i];
			map.put(ch,map.getOrDefault(ch,0)+1);
			if(map.get(ch)>=2) {
				if(i+1<len&&c[i+1]==c[i])continue;
				if(le<s.substring(s.indexOf(ch),i+1).length()) {
					le = s.substring(s.indexOf(ch),i+1).length();
					ans = s.substring(s.indexOf(ch),i+1);
				}else continue;
			}
		}
		return ans;
		
	}
	public static String longestpalindrome01(String s) {
		int len = s.length();
		if(s.isEmpty())return null;
		if(len==1)return s;
		String ans = s.substring(0,1);
		int left=0,right=0;
		char[] ch = s.toCharArray();
		for(int i=1;i<len-1;i++) {
			if(ch[i-1]==ch[i+1]) {
				left=i-1;
				right=i+1;
				if(ch[i]==ch[i+1]) {
					while(left-1>=0&&ch[i]==ch[left-1])left--;
					while(right+1<=len-1&&ch[i]==ch[right+1])right++;
				}
				break;
			}else if(ch[i-1]!=ch[i+1]&&ch[i]==ch[i+1]) {
				left=i;
				right=i+1;
				while(left-1>=0&&ch[i]==ch[left-1])left--;
				while(right+1<=len-1&&ch[i]==ch[right+1])right++;
				break;
			}
		}
		System.out.println(left+" "+right);
		while(ch[left]==ch[right]) {
			ans = s.substring(left,right+1);
			left--;
			right++;
			if(left<0||right+1>len)break;
		}
		return ans;
	}
	 public static String longestPalindrome01(String s) {
	        int len = s.length();
	        if (len < 2)return s;
	        int maxLen = 1;
	        int begin = 0;
	        // dp[i][j] ��ʾ s[i..j] �Ƿ��ǻ��Ĵ�
	        boolean[][] dp = new boolean[len][len];
	        // ��ʼ�������г���Ϊ 1 ���Ӵ����ǻ��Ĵ�
	        for (int i = 0; i < len; i++) dp[i][i] = true;
	        char[] charArray = s.toCharArray();
	        // ���ƿ�ʼ
	        // ��ö���Ӵ�����
	        for (int L = 2; L <= len; L++) {
	            // ö����߽磬��߽���������ÿ��Կ���һЩ
	            for (int i = 0; i < len; i++) {
	                // �� L �� i ����ȷ���ұ߽磬�� j - i + 1 = L ��
	                int j = L + i - 1;
	                // ����ұ߽�Խ�磬�Ϳ����˳���ǰѭ��
	                if (j >= len) {
	                    break;
	                }

	                if (charArray[i] != charArray[j]) {
	                    dp[i][j] = false;
	                } else {
	                    if (j - i < 3) {
	                        dp[i][j] = true;
	                    } else {
	                        dp[i][j] = dp[i + 1][j - 1];
	                    }
	                }

	                // ֻҪ dp[i][L] == true �������ͱ�ʾ�Ӵ� s[i..L] �ǻ��ģ���ʱ��¼���ĳ��Ⱥ���ʼλ��
	                if (dp[i][j] && j - i + 1 > maxLen) {
	                    maxLen = j - i + 1;
	                    begin = i;
	                }
	            }
	        }
	        return s.substring(begin, begin + maxLen);
	    }

}
