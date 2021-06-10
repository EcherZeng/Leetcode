package leetcode_0511;

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Node node = new Node();
			node.addNode(1);
			node.addNode(2);
			node.addNode(3);
			
			node.show();
			System.out.println(node.select(0)+"  length =  "+node.Length());
			
	}

}
class Node extends LinkedList{
	private int a;
	public Node next;
	private Node head;
	public Node(int a) {
		this.a = a;
	}
	public Node() {
		
	};
	public Node(Node node) {
		this.next = node;
	}
	public void addNode(int a) {
		head = new Node(this);
		Node temp = head.next;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(a);
	}
	public void show() {
		head = new Node(this);
		Node temp = head.next;
		while(temp.next!=null) {
			temp = temp.next;
			System.out.print(temp.a+",");
			
		}
	}
	public void delete(int index) {
		if(index<0||index>this.Length()-1) {
			System.out.println("给定位置不合理");
			return;
		}
		Node temp = new Node(this);
		for(int i=0;i<index;i++) {
			temp = temp.next;
		}
		Node free = new Node(temp.next);
		
		temp.next = temp.next.next; 
		
		free.next =null;
		free = null;	
	}
	public int select(int index) {
		if(index<0||index>this.Length()-1) {
			System.out.println("给定位置不合理");
			return -1;
		}
		Node temp = new Node(this);
		for(int i=0;i<=index;i++) {
			temp = temp.next;
		}
		return temp.next.a;
	}
	
	public int Length() {
		head = new Node(this);
		Node temp = head.next;
		int len=0;
		while(temp.next!=null) {
			len++;
			temp = temp.next;
		}
		return len;
	}
	public String toString() {
        return getClass().getName() + " a: " +a;
    }
	public boolean equals(Object obj) {
        return (this == obj);
    }
	public boolean equals(Node node) {
		return(this.a == node.a&&this.next==node.next);
	}
	public boolean equals(int a) {
		return(this.a == a);
	}
}