/**
 * 
 */
package com.techvisionworks.linkedList;

/**
 * @author nkakki
 *
 */
public class IsPalindrome {
	
	static Node left;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		  Node.push(1);
		  Node.push(9);
		  Node.push(2);
		  Node.push(9);
		  Node.push(1);
	        //System.out.println("Linked List without sorting is :");
	       //Node.printList(Node.head);
	 
	        // Apply merge Sort
	        System.out.print("\n is palindrome Linked List is: \n"+isPalindrome(Node.head));
	       // Node.printList(Node.head);
	
	}

	private static boolean isPalindrome(Node head) {
		boolean result = palindrome(head);
		return result;
	}

	private static boolean palindrome(Node right) {
		left  = Node.head;
		
		if(right == null)
			return true;
		
		boolean isP = isPalindrome(right.next);
		if(!isP) return false;
		
			boolean p = (right.data == left.data);
				left = left.next;

			return p;
		
	}

}
