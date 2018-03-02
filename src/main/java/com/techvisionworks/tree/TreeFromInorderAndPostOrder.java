/**
 * 
 */
package com.techvisionworks.tree;

import java.util.Arrays;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class TreeFromInorderAndPostOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int in[] = new int[]{4, 8, 2, 5, 1, 6, 3, 7};
        int post[] = new int[]{8, 4, 5, 2, 6, 7, 3, 1};
        
        TreeNode root =  formTree(in,post,0,in.length-1);
        preOrder(root);
        //System.out.println(root.getValue());
	}

	private static TreeNode formTree(int[] in, int[] post,int start,int end) {
		
		if(start>end) return null;
		
		TreeNode root =  new TreeNode(post[end]);
		int rootIndex = findRootIndex(in,post[end]);
		
		root.setLeft(formTree(in, post,start,rootIndex));
		root.setRight(formTree(in, post,rootIndex+1,end));
		return root;
	}

	private static int findRootIndex(int[] in, int i) {
		for (int j = 0; j < in.length; j++) {
			if(in[j]==i)
				return j;
		}
		return -1;
	}
	 static void preOrder(TreeNode node) 
	    {
	        if (node == null)
	            return;
	        System.out.print(node.getValue() + " ");
	        preOrder(node.getLeft());
	        preOrder(node.getRight());
	    }
}
