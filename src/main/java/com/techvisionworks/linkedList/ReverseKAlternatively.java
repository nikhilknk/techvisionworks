/**
 * 
 */
package com.techvisionworks.linkedList;

/**
 * @author nkakki
 *
 */
public class ReverseKAlternatively {

	public static void main(String[] args) {
		Node.push(1);
		  Node.push(2);
		  Node.push(3);
		  Node.push(4);
		  Node.push(5);
		  Node.push(6);
		  Node.push(7);
		  Node.push(8);
		  Node.push(9);
		  System.out.println("before rotation");
		  Node.printList(Node.head);
		  Node head = rotateK(Node.head,3);
		  System.out.println("after rotation");
		  Node.printList(head);
	}

	private static Node rotateK(Node head,int k) {
		Node prev= null;
		Node current = head;
		Node next = null;
		for(int i = 0 ; i< k ; i++) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head.next = current;
		for(int i = 0 ; i< k ; i++) {
			current = current.next;
		}
		
		 if (next != null) {
	            current.next = rotateK(current.next, k);;
	        }
		 
        return prev;
	}


}
