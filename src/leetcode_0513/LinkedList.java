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
        //����4���ǿ��ж�
        if (linked1 == null)
            return linked2;
        if (linked2 == null)
            return linked1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (linked1 != null && linked2 != null) {
            //�Ƚ�һ�£��ĸ�С�Ͱ��ĸ��ŵ��µ�������
            if (linked1.val <= linked2.val) {
                curr.next = linked1;
                linked1 = linked1.next;
            } else {
                curr.next = linked2;
                linked2 = linked2.next;
            }
            curr = curr.next;
        }
        //Ȼ����Ǹ���Ϊ�յ�����ҵ��µ�������
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
     * �����������ĳ���ڵ㣬����ͨ���������� next ָ���ٴε���������д��ڻ���
     *  Ϊ�˱�ʾ���������еĻ�������ʹ������ pos ����ʾ����β���ӵ������е�λ�ã������� 0 ��ʼ���� 
     *  ��� pos �� -1�����ڸ�������û�л���ע�⣺pos ����Ϊ�������д��ݣ�������Ϊ�˱�ʶ�����ʵ�������
     */
    public boolean hasCycle(ListNode head) {//����ָ��'
        if (head == null)
        return false;
    //��������ָ��
    ListNode slow = head;
    ListNode fast = head;
    while (fast != null && fast.next != null) {
        //��ָ��ÿ����һ��
        slow = slow.next;
        //��ָ��ÿ��������
        fast = fast.next.next;
        //���������˵���л���ֱ�ӷ���true
        if (slow == fast)
            return true;
    }
    //�������û��
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