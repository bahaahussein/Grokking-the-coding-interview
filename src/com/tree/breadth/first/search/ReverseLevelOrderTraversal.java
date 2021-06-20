package com.tree.breadth.first.search;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/binary-tree-level-order-traversal-ii/

medium
 */

public class ReverseLevelOrderTraversal {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> resultItem = new ArrayList<Integer>();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.remove();
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
                resultItem.add(curr.val);
            }
            result.addFirst(resultItem);
        }
        return result;
    }
}
