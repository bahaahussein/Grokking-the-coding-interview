package com.TopKElements;

import java.util.LinkedList;
import java.util.List;

public class KClosestNumbers {

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int right = binarySearch(arr, x);
        int left = right - 1;
        LinkedList<Integer> result = new LinkedList<>();
        while(result.size() < k && left >= 0 && right < arr.length) {
            if(Math.abs(arr[left] - x) <= Math.abs(arr[right] - x)) {
                result.addFirst(arr[left]);
                left--;
            } else {
                result.addLast(arr[right]);
                right++;
            }
        }
        while(result.size() < k && left>=0) {
            result.addFirst(arr[left]);
            left--;
        }
        while(result.size() < k && right<arr.length) {
            result.addLast(arr[right]);
            right++;
        }
        return result;
    }

    private int binarySearch(int[] arr, int x) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == x)
                return mid;
            else if(arr[mid] > x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
