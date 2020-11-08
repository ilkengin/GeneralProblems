package com.ilkengin.zigzag;

import java.util.List;
import java.util.LinkedList;
import java.util.Stack;
import java.util.ArrayList;

public class ZigzagTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        List<List<Integer>> res = new ArrayList<>();
        
        if (root == null) {
            return res;
        }
        
        queue.push(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            List<Integer> currentLayer = new ArrayList<>();
            while(!queue.isEmpty()) {
                TreeNode node = queue.remove();
                
                TreeNode firstItem = depth % 2 == 0 ? node.left : node.right;
                TreeNode secondItem = depth % 2 == 0 ? node.right : node.left;
                
                if (firstItem != null) {
                    stack.push(firstItem);
                }
                if (secondItem != null) {
                    stack.push(secondItem);
                }
                currentLayer.add(node.val);
            }
            
            while(!stack.isEmpty()) {
                queue.add(stack.pop());
            }
            
            res.add(currentLayer);
            depth++;
        }
        
        return res;
    }
}
