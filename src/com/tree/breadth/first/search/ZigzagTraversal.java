package com.tree.breadth.first.search;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/

medium
 */

public class ZigzagTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<List<Integer>>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<List<Integer>> result = new LinkedList<List<Integer>>();
        q.offer(root);
        boolean isReverse = false;
        while(!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> resultItem = new LinkedList<Integer>();
            for(int i=0; i<size; i++) {
                TreeNode curr = q.remove();
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
                if(isReverse)
                    resultItem.addFirst(curr.val);
                else
                    resultItem.addLast(curr.val);
            }
            result.add(resultItem);
            isReverse = !isReverse;
        }
        return result;
    }
}
