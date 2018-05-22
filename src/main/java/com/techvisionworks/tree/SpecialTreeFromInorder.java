/**
 * 
 */
package com.techvisionworks.tree;

import com.techvision.common.TreeNode;

/**
 * @author nkakki
 *
 */
public class SpecialTreeFromInorder {
	static TreeNode head = null;
	static int index = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int pre[] = new int[]{10, 30, 20, 5, 15};
        char preLN[] = new char[]{'N', 'N', 'L', 'L', 'L'};
        int n = pre.length;
        
        // construct the above tree
        TreeNode mynode = constructTree(pre, preLN, n, head);
        // Test the constructed tree
        System.out.println("Following is Inorder Traversal of the" 
                                      + "Constructed Binary Tree: ");
        printInorder(mynode);
	}

	private static TreeNode constructTree(int[] pre, char[] preLN, int n, TreeNode head) {
			if(index == n)
				return null;
			head = new TreeNode(pre[index]);
			int tempIndex = index;
			index++;
			if(preLN[tempIndex] == 'N') {
				head.setLeft(constructTree(pre, preLN, n, head.getLeft()));
				head.setRight(constructTree(pre, preLN, n, head.getRight()));
			}
		return head;
	}

	private static void printInorder(TreeNode mynode) {
		if (mynode == null)
            return;
		printInorder(mynode.getLeft());
		System.out.println(mynode.getValue());
		printInorder(mynode.getRight());
	}

}
