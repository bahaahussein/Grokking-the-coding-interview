package com.dynamicProgramming01Knapsack;

public class MinimumSubsetSumDifference {

    public int findMinDp(int[] nums) {
        int arrSum = 0;
        for(int num : nums)
            arrSum +=  num;
        int arrSumm = arrSum;
        arrSum /= 2;
        boolean[] dp = new boolean[arrSum+1];
        dp[0] = true;
        for(int i=1; i<=nums.length; i++) {
            boolean[] temp = new boolean[arrSum+1];
            temp[0] = true;
            for(int s=1; s<=arrSum; s++) {
                int num = nums[i-1];
                if(num>s)
                    temp[s] = dp[s];
                else
                    temp[s] = dp[s] || dp[s-num];
            }
            dp = temp;
        }
        int s1=0;
        for(int i=dp.length-1; i>=0; i--) {
            if(dp[i]) {
                s1 = i;
                break;
            }
        }
        int s2 = arrSumm - s1;
        return s2 - s1;
    }

    public int findMinRec(int[] nums) {
        int arrSum = 0;
        for(int num : nums)
            arrSum +=  num;
        return findMinRecHelper(nums, nums.length-1, 0, arrSum);
    }


    private int findMinRecHelper(int[] nums, int i, int currSum, int arrSum) {
        if(i==0)
            return Math.abs(2*currSum-arrSum);
        return Math.min(findMinRecHelper(nums, i-1, currSum, arrSum), findMinRecHelper(nums, i-1, currSum + nums[i], arrSum));
    }
}
