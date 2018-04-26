/**
 * 
 */
package com.techvisionworks.linkedList;

/**
 * @author nkakki
 *
 */
public class RemainingResourceExceptSumZero {
	
	static node head;

	static void push(int new_data) 
    {
        /* allocate node */
        node new_node = new node(new_data);
 
        /* link the old list off the new node */
        new_node.next = head;
 
        /* move the head to point to the new node */
        head = new_node;
    }
 
    // Utility function to print the linked list
    static void printList(node headref) 
    {
        while (headref != null) 
        {
            System.out.print(headref.val + " ");
            headref = headref.next;
        }
    }
     
    public static void main(String[] args) 
    {
 
        /*
         * Let us create a unsorted linked lists to test the functions Created
         * lists shall be a: 2->3->20->5->10->15
         */
       push(15);
       push(10);
       push(-5);
       push(5);
       push(-30);
       push(10);
       push(20);
        System.out.println("Linked List without sorting is :");
       printList(head);
 
        // Apply merge Sort
       head = removeZeroSum(head);
        System.out.print("\n Sorted Linked List is: \n");
       printList(head);
    }
    public static node removeZeroSum(node head2) {
		int currentSum = 0;
		node start = head2;
		node current = head2;
		while(current != null) {
			currentSum += current.val;
			if(currentSum == 0) {
				start = current.next;
				current = start;
				}else {
					current = current.next;
				}
		}
		
		return start;
	}
    
 // node a,b;
    static class node 
    {
        int val;
        node next;
 
        public node(int val) 
        {
            this.val = val;
        }
    }
}
