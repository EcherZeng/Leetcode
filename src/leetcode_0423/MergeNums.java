package leetcode_0423;

public class MergeNums {
	public static void main(String[] args) {
		int[] nums1 = {1,2,3,0,0,0}, nums2 = {2,5,6};
		int m = nums1.length,n = nums2.length;
		Solution s = new Solution();
		s.merge(nums1,m-n,nums2,n);
		for(int i:nums1) {
			System.out.print(i+" ");
		}
	}
}
class Solution {
	 public void merge01(int[] nums1, int m, int[] nums2, int n) {
	        int temp[] = new int[m + n];
	        int index = 0;
	        int i = 0;
	        int j = 0;
	        while (i < m && j < n) {
	            if (nums1[i] <= nums2[j])
	                temp[index++] = nums1[i++];
	            else
	                temp[index++] = nums2[j++];
	        }
	        for (; i < m; ) {
	            temp[index++] = nums1[i++];
	        }
	        for (; j < n; ) {
	            temp[index++] = nums2[j++];
	        }
	        //再把数组temp中的值赋给nums1
	        for (int k = 0; k < m + n; k++) {
	            nums1[k] = temp[k];
	        }
	    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
    	int j=0;
        for(int i=m+n-1;i>m-1;i--) {
        	nums1[i] = nums2[j];
        	j++;
        }
        quicksort(nums1,0,m+n-1);
    }
    public void quicksort(int[] s,int l,int r) {
    	if(l<r) {
			int i=l,j=r,x=s[r];
			while(i<=j) {
				if(i==j) {
					s[r]=s[j];
					s[j]=x;
					break;
				}
				if(s[i]>x) {
					int temp = s[i];
					s[i] = s[j-1];
					s[j-1] =temp;
					j--;
				}else {
					i++;
				}	
			}
			quicksort(s,l,j-1);
			quicksort(s,j+1,r);
		}
    	
    }
}