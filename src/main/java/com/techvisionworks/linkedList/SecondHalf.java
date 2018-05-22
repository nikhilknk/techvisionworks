/**
 * 
 */
package com.techvisionworks.linkedList;

import java.util.Stack;

/**
 * @author nkakki
 *
 */
public class SecondHalf {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 Node.push(1);
		  Node.push(2);
		  Node.push(3);
		  Node.push(4);
		  Node.push(5);
	        System.out.println("Linked List without sorting is :");
	       Node.printList(Node.head);
	       updateLinkedList(Node.head);
	       System.out.println("Linked List after sorting is :");
	       Node.printList(Node.head);
	}
	
	public static Node updateLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        Stack<Node> stack = new Stack<Node>();

        while (fast != null){
            stack.push(slow);
            fast = fast.next;
            if (fast != null) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        System.out.println("slow ");
        while(slow != null) {
            Node temp = stack.pop();
            slow.data =  temp.data + slow.data;
            slow = slow.next;
        }

        return head;
    }

}
