package com.tree.depth.first.search;

import com.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsForSum {

    public List<List<Integer>> findPaths(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findPathsRecursive(root, targetSum, new ArrayList<>(), new ArrayList<>());
        return result;
    }

    private void findPathsRecursive(TreeNode root, int remaining, List<Integer> current, List<List<Integer>> result) {
        if(root == null)
            return;
        current.add(root.val);
        if(root.left == null && root.right == null) {
            if(remaining - root.val == 0) {
                result.add(new ArrayList<>(current));
            }
            current.remove(current.size()-1);
            return;
        }
        findPathsRecursive(root.left, remaining - root.val, current, result);
        findPathsRecursive(root.right, remaining - root.val, current, result);
        current.remove(current.size()-1);
    }
}
