package com.tree.depth.first.search;

import com.TreeNode;

/*
https://leetcode.com/problems/path-sum/

easy
 */

public class BinaryTreePathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null)
            return false;
        if(root.left == null && root.right == null) {
            return targetSum - root.val == 0;
        }
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
