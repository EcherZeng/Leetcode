package leetcode_0428;

import java.util.Arrays;

public class findMedianSortedArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums1 = {1,2},nums2= {3,4};
		System.out.println(findmedianSortedArrays(nums1,nums2));
	}
	public static double findmedianSortedArrays(int[] nums1, int[] nums2) {
	        int len1 = nums1.length,len2 = nums2.length;
	        if(len1+len2<1||len1+len2>2000||len1<0||len2<0||len1>1000||len2>1000)return 0;
	        int[] nums3 = new int[len1+len2];
	        for(int i=0;i<len1;i++)nums3[i]=nums1[i];
	        for(int j=0;j<len2;j++)nums3[len1+j]=nums2[j];
	        Arrays.sort(nums3);
	        int isOddNumber = (len1+len2)%2;
	        double ans =0;
	        if(isOddNumber==1) {
	        	ans = nums3[nums3.length/2];
	        }else {
	        	ans = (nums3[nums3.length/2]+nums3[nums3.length/2-1])/2.0;
	        }
	        return ans;
	}
}
