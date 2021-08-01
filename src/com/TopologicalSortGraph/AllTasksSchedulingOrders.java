package com.TopologicalSortGraph;

import java.util.ArrayList;
import java.util.List;

public class AllTasksSchedulingOrders {

    public List<List<Integer>> allTasksSchedulingOrders(int v, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>(v);
        for(int i=0; i<v; i++) {
            adjList.add(new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites) {
            adjList.get(prerequisite[0]).add(prerequisite[1]);
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currResult = new ArrayList<>();
        int[] inDegree = new int[v];
        for(int[] prerequisite : prerequisites) {
            inDegree[prerequisite[1]]++;
        }
        boolean[] visited = new boolean[v];
        util(currResult, visited, inDegree, adjList, v, result);
        return result;
    }

    private void util(List<Integer> currResult, boolean[] visited, int[] inDegree, List<List<Integer>> adjList, int v, List<List<Integer>> result) {
        if(currResult.size() == v) {
            result.add(new ArrayList<>(currResult));
            return;
        }
        for(int i=0; i<v; i++) {
            if(visited[i] || inDegree[i] != 0)
                continue;
            currResult.add(i);
            visited[i] = true;
            for(int x : adjList.get(i))
                inDegree[x]--;
            util(currResult, visited, inDegree, adjList, v, result);
            visited[i] = false;
            currResult.remove(currResult.size()-1);
            for(int x : adjList.get(i))
                inDegree[x]++;
        }
    }
}
