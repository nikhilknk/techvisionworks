/**
 * 
 */
package com.techvisionworks.linkedList;

/**
 * @author nikhil.k
 *
 */
public class RotateFirstKElements {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		  Node.push(19);
		  Node.push(92);
		  Node.push(93);
		  Node.push(1);
	        System.out.println("Linked List without sorting is :");
	       Node.printList(Node.head);
	 
	        // Apply merge Sort
	       Node.head = rotate(Node.head,3);
	        System.out.print("\n Sorted Linked List is: \n");
	        Node.printList(Node.head);
	
	}

	private static Node rotate(Node head, int k) {
		Node current = head;
		for(int i = 1 ; i < k ; i++) {
			current = current.next;
		}
		//current.next = null;
		Node kthNode = current;
		current = current.next;
		Node temphead = current;
		while(current.next != null) {
			current = current.next;
		}
		current.next = head;
		kthNode.next = null;
		return temphead;
	}

}
