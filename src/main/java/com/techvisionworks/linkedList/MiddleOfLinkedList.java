/**
 * 
 */
package com.techvisionworks.linkedList;

import com.techvisionworks.linkedList.linkedList.node;

/**
 * @author nkakki
 *
 */
public class MiddleOfLinkedList {
	
	static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		addNode(new Node(4));
		addNode(new Node(14));
		//addNode(new Node(24));
		//addNode(new Node(34));
		//addNode(new Node(44));
		/*addNode(new Node(42));*/
		//printList(head);
		System.out.println(getMiddle(head).data);
		//deleteMiddle();
		//printList(head);
	}
	 static Node getMiddle(Node h) 
    {
        //Base case
        if (h == null)
            return h;
        Node fastptr = h.next;
        Node slowptr = h;
         
        // Move fastptr by two and slow ptr by one
        // Finally slowptr will point to middle node
        while (fastptr != null)
        {
            fastptr = fastptr.next;
            if(fastptr!=null)
            {
                slowptr = slowptr.next;
                fastptr=fastptr.next;
            }
        }
        return slowptr;
    }
	private static void deleteMiddle() {
		 Node slow = head;
		 Node fast = head;
		 Node slowPrev = null;
		 while(fast != null && fast.next != null) {
			 slowPrev = slow;
			 slow = slow.next;
			 fast = fast.next.next;
		 }
		 slowPrev.next = slow.next;
	}

	private static Node middle() {
		
		Node slow = head;
		Node fast = head;
		if(head != null) {
			while (fast != null && fast.next != null) {
				fast = fast.next.next;
				slow= slow.next;
			}
		}
		return slow;
	}

	private static void addNode(Node node) {
		node.next = head;
		head = node;
	}
	
	public static void printList(Node node) {
		while(node != null)
			{
			System.out.println(node.data);
			node = node.next;
			}
	}

	static class Node {
		int data;
		public Node(int data) {
			super();
			this.data = data;
		}
		Node next;
	}

}
