package leetcode_0512;

import java.util.Stack;

public class Linkedlist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Stack<Integer> stack = new Stack<Integer>(); int[] a = new int[25]; for(int
		 * i=0;i<25;i++) { a[i]=i; stack.push(a[i]); } int[] b= new int[25]; for(int
		 * i=0;i<25;i++) { b[i] = stack.pop(); } for(int i : b)System.out.print(i+",");
		 */
		ListNode l1 = new ListNode(1);
		l1.add(2);
		l1.add(4);
		l1.show();
		ListNode l2 = new ListNode(0);
		l2.add(1);
		l2.add(3);
		l2.add(5);
		l2.show();
		ListNode l3 = mergeTwoLists(l1,l2);
		l3.show();
	}
	public static void deleteNode(ListNode node) {//删除
        node.val = node.next.val;
        node.next = node.next.next;
    }
	public static ListNode removeNthFromEnd(ListNode head, int n) {
		 int num = length(head)-n;
		 ListNode temp = head;
		 if (num == 0)return head.next;
		 for(int i=0;i<num-1;i++)temp = temp.next;
		 deleteNode(temp);
		 return head;
	}
	public static int length(ListNode head) {
		int len=0;
		while(head!=null) {
			head = head.next;
			len++;
		}
		return len;
	}
	public static ListNode reverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<>();
	    //把链表节点全部摘掉放到栈中
	    while (head != null) {
	        stack.push(head);
	        head = head.next;
	    }
	    if (stack.isEmpty())
	        return null;
	    ListNode node = stack.pop();
	    ListNode dummy = node;
	    //栈中的结点全部出栈，然后重新连成一个新的链表
	    while (!stack.isEmpty()) {
	        ListNode tempNode = stack.pop();
	        node.next = tempNode;
	        node = node.next;
	    }
	    //最后一个结点就是反转前的头结点，一定要让他的next
	    //等于空，否则会构成环
	    node.next = null;
	    return dummy;
    }
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode temp1 = l1,temp2 = l2;//双指针？
		ListNode ans = new ListNode();
		ListNode temp3 = ans.next;
		if(temp1.val>temp2.val) {
			ans.val = temp2.val;
			temp2 = temp2.next;
		}else {
			ans.val = temp1.val;
			temp1 = temp1.next;
		}
		while(temp1!=null||temp2!=null) {
			if(temp1 == null) {
				temp3 = temp2;
				temp3 = temp3;
			}else if(temp2 == null) {
				temp3 = temp1;
				temp3 = temp3.next;
			}else{
				if(temp1.val>temp2.val) {
					temp3 = temp2;
					temp2 = temp2.next;
					temp3 = temp3.next;
				}else{
					temp3 = temp1;
					temp1 = temp1.next;
					temp3 = temp3.next;
				}
			}
		}
		return ans;
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