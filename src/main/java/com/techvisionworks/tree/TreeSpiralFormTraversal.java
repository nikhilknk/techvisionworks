package com.techvisionworks.tree;

import java.util.Stack;

import com.techvision.common.TreeNode;

public class TreeSpiralFormTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));

		Stack<TreeNode> sleft = new Stack<>();
		Stack<TreeNode> sright = new Stack<>();
		
		sleft.push(root);
		
		while(!sleft.isEmpty() || !sright.isEmpty()) {
			
			while(!sleft.isEmpty()) {
				TreeNode node = sleft.pop();
				
				if(node.getLeft() != null)
					sright.push(node.getLeft());
				if(node.getRight() != null)
					sright.push(node.getRight());
				System.out.println(node.getValue());
				
			}
			
			while(!sright.isEmpty()) {
				TreeNode node = sright.pop();
				
				if(node.getRight() != null)
					sleft.push(node.getRight());
				if(node.getLeft() != null)
					sleft.push(node.getLeft());
				System.out.println(node.getValue());
				
			}
		}
	}

}
