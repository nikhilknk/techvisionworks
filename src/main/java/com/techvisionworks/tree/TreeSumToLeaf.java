/**
 * 
 */
package com.techvisionworks.tree;

import java.util.ArrayList;
import java.util.List;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class TreeSumToLeaf {

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

		List<Integer> result = new ArrayList<>();
		int sum = 11;
		
		recur(root,sum,result);
		
		if(result.size()>0)
		result.forEach(System.out::println);
		else 
			System.out.println("no success");
				
	}

	private static boolean recur(TreeNode root, int sum, List<Integer> result) {
		if(root == null) 
			return false ;
		else {
			boolean ans = false;
			if(root.getLeft() == null && root.getRight() == null)
			{
				if(sum==root.getValue()) {
					result.add(root.getValue());
					ans = true;
					return true;
				}
			}

			if(root.getLeft() != null) {
				ans=  recur(root.getLeft(), sum-root.getValue(), result);
				if(ans)
					result.add(root.getValue());
			}

			if(root.getRight() != null) {
				ans =  recur(root.getRight(), sum-root.getValue(), result);
				if(ans)
					result.add(root.getValue());
			}
			return ans;
		}
	}

}
