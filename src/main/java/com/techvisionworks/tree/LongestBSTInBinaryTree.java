/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.TreeNode;

/**
 * @author nikhil.k
 *
 */
public class LongestBSTInBinaryTree {

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
		
		System.out.println(longestBST(root).getSize());
		
	}
	
	private static MinMax longestBST(TreeNode root) {
		if(root != null && (root.getLeft() == null && root.getRight()==null))
			return new MinMax(1,true,root.getValue(),root.getValue());
		
		MinMax leftMinMax = longestBST(root.getLeft());
		MinMax rightMinMax = longestBST(root.getRight());
		
		if(!leftMinMax.isBst() || !rightMinMax.isBst() || root.getValue() < leftMinMax.max || root.getValue() > rightMinMax.getMin())
			return new MinMax(Math.max(leftMinMax.getSize(), rightMinMax.getSize()));
		
		int min = root.getLeft() == null ? leftMinMax.getMin() : root.getValue(); 
		int max =  root.getRight() != null ? rightMinMax.min : root.getValue(); 
		
		return new MinMax(leftMinMax.getSize()+rightMinMax.getSize()+1,true,min,max );
	}

	static class MinMax{
		int min;
		int max;
		public MinMax(int size, boolean bst, int min, int max) {
			super();
			this.size = size;
			this.bst = bst;
			this.min = min;
			this.max = max;
		}
		int size;
		boolean bst;
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public MinMax() {
		}
		public MinMax(int size) {
			super();
			this.size = size;
		}
		public int getMax() {
			return max;
		}
		public void setMax(int max) {
			this.max = max;
		}
		public int getSize() {
			return size;
		}
		public void setSize(int size) {
			this.size = size;
		}
		public boolean isBst() {
			return bst;
		}
		public void setBst(boolean bst) {
			this.bst = bst;
		}
	}
}
