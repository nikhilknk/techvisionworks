/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.TreeNode;

/**
 * @author nkakki
 *
 */
public class RightViewOfTree {
	static int max  = 0; 

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

		
		int level = 1;
		printRighttView(root,level);
	
	}

	private static void printRighttView(TreeNode root, int level) {
		if(root == null) return;
		
		if(max<level)
			{
				System.out.println(root.getValue());
				max = level;
			}
		
		printRighttView(root.getRight(), level+1);
		printRighttView(root.getLeft(), level+1);
	}

}
