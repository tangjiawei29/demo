package leetcode;

import dataStructure.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode tmp = new ListNode(0);
        ListNode ln = tmp;
        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ln.next = l1;
                l1 = l1.next;
            } else {
                ln.next = l2;
                l2 = l2.next;
            }
            ln = ln.next;
            if (l1 == null) {
                ln.next = l2;
            } else if (l2 == null) {
                ln.next = l1;
            }

        }
        return tmp.next;
    }
}
