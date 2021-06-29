package com.subsets;

import com.TreeNode;

import java.util.*;

/*
https://leetcode.com/problems/unique-binary-search-trees-ii/

hard
 */

public class ProblemChallenge2 {

    public List<TreeNode> generateTrees(int n) {
        return helper(1, n, new HashMap<>());
    }

    private List<TreeNode> helper(int start, int end, Map<Integer, Map<Integer, List<TreeNode>>> map) {
        if(start > end)
            return new ArrayList<>() {{ add(null); }};
        if(map.containsKey(start) && map.get(start).containsKey(end))
            return map.get(start).get(end);
        List<TreeNode> result = new ArrayList<>();
        for(int i=start; i<=end; i++) {
            List<TreeNode> left = helper(start, i-1, map);
            List<TreeNode> right = helper(i+1, end, map);
            for(TreeNode l : left) {
                for(TreeNode r : right) {
                    result.add(new TreeNode(i, l, r));
                }
            }
        }
        Map<Integer, List<TreeNode>> innerMap = map.getOrDefault(start, new HashMap<>());
        innerMap.put(end, result);
        map.put(start, innerMap);
        return result;
    }
}
