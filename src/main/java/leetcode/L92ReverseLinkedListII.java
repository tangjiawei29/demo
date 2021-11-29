package leetcode;

import dataStructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class L92ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        List<ListNode> list = new ArrayList();
        
        int i = 1;
        ListNode start = new ListNode(0);
        ListNode aa = start;
        aa.next = head;
        ListNode end = null;
        ListNode cur = head;
        while(cur != null) {
            if (i >= left && i <= right) {
                list.add(cur);
            } else if (i < left) {
                start.next = cur;
                start = cur;
            } else {
                end = cur;
                break;
            }
            i++;
            cur = cur.next;
        }

        for (int ii = list.size() - 1; ii >= 0; ii--) {
            start.next = list.get(ii);
            start = start.next;
        }
        if (start != null) start.next = end;
        return aa.next;
    }


    public static void main(String[] args) {
        L92ReverseLinkedListII a = new L92ReverseLinkedListII();
        ListNode root = new ListNode(1, new ListNode(8, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(root);
        System.out.println(a.reverseBetween(root, 2, 4));
    }
}
