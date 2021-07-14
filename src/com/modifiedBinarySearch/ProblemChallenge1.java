package com.modifiedBinarySearch;

public class ProblemChallenge1 {

    public int findKey(int[] arr, int key) {
        return findKeyRec(arr, key, 0, arr.length - 1);
    }

    private int findKeyRec(int[] arr, int key, int start, int end) {
        if(start>end)
            return -1;
        int medium = start + (end-start)/2;
        if(arr[medium]==key)
            return medium;
        else if(arr[medium]<key) {
            if(isIncreasing(medium, arr)) {
                return findKeyRec(arr, key, medium + 1, end);
            } else {
                return findKeyRec(arr, key, start, medium - 1);
            }
        } else {
            int rightResult = findKeyRec(arr, key, medium + 1, end);
            if(rightResult != -1)
                return rightResult;
            return findKeyRec(arr, key, start, end - 1);
        }
    }


    private boolean isIncreasing(int index, int[] arr) {
        if(index == 0)
            return arr[index] < arr[index+1];
        return arr[index] > arr[index-1];
    }
}
