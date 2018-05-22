/**
 * 
 */
package com.techvisionworks.tree;

/**
 * @author nkakki
 *
 */
public class AVLTree {
	
	static AVLNode head;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		insert(10);
		insert(20);
		insert(30);
		insert(40);
		insert(50);
		inOrder(head);
	}

	private static void inOrder(AVLNode head) {
		if(head == null)
			return;

		inOrder(head.getLeft());
		System.out.println(head.getVal());
		inOrder(head.getRight());
	}

	private static void insert(int i) {
		insert(i,head);		
	}

	private static AVLNode insert(int value,AVLNode head) {
		if(head == null)
			head = new AVLNode(value, 0,1, null, null);
		else {
			if(head.getVal() < value)
				head.right = insert(value, head.getRight());
			else
				head.left = insert(value,head.getLeft());
		}
		
		head.balance = head.left.balance - head.right.balance;
		head.height = Math.max(head.left.height,head.right.height)+1;
		
		if(head.balance > 1) {
			if(value<head.left.val)
				head = rightRotate(head);
			else
				head.left = leftRotate(head.left);
				head = rightRotate(head);
		}else if(head.balance < -1){
			if(value > head.right.val)
				head = leftRotate(head);
			else
				head.right = rightRotate(head.right);
				head = leftRotate(head);
		}
		return head;
	}

	private static AVLNode leftRotate(AVLNode head) {
		AVLNode headLeft = head.left;
		head.left = headLeft.right;
		headLeft.right = head;
		
		head.height = Math.max(head.left.height, head.right.height)+1;
		headLeft.height = Math.max(headLeft.left.height, headLeft.right.height)+1;
		return headLeft;
	}

	private static AVLNode rightRotate(AVLNode head) {

		AVLNode headRight = head.right;
		head.right = headRight.left;
		headRight.left = head;
		
		head.height = Math.max(head.left.height, head.right.height)+1;
		headRight.height = Math.max(headRight.left.height, headRight.right.height)+1;
		return headRight;
	
	}

	static class AVLNode{
		int val;
		int balance;
		int height;
		AVLNode left;
		/**
		 * @return the height
		 */
		public int getHeight() {
			return height;
		}
		/**
		 * @param height the height to set
		 */
		public void setHeight(int height) {
			this.height = height;
		}
		AVLNode right;
		/**
		 * @return the val
		 */
		public int getVal() {
			return val;
		}
		public AVLNode(int val, int balance,int height, AVLNode left, AVLNode right) {
			super();
			this.val = val;
			this.balance = balance;
			this.height = height;
			this.left = left;
			this.right = right;
		}
		/**
		 * @param val the val to set
		 */
		public void setVal(int val) {
			this.val = val;
		}
		/**
		 * @return the balance
		 */
		public int getBalance() {
			return balance;
		}
		/**
		 * @param balance the balance to set
		 */
		public void setBalance(int balance) {
			this.balance = balance;
		}
		/**
		 * @return the left
		 */
		public AVLNode getLeft() {
			return left;
		}
		/**
		 * @param left the left to set
		 */
		public void setLeft(AVLNode left) {
			this.left = left;
		}
		/**
		 * @return the right
		 */
		public AVLNode getRight() {
			return right;
		}
		/**
		 * @param right the right to set
		 */
		public void setRight(AVLNode right) {
			this.right = right;
		}
	}
}
