package leetcode;

import dataStructure.ListNode;

public class L86PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode smallNode = small;
        ListNode big = new ListNode(0);
        ListNode bigNode = big;
        while(head != null) {
            if (head.val < x) {
                smallNode.next = head;
                smallNode = smallNode.next;
            } else {
                bigNode.next = head;
                bigNode = bigNode.next;
            }
            head = head.next;
        }
        bigNode.next = null;
        smallNode.next = big.next;
        return small.next;
    }
}
