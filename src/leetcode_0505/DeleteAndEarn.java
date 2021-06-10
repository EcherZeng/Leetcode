package leetcode_0505;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static int deleteAndEarn(int[] nums) {
        int len = nums.length;
        if(len==1)return nums[0];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums) {
        	 map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int ans=0;
        int random = (int) (Math.random()*(len-1));
        return ans;
	}
	public static int deleteAndEarn01(int[] nums) {
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(maxVal, val);
        }
        int[] sum = new int[maxVal + 1];
        for (int val : nums) {
            sum[val] += val;
        }
        return rob(sum);
    }

    public static int rob(int[] nums) {
        int size = nums.length;
        int first = nums[0], second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < size; i++) {
            int temp = second;
            second = Math.max(first + nums[i], second);
            first = temp;
        }
        return second;
    }

}
