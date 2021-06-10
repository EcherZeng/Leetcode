package leetcode_0426;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Array {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 	//int[] nums = {0,0,1,1,1,2,2,3,3,4};
		 	//System.out.print(removeDuplicates(nums));
		//int[] prices = {7,1,5,3,6,4};
		//System.out.print(maxProfit01(prices));
		//int[] nums = {1,2,3,4,5,6,7};
		//int k = 3;
		//rotate01(nums,k);
		//int[] nums = {1,2,3,4};
		//System.out.print(containsDuplicate(nums));
		//int[] nums = {2,2,1};
		//System.out.print(singleNumber(nums));
		//int[] nums1 = {1,2,2,1},nums2 = {2};
		//int[] ans = intersect(nums1,nums2);
		//for(int i:ans)System.out.print(i);
		//int[] nums = {9,9,9,9};
		//int[] ans = plusOne(nums);
		//for(int i:ans)System.out.print(i+" ");
		//int[] nums = {0,1,0,3,12};
		//moveZeroes(nums);
		//for(int i:nums)System.out.print(i+" ");
		//int[] nums = {77,4,11,15,2,7};
		//nums = twoSum(nums, 9);
		//System.out.print(nums[0]+" "+nums[1]);
	}
	public static int removeDuplicates(int[] nums) {//原地删除重复元素！

		int len = nums.length;
		if(nums == null||len == 0)return 0;
		int left = 0;
		for(int right=0;right<len;right++) {
			if(nums[left]!=nums[right]){
				left++;
				nums[right] += nums[left];
				nums[left] = nums[right]-nums[left];
				nums[right] = nums[right]-nums[left];
			}
		}
		int[] newNums = new int[left+1];
		for(int l = 0;l<=left;l++) {
			newNums[l] = nums[l];
		}
		for(int i : newNums) {
			System.out.print(i+" ");
		}
		return newNums.length;
	}
	public static int maxProfit(int[] prices) {
	    if (prices == null || prices.length < 2)
	        return 0;
	    int length = prices.length;
	    //初始条件
	    int hold = -prices[0];//持有股票
	    int noHold = 0;//没持有股票
	    for (int i = 1; i < length; i++) {
	        //递推公式转化的
	        noHold = Math.max(noHold, hold + prices[i]);
	        hold = Math.max(hold, noHold - prices[i]);
	        System.out.println("noHold: "+noHold+" hold: "+hold);
	    }
	    //最后一天肯定是手里没有股票的时候利润才会最大，
	    //所以这里返回的是noHold
	    return noHold;
	}
	public static int maxProfit01(int[] prices) {//手敲买股票
		int len = prices.length;
		if(prices == null || len == 0)return 0;
		int pre = 0,aft = -prices[0];
		for(int i=1;i<len;i++) {
			pre = Math.max(pre,aft + prices[i]);
			aft = Math.max(aft, pre - prices[i]);
	        System.out.println("pre: "+pre+" aft: "+aft);
		}
		return pre;
	}
	public static void rotate(int[] nums, int k) {//旋转数组
		/*执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户 内存消耗：55.2 MB, 在所有 Java 提交中击败了14.10%的用户 */
		 	int length = nums.length;
	        k %= length;
	        reverse(nums, 0, length - 1);//先反转全部的元素
	        for(int i : nums)System.out.print(i+" ");

	        reverse(nums, 0, k - 1);//在反转前k个元素
	        for(int i : nums)System.out.print(i+" ");

	        reverse(nums, k, length - 1);//接着反转剩余的
	        for(int i : nums)System.out.print(i+" ");
    }
	public static void reverse(int[] nums, int left,int right) {

		while(left<right) {
			int temp = nums[left];
			nums[left++] = nums[right];
			nums[right--] = temp;
		}
	}
	public static void rotate01(int[] nums, int k) {
		int len = nums.length;
		int[] temp = new int[len];
		for(int i=0;i<len;i++)temp[i]=nums[i];	
		for(int i=0;i<len;i++)nums[(i+k)%len] = temp[i];
		for(int i:nums)System.out.print(i);
	}
	public static boolean containsDuplicate(int[] nums) {//存在重复元素
		int len = nums.length;
		if(nums==null||len==0)return false;
		Arrays.sort(nums);
		int left=0,right =1;
		while(right<len)if(nums[left++]==nums[right++])return true;
		return false;
	}
	public static int singleNumber(int[] nums) {//只出现一次的数
		//执行用时：7 ms, 在所有 Java 提交中击败了29.38%的用户内存消耗：38.6 MB, 在所有 Java 提交中击败了67.24%的用户
		int len = nums.length;
		if(nums==null||len==0)return 0;
		if(len==1)return nums[0];
		Arrays.sort(nums);
		int left=0,right=1,ans=0;
		while(right<len) {
			if(nums[right]!=nums[left]) {
				ans = nums[left];
				break;
			}
			left +=2;
			right +=2;
			if(right==len)ans = nums[left];
		}
		return ans;
    }	
	public static int singleNumber01(int[] nums) {
	        int reduce = 0;
	        for (int num : nums)reduce =  reduce ^ num;
	        return reduce;
	}
    public static int[] intersect(int[] nums1, int[] nums2) {//两个数组的交集
    	int len1=nums1.length,len2=nums2.length;
    	if(nums1==null||nums2==null||len1==0||len2==0)return null;
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);
    	int left=0,right=0,ansIndex=0;
    	List<Integer> list = new ArrayList<>();
    	while(left<len1&&right<len2) {
    		if(nums1[left]<nums2[right])left++;
    		else if(nums1[left]==nums2[right]) {
    			list.add(nums1[left]);
    			left++;
    			right++;
    		}
    		else right++;
    	}
    	int[] ans = new int[list.size()];
    	for(int i=0;i<list.size();i++) {
    		ans[i] = list.get(i);
    	}
    	return ans;
    }
    public static int[] intersect01(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        //先把数组nums1的所有元素都存放到map中，其中key是数组中
        //的元素，value是这个元素出现在数组中的次数
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        //然后再遍历nums2数组，查看map中是否包含nums2的元素，如果包含，
        //就把当前值加入到集合list中，然后再把对应的value值减1。
        for (int i = 0; i < nums2.length; i++) {
            if (map.getOrDefault(nums2[i], 0) > 0) {
                list.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        //把集合list转化为数组
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
    public static int[] plusOne(int[] nums) {//加一
    	//执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户内存消耗：36.9 MB, 在所有 Java 提交中击败了56.64%的用户
    	int len = nums.length;
    	if(nums==null||len==0)return null;
    	int index=len-1;
    	while(index>=0) {
    		if(index==0&&nums[index]==9) {
    			int[] temp = new int[len+1];
    			temp[0]=1;
    			return temp;
    		}
    		if(nums[index]!=9) {
    			nums[index] +=1;
    			break;
    		}else nums[index--]=0;
    	}
    	return nums;

    }
    public static int[] plusOne01(int[] nums) {
        int length = nums.length;
        for (int i = length - 1; i >= 0; i--) {
            if (nums[i] != 9) {
                //如果数组当前元素不等于9，直接加1
                //然后直接返回
                nums[i]++;
                return nums;
            } else {
                //如果数组当前元素等于9，那么加1之后
                //肯定会变为0，我们先让他变为0
                nums[i] = 0;
            }
        }
        //除非数组中的元素都是9，否则不会走到这一步，
        //如果数组的元素都是9，我们只需要把数组的长度
        //增加1，并且把数组的第一个元素置为1即可
        int temp[] = new int[length + 1];
        temp[0] = 1;
        return temp;
    }
    public static void moveZeroes(int[] nums) {//移动零
    	int len = nums.length;
    	if(len>1) {
    		int left =0,right =1;
    		for(;right<len;right++) {
    			if(nums[left]==0&&nums[right]==0)continue;
    			if(nums[left]==0&&nums[right]!=0) {
    				nums[left++] = nums[right];
    				nums[right] =0;
    			}else left++;
    		}
    	}
    }
    public static void moveZeroes01(int[] nums) {
        int i = 0;//统计前面0的个数
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0) {//如果当前数字是0就不操作
                i++;
            } else if (i != 0) {
                //否则，把当前数字放到最前面那个0的位置，然后再把
                //当前位置设为0
                nums[j - i] = nums[j];
                nums[j] = 0;
            }
        }
    }
    public static int[] twoSum(int[] nums, int target) {//两数之和
    	 int j = 1;
         int i = 0;
         int maxArea = nums.length - 1;
         while (nums[i] + nums[j] != target){
             if(j == maxArea){
                 i++;
                 j = i;
             }
             j++;
             System.out.println("i:"+i+" j:"+j);
         }
         return new int[]{i,j};
    }
    public static int[] twoSum01(int[] nums, int target) {
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (m.get(target - nums[i]) != null) {
                return new int[]{m.get(target - nums[i]), i};
            }
            m.put(nums[i], i);
        }
        return new int[]{0, 0};
    }
    public static boolean isValidSudoku(char board[][]) {//有效的数独
    	 // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
          rows[i] = new HashMap<Integer, Integer>();
          columns[i] = new HashMap<Integer, Integer>();
          boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
          for (int j = 0; j < 9; j++) {
            char num = board[i][j];
            if (num != '.') {
              int n = (int)num;
              int box_index = (i / 3 ) * 3 + j / 3;

              // keep the current cell value
              rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
              columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
              boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

              // check if this value has been already seen before
              if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                return false;
            }
          }
        }
        return true;
    }
    public static void rotate(int[][] matrix) {//旋转图像
        int length = matrix.length;
        //先上下交换
        for (int i = 0; i < length / 2; i++) {
            int temp[] = matrix[i];
            matrix[i] = matrix[length - i - 1];
            matrix[length - i - 1] = temp;
        }
        //在按照对角线交换
        for (int i = 0; i < length; ++i) {
            for (int j = i + 1; j < length; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    public static void rotate01(int[][] matrix) {
        int length = matrix.length;
        //因为是对称的，只需要计算循环前半行即可
        for (int i = 0; i < length / 2; i++)
            for (int j = i; j < length - i - 1; j++) {
                int temp = matrix[i][j];
                int m = length - j - 1;
                int n = length - i - 1;
                matrix[i][j] = matrix[m][i];
                matrix[m][i] = matrix[n][m];
                matrix[n][m] = matrix[j][n];
                matrix[j][n] = temp;
            }
    }

}
