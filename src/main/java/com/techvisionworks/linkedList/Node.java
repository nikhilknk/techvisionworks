/**
 * 
 */
package com.techvisionworks.linkedList;

import com.techvisionworks.linkedList.RemainingResourceExceptSumZero.node;

/**
 * @author nkakki
 *
 */
public class Node {
	
	int data;
	public Node(int data) {
		super();
		this.data = data;
	}
	Node next;
	static Node head;
	static void push(int new_data) 
    {
        /* allocate node */
		Node new_node = new Node(new_data);
 
        /* link the old list off the new node */
        new_node.next = head;
 
        /* move the head to point to the new node */
        head = new_node;
    }
	
	public static void printList(Node node) {
		while(node != null)
			{
			System.out.println(node.data);
			node = node.next;
			}
	}
}
