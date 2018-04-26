/**
 * 
 */
package com.techvisionworks.linkedList;

/**
 * @author nikhil
 *
 */
public class FindCircularPoint {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Node.push(19);
		 Node.push(11);
		  Node.push(9);
		  Node.push(5);
		  Node.push(3);
		  Node.push(1);
		  Node fiveNode = Node.head.next.next;
		  Node last =  Node.head.next.next.next.next.next;
		  last.next = fiveNode;
		  
	        System.out.println("Linked List without sorting is :");
	       //Node.printList(Node.head);
	 
	        // Apply merge Sort
	       findCircularPoint(Node.head);
	}

	private static int findCircularPoint(Node head) {
		Node slow = head;
		Node fast = head;
		while(slow != null && fast != null && fast.next != null ) {
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				//System.out.println("circlar point at " + slow.data);
				removeLoop(slow,head);
				return 1;
			}
		}
		return 0;
	}
	private static void removeLoop(Node slow, Node head) {
		while(slow.data != head.data) {
			if(slow.data == head.data)
			{
				System.out.println("circlar point at " + slow.data);
			}else {
				slow = slow.next;
				head = head.next;
			}
		}
		
		head = slow.next;
		while(head.next != slow) {
			head = head.next;
		}
		head.next = null;
		System.out.println("removed loop");
		Node.printList(Node.head);
	}

}
