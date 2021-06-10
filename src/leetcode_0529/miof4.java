package leetcode_0529;

public class miof4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isPowerOfFour(16));
	}
	public static boolean isPowerOfFour(int n) {
		 return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
