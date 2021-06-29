package com.subsets;

import java.util.HashMap;
import java.util.Map;

public class ProblemChallenge3 {

    public int numTrees(int n) {
        int dpApproach = numTreesDp(n);
        int recursiveApproach = numTreesRecursive(n);
        if(dpApproach != recursiveApproach)
            throw new RuntimeException();
        return dpApproach;
    }

    private int numTreesDp(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=i; j++) {
                int left = dp[j-1];
                int right = dp[i-j];
                dp[i] += (left * right);
            }
        }
        return dp[n];
    }

    private int numTreesRecursive(int n) {
        return recursiveHelper(n, new HashMap<>());
    }

    private int recursiveHelper(int n, Map<Integer, Integer> map) {
        if(n<=1)
            return 1;
        if(map.containsKey(n))
            return map.get(n);
        int result = 0;
        for(int i=1; i<=n; i++) {
            int left = recursiveHelper(i-1, map);
            int right = recursiveHelper(n-i, map);
            result += (left * right);
        }
        map.put(n, result);
        return result;
    }
}
