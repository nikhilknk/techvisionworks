/**
 * 
 */
package com.techvisionworks.tree;

import java.util.HashMap;
import java.util.Map;

import com.techvision.common.TreeNode;

/**
 * @author nkakki
 *
 */
public class BottomViewOfTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(20);
		root.setLeft(new TreeNode(8));
		root.setRight(new TreeNode(22));
		root.getLeft().setLeft(new TreeNode(5));
		root.getLeft().setRight(new TreeNode(3));
		root.getRight().setLeft(new TreeNode(25));
		root.getLeft().getRight().setLeft(new TreeNode(10));
		root.getLeft().getRight().setRight(new TreeNode(14));
		Map<Integer,Integer> bottomViewMap = new HashMap<>();
		bottomViewMap(root,bottomViewMap,0);
		bottomViewMap.entrySet().forEach(x->{
			System.out.println(x.getValue());
		});
	}

	private static void bottomViewMap(TreeNode root, Map<Integer, Integer> bottomViewMap,int height) {
		if(root != null) {
			bottomViewMap.put(height, root.getValue());
			
			if(root.getLeft() != null) {
				bottomViewMap(root.getLeft(),bottomViewMap,height-1);
			}
				
			if(root.getRight() != null)
				bottomViewMap(root.getRight(),bottomViewMap,height+1);
		}
	}

}
