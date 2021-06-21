package com.tree.depth.first.search;

import com.TreeNode;

/*
https://leetcode.com/problems/binary-tree-maximum-path-sum/

hard
 */


public class ProblemChallenge2 {

    public int maxPathSum(TreeNode root) {
        int[] result = new int[1];
        result[0] = Integer.MIN_VALUE;
        maxPathSum(root, result);
        return result[0];
    }

    private int maxPathSum(TreeNode root, int[] result) {
        if(root == null)
            return 0;
        int left = maxPathSum(root.left, result);
        int right = maxPathSum(root.right, result);
        int temp = max(left, right, left + right, 0);
        result[0] = Math.max(result[0], temp + root.val);
        return root.val + max(left, right, 0);
    }

    private int max(int ... args) {
        int max = Integer.MIN_VALUE;
        for (int arg : args)
            max = Math.max(max, arg);
        return max;
    }
}
