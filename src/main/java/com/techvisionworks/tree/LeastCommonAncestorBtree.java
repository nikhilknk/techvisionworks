/**
 * 
 */
package com.techvisionworks.tree;

import java.util.HashSet;
import java.util.Set;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class LeastCommonAncestorBtree {

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

		TreeNode node = LCA(root,2,7);
		System.out.println(node.getValue());
	}

	private static TreeNode LCA(TreeNode root, int i, int j) {
		if(root==null)return null;
		if(root.getValue() == i || root.getValue() == j)
			return root;
		TreeNode leftNode = LCA(root.getLeft(),i,j);
		TreeNode rightNode = LCA(root.getRight(),i,j);
		
		if(leftNode != null && rightNode != null)
			return root;
		
		return leftNode != null ? leftNode : rightNode;
	}

}
