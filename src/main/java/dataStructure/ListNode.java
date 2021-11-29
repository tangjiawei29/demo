package dataStructure;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        ListNode ln = this;
        while(ln != null) {
            sb.append(ln.val);
            ln = ln.next;
            if(ln!=null)
                sb.append("->");
        }
        return sb.toString();
    }
}
