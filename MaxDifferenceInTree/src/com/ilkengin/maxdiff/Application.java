package com.ilkengin.maxdiff;

import java.util.LinkedList;

public class Application {

	public static void main(String[] args) {
		
		TreeNode root = buildTree(new Integer[] {8,3,10,1,6,null,14,null,null,4,7,13});
        MaxDiffCalculator calculator = new MaxDiffCalculator();
        
        System.out.println(calculator.maxAncestorDiff(root));
	}
	
	private static TreeNode buildTree(Integer[] nums) {
		if (nums.length == 0 || nums[0] == null) { return null; }
		LinkedList<TreeNode> queue = new LinkedList<>();
		TreeNode root = new TreeNode(nums[0]);
		queue.add(root);
		
		for(int i = 1; i < nums.length; i++) {
			
			TreeNode node = queue.poll();
			
			if (nums[i] != null) {
				node.left = new TreeNode(nums[i]);
				queue.add(node.left);
			}
			
			i++;
			
			if (i < nums.length && nums[i] != null) {
				node.right = new TreeNode(nums[i]);
				queue.add(node.right);
			}
		}
		
		return root;
	}
}
