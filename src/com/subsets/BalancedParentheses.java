package com.subsets;

import java.util.ArrayList;
import java.util.List;

public class BalancedParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisRecursive(n, 0, new StringBuilder(), result);
        return result;
    }


    public void generateParenthesisRecursive(int remainingOpenParentheses, int remainingCloseParentheses, StringBuilder currentString, List<String> result) {
        StringBuilder xxx = new StringBuilder(currentString);
        if(remainingOpenParentheses == 0 && remainingCloseParentheses == 0)
            result.add(currentString.toString());
        if(remainingOpenParentheses>0) {
            generateParenthesisRecursive(remainingOpenParentheses-1, remainingCloseParentheses+1, currentString.append('('), result);
            currentString.deleteCharAt(currentString.length()-1);
        }
        if(remainingCloseParentheses>0) {
            generateParenthesisRecursive(remainingOpenParentheses, remainingCloseParentheses-1, currentString.append(')'), result);
            currentString.deleteCharAt(currentString.length()-1);
        }
    }
}
