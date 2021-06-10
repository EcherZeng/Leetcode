package leetcode_0519;

import java.util.Arrays;

public class MaxArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {4,3,2,1,4};
		System.out.println(maxArea(height));
	}
	public static int maxArea(int[] height) {
        int area =0;
        int len = height.length;
        int left =0,right = len-1;
        while(left<right) {
        	area = Math.max(area, height[left]>height[right] ? height[right--]*(right - left+1) : height[left++]*(right-left+1));
        }
        return area;
    }
	public static int threeSumClosest(int[] nums, int target) {
		int len = nums.length;
        int[] ans = new int[len];
        int[] temp = new int[len];
        for(int i=0;i<len;i++) {
        	ans[i] = target-nums[i];
        	temp[i] = Math.abs(ans[i]);
        }
        Arrays.sort(temp);
        return 0;
        
    }
	 public int threeSumClosest1(int[] nums, int target) {
	        Arrays.sort(nums);
	        int n = nums.length;
	        int best = 10000000;

	        // ö�� a
	        for (int i = 0; i < n; ++i) {
	            // ��֤����һ��ö�ٵ�Ԫ�ز����
	            if (i > 0 && nums[i] == nums[i - 1]) {
	                continue;
	            }
	            // ʹ��˫ָ��ö�� b �� c
	            int j = i + 1, k = n - 1;
	            while (j < k) {
	                int sum = nums[i] + nums[j] + nums[k];
	                // �����Ϊ target ֱ�ӷ��ش�
	                if (sum == target) {
	                    return target;
	                }
	                // ���ݲ�ֵ�ľ���ֵ�����´�
	                if (Math.abs(sum - target) < Math.abs(best - target)) {
	                    best = sum;
	                }
	                if (sum > target) {
	                    // ����ʹ��� target���ƶ� c ��Ӧ��ָ��
	                    int k0 = k - 1;
	                    // �ƶ�����һ������ȵ�Ԫ��
	                    while (j < k0 && nums[k0] == nums[k]) {
	                        --k0;
	                    }
	                    k = k0;
	                } else {
	                    // �����С�� target���ƶ� b ��Ӧ��ָ��
	                    int j0 = j + 1;
	                    // �ƶ�����һ������ȵ�Ԫ��
	                    while (j0 < k && nums[j0] == nums[j]) {
	                        ++j0;
	                    }
	                    j = j0;
	                }
	            }
	        }
	        return best;
	    }

}
