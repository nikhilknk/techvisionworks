/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class PreOrderSuccessorOfBST {

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
		System.out.println("pre order successor is.." + getPreorderSuccessor(root,1));
	}

	private static int preOrderSuccesor(TreeNode root, int i, TreeNode store) {
			if(root.getValue() == i && root.getLeft() != null)
				return root.getLeft().getValue();
			else if(root.getValue() == i && root.getLeft() == null) {
				TreeNode temp = store.getRight();
				return temp.getValue();
			}else if(root.getValue() > i) {
				return preOrderSuccesor(root.getLeft(), i, root);
			}else if(root.getValue() < i) {
				return preOrderSuccesor(root.getRight(), i, store);
			}
		return -1;
	}
	
	public static TreeNode getPreorderSuccessor(TreeNode root, int val){
	    if( root == null || (root.getLeft() == null && root.getRight() == null))
	        return null;
	    TreeNode temp = root;
	    TreeNode ancestor = null;
	    while(temp != null && temp.getValue() != val){
	        if(val < temp.getValue()){
	            if(temp.getRight() != null){
	                ancestor = temp;
	            }
	            temp = temp.getLeft();
	        }else{
	            temp = temp.getRight();
	        }
	    }
	    // node not found case
	    if(temp == null)
	        return null;
	    if(temp.getLeft() != null)
	        return temp.getLeft();
	    if(temp.getRight() != null)
	        return temp.getRight();
	    if(ancestor != null)
	        return ancestor.getRight();
	    return null;
	}

}
