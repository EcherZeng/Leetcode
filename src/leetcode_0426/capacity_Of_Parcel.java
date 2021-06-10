package leetcode_0426;

public class capacity_Of_Parcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] weights = {3,2,2,4,1,4};
		int D = 3;
		System.out.print(shipWithinDays(weights,D));
	}
	public static int shipWithinDays(int[] weights, int D) {
		int len = weights.length;
		if(weights ==null || len == 0)return 0;
		int ans = 0,day =D+1,temp;
		for(int i:weights)ans = Math.max(ans, i);
		ans -= 1;
		while(day > D) {
			int sum =0;
			temp =0;
			ans += 1;
			for(int i =0;i<len;i++) {
				sum += weights[i];
				if(sum==ans) {
					temp++;
					sum =0;
					continue;
				}else if(sum>ans) {
					temp++;
					sum =0;
					i--;
					continue;
				}
				if(i==len-1&&sum !=0&&sum<ans) {
					temp++;
					sum=0;
				}
			}
			day=temp;
		}
		return ans;
    }
}
