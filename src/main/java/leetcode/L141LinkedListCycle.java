package leetcode;

import dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class L141LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast!=slow) {
            if(fast == null || fast.next==null) return false;
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;

    }

    public static void main(String[] args) {


    }
}
