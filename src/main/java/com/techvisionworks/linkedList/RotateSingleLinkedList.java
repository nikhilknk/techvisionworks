/**
 * 
 */
package com.techvisionworks.linkedList;

import com.techvision.common.Node;

/**
 * @author nkakki
 *
 */
public class RotateSingleLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = new Node(4);
		Node node = new Node(5);
		Node node1 = new Node(6);
		Node node2 = new Node(7);
		head.setNext(node);
		node.setNext(node1);
		node1.setNext(node2);
		
		/*Node current = head.getNext();
		Node prev = head;
		
		while(current != null) {
			prev.setNext(current.getNext());
			current.setNext(head);
			head = current;
			current = prev.getNext();
		}
		
		System.out.println(head.getData());*/
		
		Node n = reverse(head);
		while(n != null) {
		System.out.println(n.getData());
		n = n.getNext();	
		}
	}

	private static Node reverse(Node head) {
			Node prev = null;;
			Node current = head;
			Node next = null;
			while(current != null) {
				next = current.getNext();
				current.setNext(prev);
				prev = current;
				current = next;
			}
		return prev;
	}

	/*private static Node reverse(Node head) {
		
		if(head.getNext() == null)
			return head;
			
			Node temp = reverse(head.getNext());
			head.setNext(null);
			temp.setNext(head);
			
			return temp;
	}*/

}
