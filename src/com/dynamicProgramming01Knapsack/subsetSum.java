package com.dynamicProgramming01Knapsack;

public class subsetSum {

    public boolean canPartition(int sum, int[] nums) {
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;
        for(int i=1; i<=nums.length; i++) {
            boolean[] temp = new boolean[sum+1];
            temp[0] = true;
            for(int s=1; s<=sum; s++) {
                int num = nums[i-1];
                if(num<=s)
                    temp[s] = dp[s] || dp[s-num];
                else
                    temp[s] = dp[s];
            }
            dp = temp;
        }
        return dp[sum];
    }
}
