package com.dynamicProgramming01Knapsack;

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums)
            sum += num;
        if(sum % 2 != 0)
            return false;
        sum /= 2;
        boolean[][] dp = new boolean[sum+1][nums.length+1];
        for(int i=0; i<=nums.length; i++)
            dp[0][i] = true;
        for(int s=1; s<=sum; s++) {
            for(int i=1; i<=nums.length; i++) {
                if(nums[i-1] <= s)
                    dp[s][i] = dp[s-nums[i-1]][i-1] || dp[s][i-1];
                else
                    dp[s][i] = dp[s][i-1];
            }
        }
        return dp[sum][nums.length];
    }
}
