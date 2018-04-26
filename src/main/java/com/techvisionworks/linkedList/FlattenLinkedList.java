/**
 * 
 */
package com.techvisionworks.linkedList;

import com.techvisionworks.linkedList.MiddleOfLinkedList.Node;

/**
 * @author nkakki
 *
 */
public class FlattenLinkedList {
	
	static Node head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 head = add(head, 30);
	        head = add(head, 8);
	        head = add(head, 7);
	        head = add(head, 5);
	 
	        head.right = add(head.right, 20);
	        head.right = add(head.right, 10);
	 
	        head.right.right = add(head.right.right, 50);
	        head.right.right = add(head.right.right, 22);
	        head.right.right = add(head.right.right, 19);
	 
	        head.right.right.right = add(head.right.right.right, 45);
	        head.right.right.right = add(head.right.right.right, 40);
	        head.right.right.right = add(head.right.right.right, 35);
	        head.right.right.right = add(head.right.right.right, 28);
	        head =  flattenLinkedList(head);
		printList(head);
		//System.out.println(middle().data);
	}
	
	private static Node flattenLinkedList(Node root) {
		if(root == null || root.right == null)
			return root;
		
		root.right = flattenLinkedList(root.right);
		
		root = mergeRecur(root, root.right);
		
		return root;
	}
	
	private static Node mergeRecur(Node head1, Node head2) {
		if(head1 == null)
			return head2;
		else if(head2 == null)
			return head1;
		Node result = null;
		if(head1.data <= head2.data) {
			result = head1;
			result.down = (mergeRecur(head1.down, head2));
		}else {
			result = head2;
			result.down = (mergeRecur(head1, head2.down));
		}
		return result;
	}

	private static Node middle() {
		
		Node slow = head;
		Node fast = head;
		if(head != null) {
			while (fast != null && fast.right != null) {
				fast = fast.right.right;
				slow= slow.right;
			}
		}
		return slow;
	}

	private static Node add(Node node,int data) {
		Node temp = new Node(data);
		temp.down = node;
		node = temp;
		return node;
	}
	
	public static void printList(Node node) {
		while(node != null)
			{
			System.out.println(node.data);
			node = node.down;
			}
	}

	static class Node {
		int data;
		public Node(int data) {
			super();
			this.data = data;
			right = null;
			down = null;
		}
		Node right;
		Node down;
	}

}
