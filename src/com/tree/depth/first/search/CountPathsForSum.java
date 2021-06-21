package com.tree.depth.first.search;

import com.TreeNode;

/*
https://leetcode.com/problems/path-sum-iii/

medium
 */

public class CountPathsForSum {

    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        return pathSum(root.left, targetSum)
                + pathSum(root.right, targetSum)
                + pathSumCalculator(root, targetSum);
    }

    private int pathSumCalculator(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        return (root.val == targetSum? 1 : 0) +
                pathSumCalculator(root.left, targetSum - root.val) +
                pathSumCalculator(root.right, targetSum - root.val);
    }
}
