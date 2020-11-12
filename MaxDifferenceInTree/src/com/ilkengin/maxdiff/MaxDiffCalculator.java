package com.ilkengin.maxdiff;

import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class MaxDiffCalculator {
	    public int maxAncestorDiff(TreeNode root) {
	        List<TreeNode> ancestors = new ArrayList<>();
	        return maxAncestorDiff(root, ancestors);
	    }

	    private int maxAncestorDiff(TreeNode root, List<TreeNode> ancestors) {
	        if (root == null) {
	            return 0;
	        }
	        
	        int max = 0;
	        
	        for(TreeNode ancestor: ancestors) {
	            max = Math.max(max, Math.abs(ancestor.val - root.val));
	        }
	        
	        ancestors.add(root);
	        max = Math.max(max, maxAncestorDiff(root.left, ancestors));
	        max = Math.max(max, maxAncestorDiff(root.right, ancestors));
	        ancestors.remove(ancestors.size() - 1);
	        
	        return max;
	    }
	}
