package leetcode_0428;

import java.util.LinkedList;
import java.util.List;

public class linkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SinglyListNode sl = new SinglyListNode();
		sl.add(5);
		sl.add(6);
		sl.get(0);
	}

}


class SinglyListNode {

		 int val;
		 SinglyListNode next;
		 SinglyListNode head;
		 SinglyListNode(){}
		 SinglyListNode(int x) { val = x; }
	
    public void add(int val) {   
    	if(this.head ==null) {
    		this.head.val = val;
    		next = this.head.next;
    	}else {
    		next.val = val;
    		next = next.next;
    	}
    }
    public int get(int index) {
    	if(index<0) {
    		return -1;
    	}else if(index==0)return head.val;
    	else {
    		for(int i=0;i<=index;i++) {
    			next = head.next;
    		}
    		return next.val;
    	}
    	
    }
    public void addAtHead(int val) {
    	
    }
    public void addAtTail(int val) {
    	
    }
}