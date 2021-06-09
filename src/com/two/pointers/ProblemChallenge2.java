package com.two.pointers;

/*
https://leetcode.com/problems/backspace-string-compare/

easy
 */

public class ProblemChallenge2 {

    public boolean backspaceCompare(String s, String t) {
        int si = s.length();
        int ti = t.length();
        while(true) {
            si = getNextCharIndex(s, si-1);
            ti = getNextCharIndex(t, ti-1);
            if(si == -1 && ti == -1) {
                return true;
            }
            if(si == -1 || ti == -1) {
                return false;
            }
            if(s.charAt(si) != t.charAt(ti)) {
                return false;
            }
        }
    }

    private int getNextCharIndex(String s, int i) {
        int deleteCount = 0;
        while(i>=0) {
            if(s.charAt(i) == '#') {
                deleteCount++;
            } else if(deleteCount == 0) {
                return i;
            } else {
                deleteCount--;
            }
            i--;
        }
        return -1;
    }
}
