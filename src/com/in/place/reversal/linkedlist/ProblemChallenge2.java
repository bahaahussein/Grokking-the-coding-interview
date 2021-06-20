package com.in.place.reversal.linkedlist;

import com.ListNode;

public class ProblemChallenge2 {

    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;
        int length = 0;
        while(curr != null) {
            length++;
            curr = curr.next;
        }
        if(length == 0)
            return null;
        int r = k%length;
        if(r==0)
            return head;
        curr = head;
        ListNode newHead = null;
        for(int i = 1; i<length-r; i++) {
            curr = curr.next;
        }
        newHead = curr.next;
        curr.next = null;
        curr = newHead;
        while(curr.next != null) {
            curr = curr.next;
        }
        curr.next = head;
        return newHead;
    }
}
