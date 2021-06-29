package com.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
https://leetcode.com/problems/different-ways-to-add-parentheses/

Hard
 */

public class ProblemChallenge1 {

    public List<Integer> diffWaysToCompute(String expression) {
        return helper(expression, 0, expression.length()-1, new HashMap<>());
    }

    private List<Integer> helper(String expression, int start, int end, Map<Integer, Map<Integer, List<Integer>>> map) {
        if(map.containsKey(start) && map.get(start).containsKey(end)) {
            return map.get(start).get(end);
        }
        List<Integer> result = new ArrayList<>();
        boolean containsOperator = false;
        for(int i = start; i<=end; i++) {
            if(!Character.isDigit(expression.charAt(i))) {
                containsOperator = true;
                break;
            }
        }
        if(!containsOperator) {
            int num = 0;
            for(int i=start; i<=end; i++) {
                num = (num*10) + (expression.charAt(i) - '0');
            }
            result.add(num);
            Map<Integer, List<Integer>> innerMap = map.getOrDefault(start, new HashMap<>());
            innerMap.put(end, result);
            map.put(start, innerMap);
            return result;
        }
        for(int i=start; i<=end; i++) {
            if(!Character.isDigit(expression.charAt(i))) {
                char operator = expression.charAt(i);
                List<Integer> left = helper(expression, start, i-1, map);
                List<Integer> right = helper(expression, i+1, end, map);
                for(int l : left) {
                    for(int r : right) {
                        if(operator == '+')
                            result.add(l + r);
                        else if(operator == '*')
                            result.add(l * r);
                        else
                            result.add(l - r);
                    }
                }
            }
        }
        Map<Integer, List<Integer>> innerMap = map.getOrDefault(start, new HashMap<>());
        innerMap.put(end, result);
        map.put(start, innerMap);
        return result;
    }
}
