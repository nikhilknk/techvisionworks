/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class InorderSuccessorOfBST {

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
		System.out.println("inorder successor is.." + inorderSuccesor(root,2,null));
	}

	private static int inorderSuccesor(TreeNode root, int i,TreeNode store) {
		if(root.getValue() == i && root.getRight() != null) {
			TreeNode temp = root.getRight();
			while(temp != null && temp.getLeft() != null) {
				temp = temp.getLeft();
			}
			return temp.getValue();
		}else if(root.getValue() == i && root.getRight() == null){
			return store.getValue();
		}else if(root.getValue() > i) {
			store = root;
			return inorderSuccesor(root.getLeft(), i,root);
		}else if(root.getValue() < i) {
			return inorderSuccesor(root.getRight(), i,null);
		}
		return i;
	}

}
