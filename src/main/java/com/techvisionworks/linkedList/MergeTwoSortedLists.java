/**
 * 
 */
package com.techvisionworks.linkedList;

import com.techvision.common.Node;

/**
 * @author nkakki
 *
 */
public class MergeTwoSortedLists {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head1 = new Node(6);
		Node head2 = new Node(3);
		Node node11 = new Node(10);
		Node node12 = new Node(18);
		Node node21 = new Node(8);
		Node node22 = new Node(24);
		head1.setNext(node11);
		node11.setNext(node12);
		head2.setNext(node21);
		node21.setNext(node22);
		
		Node head = mergeRecur(head1,head2);
		printLinkedList(head);
	}

	private static void printLinkedList(Node head) {
		while(head != null) {
			System.out.println(head.getData());
			head = head.getNext();
		}
	}

	private static Node mergeRecur(Node head1, Node head2) {
		if(head1 == null)
			return head2;
		else if(head2 == null)
			return head1;
		Node result = null;
		if(head1.getData() <= head2.getData()) {
			result = head1;
			result.setNext(mergeRecur(head1.getNext(), head2));
		}else {
			result = head2;
			result.setNext(mergeRecur(head1, head2.getNext()));
		}
		return result;
	}

}
