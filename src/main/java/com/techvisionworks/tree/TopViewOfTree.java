package com.techvisionworks.tree;

import java.util.HashMap;
import java.util.Map;

import com.techvision.common.TreeNode;

public class TopViewOfTree {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));
		Map<Integer,Integer> topViewMap = new HashMap<>();
		topViewMap(root,topViewMap,0);
		topViewMap.entrySet().forEach(x->{
			System.out.println(x.getValue());
		});
	}

	private static void topViewMap(TreeNode root, Map<Integer, Integer> topViewMap,int height) {
		if(root != null) {
			if(!topViewMap.containsKey(height))
				topViewMap.put(height, root.getValue());
			if(root.getLeft() != null) {
				topViewMap(root.getLeft(),topViewMap,height-1);
			}
				
			if(root.getRight() != null)
				topViewMap(root.getRight(),topViewMap,height+1);
		}
	}

}
