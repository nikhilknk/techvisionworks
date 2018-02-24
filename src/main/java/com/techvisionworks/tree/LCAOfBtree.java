package com.techvisionworks.tree;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.techvision.common.TreeNode;

public class LCAOfBtree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		Set<Integer> topList = new HashSet<>();
		printTopView(root, true, topList);
		printTopView(root, false, topList);
		System.out.println("LCA is "+ LCA(4,5,root));
	}

	private static int LCA(int i, int j,TreeNode root) {
		if(root.getValue() == i || root.getValue() == j)
			return root.getValue();
		else if(i < root.getValue() && j >root.getValue() || i > root.getValue() && j < root.getValue()) 
			return root.getValue();
		else if(i < root.getValue() && j < root.getValue())
			return LCA(i,j,root.getLeft());
		else 
		return LCA(i,j,root.getRight());
	}
	
	private static void printTopView(TreeNode node,boolean leftTraversal,Set<Integer> topList) {
		if(leftTraversal && node != null &&  node.getLeft() != null)
			printTopView(node.getLeft(), leftTraversal, topList);
		if(!leftTraversal && node != null &&  node.getRight() != null)
			printTopView(node.getRight(), leftTraversal, topList);
		
		topList.add(node.getValue());
		
	}

}
