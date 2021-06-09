package com.fast.slow.pointers;

/*
https://leetcode.com/problems/happy-number/

easy in leetcode but implementation medium
 */

public class HappyNumber {

    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = square(slow);
            fast = square(square(fast));
        } while(slow != fast);
        return slow == 1;
    }

    private int square(int n) {
        int result = 0;
        while(n>0) {
            int x = n%10;
            result += x*x;
            n /= 10;
        }
        return result;
    }
}
