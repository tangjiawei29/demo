package leetcode;

import dataStructure.ListNode;

public class L19RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null)return head;
        ListNode runner = head,chaser = head;
        while(n>0){
            runner=runner.next;
            n--;
        }
        if(runner==null)return head.next;
        while(runner.next!=null) {
            runner = runner.next;
            chaser = chaser.next;
        }
        chaser.next  = chaser.next.next;
        return head;
    }
}
