/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.TreeNode;

/**
 * @author nkakki
 *
 */
public class KDistanceFromNode {

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
		
		printKDistance(root,root.getLeft(),2);
	}

	private static int printKDistance(TreeNode root,TreeNode target, int k) {
		if(root == null) return -1;

		if(root == target)
		{
			printKDistanceDown(root,k);
			return 0;
		}

		int d1 = printKDistance(root.getLeft(),target, k);

		if(d1 != -1) {
			if(d1+1 == k)
			{
				System.out.println(root.getValue());
			}else {
				printKDistanceDown(root.getRight(), k-d1-2);
			}
			return 1+d1;
		}

		int dr = printKDistance(root.getRight(),target, k);

		if(dr != -1) {
			if(dr+1 == k)
			{
				System.out.println(root.getValue());
			}else {
				printKDistanceDown(root.getLeft(), k-dr-2);
			}
			return 1+dr;
		}
		return -1;
	}

	private static void printKDistanceDown(TreeNode root, int k) {
		
		if(root == null) return;
		
		if(k==0) {
			System.out.println(root.getValue());
			return;
		}
		printKDistanceDown(root.getLeft(), k-1);
		printKDistanceDown(root.getRight(), k-1);
	}

}
