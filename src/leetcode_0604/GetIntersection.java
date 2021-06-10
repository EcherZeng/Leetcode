package leetcode_0604;

import java.util.HashMap;
import java.util.Map;

public class GetIntersection {

	public static void main(String[] args) {
		// TODO Auto-generated method 	stub
		String J = "aA",S = "aAAbbbb";
		System.out.println(numJewelsInStones(J,S));
	}
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
            return null;
        }
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }
	public static int numJewelsInStones(String jewels, String stones) {
		Map<Character,Integer> map = new HashMap<>();
		char[] temp = stones.toCharArray();
		for(char ch : temp) {
			map.put(ch, map.getOrDefault(ch, 0)+1);
		}
		int ans=0;
		temp = jewels.toCharArray();
		for(char ch : temp) {
			ans += map.getOrDefault(ch,0);
		}
		return ans;
    }
}
class ListNode{
	int val;
	ListNode next;
	ListNode (int x){
		val = x;
		next =null;
	}
}