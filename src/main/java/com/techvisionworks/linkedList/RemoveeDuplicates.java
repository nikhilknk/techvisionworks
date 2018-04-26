package com.techvisionworks.linkedList;

import com.techvisionworks.linkedList.MiddleOfLinkedList.Node;
import com.techvisionworks.linkedList.RemainingResourceExceptSumZero.node;

public class RemoveeDuplicates {
	static Node head = null;
	
	static void push(int new_data) 
    {
        /* allocate node */
		Node new_node = new Node(new_data);
 
        /* link the old list off the new node */
        new_node.next = head;
 
        /* move the head to point to the new node */
        head = new_node;
    }
	public static void main(String[] args) {
		   push(15);
	       push(15);
	       push(-5);
	       push(-5);
	       push(-30);
	       push(-30);
	       push(-30);
	        System.out.println("Linked List without sorting is :");
	       printList(head);
	 
	        // Apply merge Sort
	       head = removeDuplicates(head);
	        System.out.print("\n Sorted Linked List is: \n");
	       printList(head);
	}
	static Node removeDuplicates(Node head)
    {
        if(head == null) return null;
        Node current = head;
        
        Node currentNext = current.next;
        while(currentNext != null){
            if(currentNext.data == current.data){
                Node temp = currentNext.next;
                currentNext.next = null;
                current.next = temp;
                currentNext = temp;
            }else {
            current = current.next;
            }
        }
        return head;
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
