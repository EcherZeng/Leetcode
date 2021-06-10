package leetcode_0510;

public class writePrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Prime(100000000);
	}
	public static void Prime(int n) {
		int[] a = new int[n];
		for(int i=0;i<n;i++) {
			a[i]=i;
		}
		int num =0;
		for(int i=2;i<n;i++) {
			int j=i*2;
			if(a[i]!=0) {
				//System.out.print(a[i]+",");
				num++;
				while(j<n) {
					a[j]=0;
					j+=i;
				}
			}
		}
		System.out.print("Ò»¹²ÓÐ"+num);
	}
}
