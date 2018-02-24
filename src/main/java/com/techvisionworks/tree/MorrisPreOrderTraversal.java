package com.techvisionworks.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.techvision.common.TreeNode;

public class MorrisPreOrderTraversal {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		
		TreeNode current = root;
		HashSet<TreeNode> visited = new HashSet<>();
		
		while(current != null) {
			
			if(!visited.contains(current))
			{
				visited.add(current);
				System.out.println(current.getValue());
			}
			
			//if(current.getLeft() != null)

			
		}
		
	}

}
