package com.tree.depth.first.search;

import com.TreeNode;

/*
https://leetcode.com/problems/sum-root-to-leaf-numbers/

medium
 */

public class SumOfPathNumbers {

    public int sumNumbers(TreeNode root) {
        return sumNumbersRecursive(root, 0);
    }

    private int sumNumbersRecursive(TreeNode root, int currNumber) {
        if(root == null)
            return 0;
        currNumber = (currNumber * 10) + root.val;
        if(root.left == null && root.right == null) {
            return currNumber;
        }
        return sumNumbersRecursive(root.left, currNumber)
                + sumNumbersRecursive(root.right, currNumber);

    }
}
