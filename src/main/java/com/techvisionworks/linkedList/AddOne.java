package com.techvisionworks.linkedList;

public class AddOne {
	public static void main(String[] args) {
		  Node.push(9);
		  Node.push(9);
		  Node.push(9);
		  Node.push(1);
	        System.out.println("Linked List without sorting is :");
	       Node.printList(Node.head);
	 
	        // Apply merge Sort
	       Node.head = addOne(Node.head);
	        System.out.print("\n Sorted Linked List is: \n");
	        Node.printList(Node.head);
	}

	private static Node addOne(Node head) {
		int num = addoneUtil(head);
		if(num == 1) {
			Node temp = new Node(num);
			temp.next = head;
			Node.head = temp;
		}
		return Node.head;
	}

	private static int addoneUtil(Node head) {
		if(head == null)
			return 1;
		
		int res = head.data + addoneUtil(head.next);
		head.data = res%10;
		res = res/10;
		return res;
	}
}
