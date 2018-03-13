/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class PostOrderSuccessorOfBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(6));
		root.getLeft().setLeft(new TreeNode(1));
		root.getLeft().setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(5));
		root.getRight().setRight(new TreeNode(7));
		System.out.println("inorder successor is.." + postorderSuccesor(root,2,null));
	}

	private static String postorderSuccesor(TreeNode root, int i, Object object) {
		return null;
	}

}
