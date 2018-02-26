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
public class IterativeInOrderTraversal {

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
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode node = root;
		while(true) {
			if(node != null) {
				stack.push(node);
				node = node.getLeft();
			}else {
				if(stack.isEmpty()) break;
				node = stack.pop();
				System.out.println(node.getValue());
				node = node.getRight();
			}
		}
	}

}
