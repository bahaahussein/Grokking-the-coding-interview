package com.tree.breadth.first.search;

import com.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ProblemChallenge2 {

    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> result = new ArrayList<Integer>();
        q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            int lastValue = 0;
            for(int i=0; i<size; i++) {
                TreeNode curr = q.remove();
                if(curr.left != null)
                    q.offer(curr.left);
                if(curr.right != null)
                    q.offer(curr.right);
                lastValue = curr.val;
            }
            result.add(lastValue);
        }
        return result;
    }
}
