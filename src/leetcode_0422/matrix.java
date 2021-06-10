package leetcode_0422;
/**
 * ����һ�� m x n �ľ��� matrix ��һ������ k ���ҳ������ؾ����ڲ���������Ĳ����� k �������ֵ�͡�
��Ŀ���ݱ�֤�ܻ����һ����ֵ�Ͳ����� k �ľ�������
���룺matrix = [[2,2,-1]], k = 3
�����3
��ʾ
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-100 <= matrix[i][j] <= 100
-105 <= k <= 105
���ף��������Զ�����������������ƽ��������
 */
public class matrix {
	private static int[] nums = new int[]{8,7,4,2,13,5,6,10,9,11};
	private static int[] nums1 = new int[]{1,4,6,9,10,2,3,5,8,7};
	public static void main(String[] args) {
		//int[][] matrix = {{1,0,1},{0,-2,3}};
		//System.out.print(maxSumSubmatrix(matrix,2));
		
		//bubbleSort(nums);
		quickSort01(nums1,0,nums.length-1);
		print(nums1);
		//System.out.println(binarySerch(nums,3));
	}
	public static int maxSumSubmatrix(int[][] matrix, int k) {
        int pre=0,ans=0;
        for(int i=0;i<matrix.length;i++) {
        	for(int j = 0 ;j<matrix[i].length;j++) {
        		pre += matrix[i][j];
        	}
        	if(pre<k) {
        		ans = Math.max(pre,ans);
        	}
        	
        }
        return ans;
    }
	//��ӡ����
	public static void print(int[] nums) {
		for(int i : nums) {
			System.out.print(i+" ");
		}
	}
	//�����㷨
	public static void bubbleSort(int[] nums){//ʱ�临�Ӷ�̫����
		for(int i=0;i<nums.length-2;i++) {
			for(int j=i+1;j<nums.length-1;j++) {
				if(nums[j]<nums[i]) {
					int temp = nums[j];
					nums[j] = nums[i];
					nums[i] = temp;
				}
			}
		}
	}
	//�������
	static void quickSort01(int[] s, int l, int r) {
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
			quickSort01(s,l,j-1);
			quickSort01(s,j+1,r);
		}
	}
	static void quickSort(int[] s, int l, int r) {
		if (l < r) {
			int i = l, j = r, x = s[l];
			print(s);
			System.out.print(" l:"+l+" i:"+i+" r:"+r+" j:"+j+" x:"+x);
			System.out.println("");
			while (i < j) {
				// ���������ҵ�һ��С��x����
				while (i < j && s[j] >= x) {
					j--;
				}
				if (i < j) {
					s[i++] = s[j];
				}
				// ���������ҵ�һ�����ڵ���x����
				while (i < j && s[i] < x) {
					i++;
				}
				if (i < j) {
					s[j--] = s[i];
				}
			}
			s[i] = x;
			print(s);
			System.out.print(" l:"+l+" i:"+i+" r:"+r+" j:"+j+" x:"+x);
			System.out.println("");
			//quickSort(s, l, i - 1); // �ݹ����
			//quickSort(s, i + 1, r);
		}
	}
	

	//�����ж��ַ�����λ��
	public static int binarySerch(int[] nums, int target) {
		int len = nums.length;
		int left =0 ,right = len-1,ans = len;
		while(left<=right) {
			int mid = ((right-left)>>1)+left;
			if(nums[mid]>=target) {
				right = mid-1;
				ans = mid;
			}else left = mid+1;
		}
		return ans;
	}
	
}
