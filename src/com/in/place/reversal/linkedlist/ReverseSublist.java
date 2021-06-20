package com.in.place.reversal.linkedlist;

import com.ListNode;


/*
https://leetcode.com/problems/reverse-linked-list-ii/

medium
 */

public class ReverseSublist {

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode x;
        ListNode curr;
        int i;
        if(left == 1) {
            curr = head;
            x = null;
            i = 1;
        } else {
            curr = head;
            i = 1;
            while(i < left - 1) {
                curr = curr.next;
                i++;
            }
            x = curr;
            i++;
            curr = curr.next;
        }
        ListNode prev = null;
        ListNode y = curr;
        while(i<=right) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }
        if(x != null) {
            x.next = prev;
        } else {
            head = prev;
        }
        y.next = curr;
        return head;
    }
}
