package com.techvisionworks.tree;

import java.util.LinkedList;
import java.util.Queue;

import com.techvision.common.TreeNode;

public class HeightOfTreeIteratively {

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);
		root.setLeft(new TreeNode(2));
		root.setRight(new TreeNode(3));
		root.getLeft().setLeft(new TreeNode(4));
		root.getLeft().setRight(new TreeNode(5));
		root.getRight().setLeft(new TreeNode(6));
		root.getRight().setRight(new TreeNode(7));


		int height = 0;
		int nodeCount = 0;
		Queue<TreeNode> queue = new LinkedList<>();

		queue.add(root);

		while(queue.size()>0) {
			nodeCount = queue.size();
			height++;
			while(nodeCount>0) {
				TreeNode node = queue.poll();

				if(node.getLeft() != null)
					queue.add(node.getLeft());
				if(node.getRight() != null)
					queue.add(node.getRight());
				nodeCount--;
			}
		}
		System.out.println("height is ::"+height);
	}

}
 