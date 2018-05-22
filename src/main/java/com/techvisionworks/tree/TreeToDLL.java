/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.DLLNode;
import com.techvision.common.TreeNode;

/**
 * @author nkakki
 *
 */
public class TreeToDLL {

	static TreeNode prev= null;
	static TreeNode head;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));

		DLL(root);
		TreeNode current = head;
		while(current != null)
			{
				System.out.println(current.getValue());
				current = current.getRight();
			}
	}

	private static void DLL(TreeNode root) {
		if(root == null) return;
		
		DLL(root.getLeft());
		if(prev == null)
			{
				head = root;
			}
		else {
			root.setLeft(prev);
			prev.setRight(root);
		}
		prev  = root;
		DLL(root.getRight());
	}

}
