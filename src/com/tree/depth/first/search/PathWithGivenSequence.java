package com.tree.depth.first.search;

import com.TreeNode;

import java.util.Set;

/*
https://www.geeksforgeeks.org/check-root-leaf-path-given-sequence/

medium
 */

public class PathWithGivenSequence {

    public boolean existPath(TreeNode root, int[] sequence) {
        if(root == null && sequence.length == 0)
            return true;
        if(root == null || sequence.length == 0)
            return false;
        return existPathRecursive(root, sequence, 0);
    }

    private boolean existPathRecursive(TreeNode root, int[] sequence, int i) {
        if(root == null || i == sequence.length || root.val != sequence[i])
            return false;
        i++;
        if(i == sequence.length) {
            return root.left == null && root.right == null;
        }
        return existPathRecursive(root.left, sequence, i) || existPathRecursive(root.right, sequence, i);
    }
}
