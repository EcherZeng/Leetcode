package leetcode_0603;



public class FindMaxLen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,0,1,0,0,0,1,1};
		System.out.println(findMaxLength(nums));
	}
	public static int findMaxLength(int[] nums) {
        int ans =0;
        int cnt_0=0,cnt_1=0;
        for(int i=0;i<nums.length;i++) {
        	switch(nums[i]) {
        		case 0:cnt_0++;break;
        		case 1:cnt_1++;break;
        	}
        	if(cnt_0==cnt_1)ans=cnt_0+cnt_1;
        }
        return ans;
    }
}
