package leetcode_0430;

import java.util.Arrays;

public class singledNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,1,0,1,0,1,99};
		System.out.println(singleNumber(nums));
	}
	public static int singleNumber(int[] nums) {
		int len = nums.length;
		if(len==0)return 0;
		if(len<2)return nums[0];
		int left=0,right=1;
		Arrays.sort(nums);
		while(left<len&&right<len) {
			if(nums[left]==nums[right]) {
				left+=3;
				if(right+3==len)return nums[left];
				else right += 3;
			}else break;
		}
		return nums[left];
    }
}
