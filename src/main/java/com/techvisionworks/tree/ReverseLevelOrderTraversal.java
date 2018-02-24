package com.techvisionworks.tree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import com.techvision.common.TreeNode;

public class ReverseLevelOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));

		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Queue<TreeNode> queue = new LinkedList<>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode node = queue.poll();
			if(node.getRight() != null)
				queue.add(node.getRight());
			if(node.getLeft() != null)
				queue.add(node.getLeft());
			stack.push(node);
		}
		
		 while (stack.empty() == false) 
	        {
	            System.out.print(stack.pop().getValue() + " ");
	        }
	}

}
