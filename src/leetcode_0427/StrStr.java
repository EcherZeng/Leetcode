package leetcode_0427;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//char[] s = {'h','e','l','l','o'};
		//reverseString(s);
		//for(char a : s)System.out.print(a+" ");
		//String s ="dddccdbba";
		//System.out.print(firstUniqChar(s));
		//String s = "anpgram", t = "nagaroam";
		//System.out.print(isAnagram(s,t));
		//String s = "A man, a plan, a canal: Panama";
		//System.out.print(isPalindrome(s));
		//System.out.print(isPalindrome01(s));
		//char a = '-';
		//int b = a-'0';
		//System.out.println(b);
		String s =  "   -42";
		System.out.println(myAtoi01(s));
	}
	public static void reverseString(char[] s) {//反转字符串
		int left =0,right = s.length-1;
		while(left<right) {
			char temp = s[left];
			s[left++] = s[right];
			s[right--] = temp;
		}
    }
	public static int firstUniqChar(String s) {//字符串中的第一个唯一字符
		char[] c = s.toCharArray();
		if(c==null||c.length<=1)return 0;
		Map<Character, Integer> map = new HashMap<>();
		for(char ch : c) {
			 map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		for(int i=0;i<c.length;i++) {
			if(map.get(c[i])==1) {
				return i;
			}
		}
		return -1;
	}
	public static boolean isAnagram(String s, String t) {//有效的字母异位词
	       //特判，长度不同必定不是
	        if (s.length()!=t.length()) return false;
	        //两个字符串排序后是否相等
	        char[] array1 = s.toCharArray();
	        char[] array2 = t.toCharArray();
	        Arrays.sort(array1);
	        Arrays.sort(array2);
	        return Arrays.equals(array1,array2);
	    }
	public static boolean isPalindrome(String s) {//验证回文串
		 	if (s.length() == 0)return true;
	        int left = 0, right = s.length() - 1;
	        while (left < right) {
	            //因为题中说了，只考虑字母和数字，所以不是字母和数字的先过滤掉
	            while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
	                left++;
	            while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
	                right--;
	            //然后把两个字符变为小写，在判断是否一样，如果不一样，直接返回false
	            if (Character.toLowerCase(s.charAt(left++)) != Character.toLowerCase(s.charAt(right--))) {
	            	System.out.println("left: "+s.charAt(left)+" right: "+s.charAt(right));
	            	return false;
	            }
	        }
	        return true;
    }
	public static boolean isPalindrome01(String s) {
		int len = s.length();
		if(len <=1)return true;
		int left =0,right = len-1;
		while(left<right) {
			while(left<right&& !Character.isLetterOrDigit(s.charAt(left)))left++;
			while(left<right&& !Character.isLetterOrDigit(s.charAt(right)))right--;
			if(Character.toLowerCase(s.charAt(left++))!=Character.toLowerCase(s.charAt(right--))) {
				return false;
			}
		}
		return true;
	}
    public static int myAtoi(String str) {
        str = str.trim();//去掉前后的空格
        //如果为空，直接返回0
        if (str.length() == 0)return 0;
        int index = 0;//遍历字符串中字符的位置
        int res = 0;//最终结果
        int sign = 1;//符号，1是正数，-1是负数，默认为正数
        int length = str.length();
        //判断符号	
        if (str.charAt(index) == '-' || str.charAt(index) == '+')
            sign = str.charAt(index++) == '+' ? 1 : -1;
        for (; index < length; ++index) {
        	System.out.println(index);
            //取出字符串中字符，然后转化为数字
            int digit = str.charAt(index) - '0';
            //按照题中的要求，读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。
            //字符串的其余部分将被忽略。如果读取了非数字，后面的都要忽略
            if (digit < 0 || digit > 9)
                break;
            //越界处理
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                res = res * 10 + digit;
        }
        return sign * res;
    }
    public static int myAtoi01(String str) {
    	str = str.trim();
    	int ans=0,sign=1,len=str.length(),i=0;
    	if(len==0)return 0;
    	if (str.charAt(i) == '-' || str.charAt(i) == '+')
            sign = str.charAt(i++) == '+' ? 1 : -1;
    	for(;i<len;i++) {
    		int num = str.charAt(i)-'0';
    		if(num<0||num>9) break;
    		if(ans > Integer.MAX_VALUE /10||(ans == Integer.MAX_VALUE/10 && num>Integer.MAX_VALUE %10)) {
    			return sign==1? Integer.MAX_VALUE : Integer.MIN_VALUE;
    		}else ans = ans*10 +num;
    	}
    	return sign*ans;
    }
   

}
