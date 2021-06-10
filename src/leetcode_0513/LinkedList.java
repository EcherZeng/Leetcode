package leetcode_0513;

import java.util.Stack;


public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(0);
		l1.add(1);
		l1.add(2);
		l1.add(1);
		l1.add(0);
		System.out.println(isPalindrome(l1));
	}
    public static ListNode mergeTwoLists(ListNode linked1, ListNode linked2) {
        //下面4行是空判断
        if (linked1 == null)
            return linked2;
        if (linked2 == null)
            return linked1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (linked1 != null && linked2 != null) {
            //比较一下，哪个小就把哪个放到新的链表中
            if (linked1.val <= linked2.val) {
                curr.next = linked1;
                linked1 = linked1.next;
            } else {
                curr.next = linked2;
                linked2 = linked2.next;
            }
            curr = curr.next;
        }
        //然后把那个不为空的链表挂到新的链表中
        curr.next = linked1 == null ? linked2 : linked1;
        return dummy.next;
    }
    public static boolean isPalindrome(ListNode head) {
    	Stack<Integer> stack = new Stack<>();
    	ListNode temp = head;
    	int len=0;
    	while(temp!=null) {
    		stack.push(temp.val);
    		temp = temp.next;
    		len++;
    	}
    	int[] a = new int[len];
    	temp = head;
    	for(int i =0;i<len;i++) {
    		a[i]=temp.val;
    		temp=temp.next;
    	}
    	int[] b = new int[len];
    	for(int i =0;i<len;i++) {
    		b[i] = stack.pop();
    	}
    	for(int i=0;i<len;i++) {
    		if(a[i]!=b[i])return false;
    	}
    	return true;
    }

    /*
     * 如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
     *  为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 
     *  如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
     */
    public boolean hasCycle(ListNode head) {//快慢指针'
        if (head == null)
        return false;
    //快慢两个指针
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        //慢指针每次走一步
        slow = slow.next;
        //快指针每次走两步
        fast = fast.next.next;
        //如果相遇，说明有环，直接返回true
        if (slow == fast)
            return true;
    }
    //否则就是没环
    return false;
    }
}
class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int x) {
		val = x;
	}

	ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	ListNode(ListNode next) {
		this.next = next;
	}

	public void add(int a) {
		ListNode temp = new ListNode(this);
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = new ListNode(a);
	}

	public void show() {
		ListNode temp = this;
		while (temp != null) {
			System.out.print(temp.val);
			temp = temp.next;
		}
		System.out.println("");
	}
}