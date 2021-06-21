package com.tree.depth.first.search;

import com.TreeNode;

/*
https://leetcode.com/problems/diameter-of-binary-tree/

easy
 */

public class ProblemChallenge1 {

    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = new int[1];
        diameterOfBinaryTree(root, result);
        return result[0];
    }

    private int diameterOfBinaryTree(TreeNode root, int[] result) {
        if(root == null)
            return 0;
        int leftResult = diameterOfBinaryTree(root.left, result);
        int rightResult = diameterOfBinaryTree(root.right, result);
        result[0] = Math.max(result[0], leftResult + rightResult);
        return 1 + Math.max(leftResult, rightResult);
    }
}
