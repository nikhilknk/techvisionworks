/**
 * 
 */
package com.techvisionworks.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class IterativePreOrderTraversal {

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
		
		Set<TreeNode> visited = new HashSet<>();
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(root);
		
		while(!stack.isEmpty()) {
			TreeNode node = stack.pop();
			if(node.getRight()!=null)
				stack.push(node.getRight());
			if(node.getLeft()!=null)
				stack.push(node.getLeft());
			System.out.println(node.getValue());
		}
	}

}
