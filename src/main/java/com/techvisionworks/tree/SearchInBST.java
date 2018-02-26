/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class SearchInBST {

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
		
		System.out.println(search(root,7).getValue());
	}

	private static TreeNode search(TreeNode root, int i) {
		if(root == null)
			return null;
		if(root.getValue()==i)
			return root;
		
		if(root.getValue()<i)
			return search(root.getRight(), i);
		else
			return search(root.getLeft(), i);
	}

}
