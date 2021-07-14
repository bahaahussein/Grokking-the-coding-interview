package com.dynamicProgramming01Knapsack;

public class ProblemChallenge1 {

    public int countSubsetSum(int[] numbers, int sum) {
        if(numbers == null || sum==0 || numbers.length == 0)
            return 0;
        return countSubsetSumRec(numbers, sum, 0);
    }

    private int countSubsetSumRec(int[] numbers, int remainingSum, int i) {
        if(remainingSum < 0)
            return 0;
        if(remainingSum == 0)
            return 1;
        if(i == numbers.length)
            return 0;
        return countSubsetSumRec(numbers, remainingSum, i+1) + countSubsetSumRec(numbers, remainingSum - numbers[i], i+1);
    }

    public int countSubsetSumDp(int[] numbers, int sum) {
        if(numbers == null || sum==0 || numbers.length == 0)
            return 0;
        int[] dp = new int[sum+1];
        dp[0] = 1;
        for(int i=1; i<=numbers.length; i++) {
            for(int s=sum; s>0; s--) {
                if(s>=numbers[i-1])
                    dp[s] += dp[s-numbers[i-1]];
            }
        }
        return dp[sum];
    }
}
