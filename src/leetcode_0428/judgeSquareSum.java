	package leetcode_0428;

public class judgeSquareSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * for(int i=0;i<=100;i++) { if(judgeSquareSum(i)==true) {
		 * System.out.print(i+" "); } }
		 */
		
	}
	public static boolean judgeSquareSum(int c) {//平方数之和
		int left = 0;
		int right = (int) Math.sqrt(c);
		while(left<=right) {
				int sum = left*left+right*right;
				if(sum==c)return true;
				else if(sum>c)right--;
				else left++;
		}
		return false;
	}
	
}
class Person{
	private int age;
	public Person() {
		
	}
	public Person(int age) {
		this.age = age;
	}
}