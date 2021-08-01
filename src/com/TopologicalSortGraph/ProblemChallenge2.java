package com.TopologicalSortGraph;

import java.util.*;

public class ProblemChallenge2 {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }
        int minHeight = Integer.MAX_VALUE;
        List<Integer> result = null;
        Map<Integer, Map<Integer, Integer>> memo = new HashMap<>();
        for(int i=0; i<n; i++) {
            int currHeight = calculateHeight(i, adjList, -1, memo);
            if(currHeight == minHeight) {
                result.add(i);
            } else if(currHeight < minHeight) {
                minHeight = currHeight;
                result = new ArrayList<>();
                result.add(i);
            }
        }
        return result;
    }

    private int calculateHeight(int i, List<List<Integer>> adjList, int parent, Map<Integer, Map<Integer, Integer>> memo) {
        if(memo.containsKey(i) && memo.get(i).containsKey(parent))
            return memo.get(i).get(parent);
        int height = 0;
        for(int x : adjList.get(i)) {
            if(parent == x)
                continue;
            height = Math.max(height, calculateHeight(x, adjList, i, memo));
        }
        height++;
        memo.computeIfAbsent(i, x -> new HashMap<>()).put(parent, height);
        return height;
    }
}
