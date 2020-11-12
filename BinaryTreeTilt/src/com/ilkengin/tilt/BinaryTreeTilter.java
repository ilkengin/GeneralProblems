package com.ilkengin.tilt;

public class BinaryTreeTilter {

    public int findTilt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftTilt = findTilt(root.left);
        int rightTilt = findTilt(root.right);
        
        int currentTilt = Math.abs((root.left != null ? root.left.val : 0) 
                                   - (root.right != null ? root.right.val : 0));
        
        root.val = root.val 
            +  (root.left != null ? root.left.val : 0)
            + (root.right != null ? root.right.val : 0);
        
        return leftTilt + rightTilt + currentTilt;
    }
	
}
