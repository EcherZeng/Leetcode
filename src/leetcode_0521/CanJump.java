package leetcode_0521;

public class CanJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {3,2,1,0};
		System.out.println(canJump(nums));
	}
	public static boolean canJump(int[] nums) {
		int len = nums.length;
		int max = 0;
		for(int i=0;i<len;i++) {
			if(max>=len-1)return true;
			max = Math.max(max,nums[i]+i);
			if(max==i)return false;
		}
		return false;
    }
}
