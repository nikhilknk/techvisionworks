package com.techvisionworks.tree;

import java.util.Stack;

import com.techvision.common.TreeNode;

public class IsBTaBST {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		//System.out.println(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE));
	System.out.println(isBSTIterative(root));
	}

	private static boolean isBST(TreeNode root,int min,int max) {
		if(root == null) return true;
		if(root.getValue()>max||root.getValue()<min) return false;
		
		return isBST(root.getLeft(), min, root.getValue()) && isBST(root.getRight(), root.getValue(), max);
		
	}
	
	private static boolean isBSTIterative(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		int prev = Integer.MIN_VALUE;
		TreeNode current=null; 
		TreeNode node=root; 
		while(true) {
			if(node != null) {
				stack.push(node);
				node = node.getLeft();
			}else {
				if(stack.isEmpty())
					break;
				current = stack.pop();
				if(current.getValue()<prev) return false;
				prev = current.getValue();
				if(current.getRight() != null) node = current.getRight();
			}
		}
		return true;

	}

}
