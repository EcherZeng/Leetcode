package leetcode_0514;

public class ToRoman {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static String intToRoman(int num) {
		/*
		 *  I             1
			V             5
			X             10
			L             50
			C             100
			D             500
			M             1000
			I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
			X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
			C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900
		 */
		if(num>=4000)return "TOOBIG";
		String ans = "I";
		char[] a = {'I','X','C','M'},b= {'V','L','D'};
		int i=0;
		while(num!=0) {
			int temp = num%10;
		}
		return ans;
    }
}
