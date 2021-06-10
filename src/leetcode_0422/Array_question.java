package leetcode_0422;

import java.util.HashSet;
import java.util.Set;

public class Array_question {
	public static int[] intersection(int[] nums1, int[] nums2) {
        int n = nums1.length,m=nums2.length,k=0;
        int[] n1,n2,n3 = new int[Math.max(n, m)];
        if(n>m) {//长的在1号，短的在2号
        	n1 = nums1;
        	n2 = nums2;
        }else {
        	n1 = nums2;
        	n2 = nums1;
        }
        for(int i = 0;i<n1.length;i++) {
        	for(int j=0;j<n2.length;j++) {
        		if(n1[i]==n2[j]) {
        			n3[k] = n1[i];
        			k++;
        		}
        	}
        }
        int[] n4 = new int[1];
        int p=0;
        for(int i=0;i<n3.length;i++) {
        	if(n3[i]!=0) {
    			n4[p] = n3[i];
    			p++;
    		}
        	for(int j=i+1;j<n3.length;j++) {
        		if(n3[i]==n3[j]&&n3[i]!=0&&n3[j]!=0) {
        			n3[j]=0;	
        		}
        	}
        }
       
        return n4;
    }
	public static void main(String[] atgs) {
		int[] nums1 = {1,2,2,1};
		int[] nums2 = {2,2};
		print(intersection(nums1,nums2));
	}
	static void print(int[] args) {
		for(int i:args) {
			System.out.print(i+" ");
		}
	}
}
