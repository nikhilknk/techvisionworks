package com.techvisionworks.linkedList;


public class SortLinkedList {

	public static void main(String[] args) {
		 Node.push(11);
		  Node.push(9);
		  Node.push(22);
		  Node.push(69);
		  Node.push(1);
		Node temp = sort(Node.head);
		printLinkedList(temp);
	}
	
	private static Node sort(Node head) {
		if(head == null || head.next == null)
			return head;
		
		Node middle = findMiddle(head);
		
		Node middlenext = middle.next;
		
		middle.next = null;
		Node left = sort(head);
		Node right = sort(middlenext);
		Node sortedList = sortedMerge(left,right);
		
		return sortedList;
	}

	private static Node sortedMerge(Node left, Node right) {
		if(left == null)
			return right;
		else if(right == null)
			return left;
		
		Node result = null;
		
		if(left.data <= right.data) {
			result = left;
				result.next = 	sortedMerge(left.next, right);
		}else {
			result = right;
			result.next = sortedMerge(left, right.next);
		}
		return result;
	}

	private static Node findMiddle(Node head) {
		Node slow= head;
		Node fast = head.next;
		if(head == null) return null;
		while(fast!= null) {
			fast = fast.next;
			if(fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		return slow;
	}

	private static void printLinkedList(Node head) {
		while(head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

}
