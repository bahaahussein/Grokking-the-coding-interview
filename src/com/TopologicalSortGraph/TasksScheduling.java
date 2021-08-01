package com.TopologicalSortGraph;

import java.util.*;

class TasksScheduling {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<numCourses; i++)
            graph.add(new ArrayList<>());
        for(int[] prerequisite : prerequisites)
            graph.get(prerequisite[0]).add(prerequisite[1]);
        boolean[] isProcessed = new boolean[numCourses];
        Set<Integer> path = new HashSet<>();
        for(int i=0; i<numCourses; i++) {
            if(!isProcessed[i] && !rec(i, graph, isProcessed, path))
                return false;
        }
        return true;
    }

    private boolean rec(int course, List<List<Integer>> graph, boolean[] isProcessed, Set<Integer> path) {
        if(isProcessed[course])
            return true;
        if(path.contains(course))
            return false;
        path.add(course);
        for(int c : graph.get(course)) {
            if(!rec(c, graph, isProcessed, path))
                return false;
        }
        isProcessed[course] = true;
        path.remove(course);
        return true;
    }
}