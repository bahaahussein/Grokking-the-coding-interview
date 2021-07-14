package com.dynamicProgramming01Knapsack;

public class Knapsack01 {


    public int knapsackDp(int[] weights, int[] profits, int capacity) {
        int[][] dp = new int[capacity+1][weights.length+1];
        int result = 0;
        for(int c = 1; c<=capacity; c++) {
            for(int i=1; i<=weights.length; i++) {
                if(weights[i-1] <= c)
                    dp[c][i] = profits[i-1] + dp[c - weights[i-1]][i-1];
                dp[c][i] = Math.max(dp[c][i], dp[c][i-1]);
                result = Math.max(result, dp[c][i]);
            }
        }
        return result;
    }

    public int knapsackRecursive(int[] weights, int[] profits, int capacity) {
        return knapsackRecursiveHelper(weights, profits, capacity, weights.length-1);
    }

    private int knapsackRecursiveHelper(int[] weights, int[] profits, int capacity, int i) {
        if(capacity <= 0 || i < 0)
            return 0;
        int taken = 0;
        if(weights[i] <= capacity)
            taken = profits[i] + knapsackRecursiveHelper(weights, profits, capacity - weights[i], i-1);
        int notTaken = knapsackRecursiveHelper(weights, profits, capacity, i-1);
        return Math.max(taken, notTaken);
    }


}
