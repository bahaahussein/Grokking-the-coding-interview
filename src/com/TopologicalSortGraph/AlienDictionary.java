package com.TopologicalSortGraph;

import java.util.*;

public class AlienDictionary {

    public String alienDictionary(String[] words) {
        Map<Character, Set<Character>> adjList = new HashMap<>();
        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int length = Math.min(word1.length(), word2.length());
            for(int j=0; j<length; j++) {
                if(word1.charAt(j) == word2.charAt(j))
                    continue;
                adjList.computeIfAbsent(word1.charAt(j), x -> new HashSet<>()).add(word2.charAt(j));
                break;
            }
        }
        Set<Character> visited = new HashSet<>();
        Stack<Character> result = new Stack<>();
        Set<Character> inDegree = new HashSet<>();
        for(Map.Entry<Character, Set<Character>> entry : adjList.entrySet()) {
            inDegree.addAll(adjList.get(entry.getKey()));
        }
        for(Map.Entry<Character, Set<Character>> entry : adjList.entrySet()) {
            if(!inDegree.contains(entry.getKey()))
                dfs(entry.getKey(), adjList, visited, result);
        }
        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()) {
            sb.append(result.pop());
        }
        return sb.toString();
    }

    private void dfs(char vertex, Map<Character, Set<Character>> adjList, Set<Character> visited, Stack<Character> result) {
        if(visited.contains(vertex))
            return;
        visited.add(vertex);
        if(adjList.containsKey(vertex)) {
            for(char v : adjList.get(vertex)) {
                dfs(v, adjList, visited, result);
            }
        }
        result.add(vertex);
    }
}
