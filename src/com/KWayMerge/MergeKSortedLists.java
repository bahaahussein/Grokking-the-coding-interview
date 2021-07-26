package com.KWayMerge;

import com.ListNode;

import java.util.PriorityQueue;

/*
https://leetcode.com/problems/merge-k-sorted-lists/

hard
 */

public class MergeKSortedLists {


    // first approach
    // Time complexity = O(kN) where k is the number of linked lists & N is the total number of nodes
    // Space complexity = O(1)
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode curr = result;
        while(true) {
            ListNode min = null;
            int minIndex = 0;
            for(int i=0; i<lists.length; i++) {
                ListNode listNode = lists[i];
                if(listNode == null)
                    continue;
                if(min == null || listNode.val < min.val) {
                    min = listNode;
                    minIndex = i;
                }
            }
            if(min == null)
                break;
            lists[minIndex] = lists[minIndex].next;
            min.next = null;
            curr.next = min;
            curr = curr.next;
        }
        return result.next;
    }

    // second approach
    // Time complexity = O(N logK)
    // Space complexity = O(K)
    public ListNode mergeKLists2(ListNode[] lists) {
        ListNode result = new ListNode();
        ListNode curr = result;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((x, y) -> x.val - y.val);
        for(ListNode listNode : lists) {
            if(listNode != null)
                pq.add(listNode);
        }
        while(!pq.isEmpty()) {
            ListNode minNode = pq.remove();
            if(minNode.next != null)
                pq.add(minNode.next);
            minNode.next = null;
            curr.next = minNode;
            curr = curr.next;
        }
        return result.next;
    }
}
