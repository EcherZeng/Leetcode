package leetcode_0423;

public class Region_and_retrieval {
	public static void main(String[] args) {
		int[] nums = {-2, 0, 3, -5, 2, -1};
		NumArray numArray = new NumArray(nums);
		System.out.println(numArray.sumRange(0,2));
		System.out.println(numArray.sumRange(2, 5));
		System.out.println(numArray.sumRange(0, 5));
		
	}
}
class NumArray {
    public int[] array;
    public NumArray(int[] nums) {
    	int len = nums.length;
    	if(nums == null|| len ==0)this.array=null;
    	array = new int[len+1];
    	array[0] = 0;
    	for(int i=1;i<len+1;i++) {
    		array[i] += array[i-1]+ nums[i-1];
    	}
    }  
    public int sumRange(int left, int right) {
  
    	return array[right+1]-array[left];
    }
}