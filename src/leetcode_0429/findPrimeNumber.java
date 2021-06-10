package leetcode_0429;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class findPrimeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(1000000000));
		
	}
	public static void fPrimeNumber(int n) {
		if(n>0) {
			int x = (int)Math.sqrt(n),j=0;
			for(int i=x;i>1;i--) {
				if(n%i!=0) {
					System.out.print(i+" ");
					j++;
					if(j==10) {
						System.out.println(" ");
					}
				}
			}
		}
	}
	public static void fPrimeNumber01(int n) {
		int k=0;
		for(int i=2;i<=n;i++) {
			for(int j=1;j<i;j++) {
				if(i%j==0)continue;
				else {
					System.out.print(i+" ");
					k++;
					if(k==10)System.out.println(" ");
				}
			}
		}
	}
	public static void fPrimeNumber02(int n) {
		int k=0;
		for(int i=0;i<=n;i++) {
			if(isPrimein_100(i)==true) {
				System.out.print(i+" ");
				k++;
				if(k==10) {
					k=0;
					System.out.println(" ");
				}
			}
		}
	}
	public static boolean isPrime(int n) {
		if(n==1)return true;
		for(int i=2;i<n;i++) {
			if(n%i==0)return false;
		}
		return true;
	}
	public static boolean isPrimein_100(int n) {
		if(n>100||n<=1)return false;
		int[] nums = {2,3,5,7};
		for(int i=0;i<4;i++) {
			if(n==nums[i])return true;
			if(n%nums[i]==0)return false;
		}
		return true;
	}
	public static int PrimeNum(int n) {
		List<Integer> primelist = new ArrayList<>();
		primelist.add(2);
		primelist.add(3);
		primelist.add(5);
		primelist.add(7);
		int ans = 0;
		for(int q:primelist) {
			if(n>=q)ans++;
		}
		for(int i=10;i<n;i++) {
			int p = i%10;
			if(p==1||p==3||p==7||p==9) {
				int x=(int)Math.sqrt(i);
				for(Integer j : primelist) {
					if(i%j==0)break;
					if(x<j) {
						ans++;
										//11 13 17 19 23 29 31 37 41 43 47
						primelist.add(i);//11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
						break;
					}
				}
			}
			
		}
		return ans;
	}
	public static int countPrimes(int n) {
        boolean[] isPrim = new boolean[n];
        Arrays.fill(isPrim, true);
        // 从 2 开始枚举到 sqrt(n)。
        for (int i = 2; i * i < n; i++) {
            // 如果当前是素数
            if (isPrim[i]) {
                // 就把从 i*i 开始，i 的所有倍数都设置为 false。
                for (int j = i * i; j < n; j+=i) {
                    isPrim[j] = false;
                }
            }
        }

        // 计数
        int cnt = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim[i]) {
                cnt++;
            }
        }
        return cnt;
    }

}
