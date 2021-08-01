package com.TopologicalSortGraph;

import java.util.*;

public class TopologicalSort {

    public List<Integer> topologicalSort(int verticesLength, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>(verticesLength);
        for(int v=0; v<verticesLength; v++)
            graph.add(new ArrayList<>());
        for(int[] edge : edges)
            graph.get(edge[0]).add(edge[1]);
        Stack<Integer> result = new Stack<>();
        boolean[] processed = new boolean[verticesLength];
        for(int v=0; v<verticesLength; v++) {
            if(processed[v])
                continue;
            topologicalSortRec(v, graph, processed, result);
        }
        return result;

    }

    private void topologicalSortRec(int vertex, List<List<Integer>> graph, boolean[] processed, Stack<Integer> result) {
        if(processed[vertex])
            return;
        for(int v : graph.get(vertex)) {
            topologicalSortRec(v, graph, processed, result);
        }
        processed[vertex] = true;
        result.push(vertex);
    }
}
