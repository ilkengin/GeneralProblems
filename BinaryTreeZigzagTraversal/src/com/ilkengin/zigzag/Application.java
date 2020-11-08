package com.ilkengin.zigzag;

import java.util.LinkedList;

public class Application {

	public static void main(String[] args) {
        ZigzagTraversal zigzagTraversal = new ZigzagTraversal();
        TreeNode root = buildTree(new Integer[] { 3,9,20,null,null,15,7 });
        System.out.println(zigzagTraversal.zigzagLevelOrder(root));
	}
	
	private static TreeNode buildTree(Integer[] tree) {
		LinkedList<TreeNode> queue = new LinkedList<>();
		
		TreeNode root = new TreeNode(tree[0]);
		queue.add(root);

		for(int i = 1; i < tree.length; i++) {
			TreeNode node = queue.remove();
			if (tree[i] != null) {
				TreeNode newNode = new TreeNode(tree[i]);
				node.left = newNode;
				queue.add(newNode);
			}
			i++;
			if (i < tree.length && tree[i] != null) {
				TreeNode newNode = new TreeNode(tree[i]);
				node.right = newNode;
				queue.add(newNode);
			}
		}
		
		return root;
	}
}
