package leetcode;

import dataStructure.Node;

public class L426ConvertBinarySearchTreetoSortedDoublyLinkedList {
    Node head = null;
    Node tail = null;
    Node prev = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        inorder(root);
        tail.right = head;
        head.left = tail;
        return head;

    }

    private void inorder(Node root) {
        if (root == null) return;
        inorder(root.left);

        if (head == null) {
            head = root;
            prev = root;
        } else {
            prev.right = root;
            root.left = prev;
            prev = root;
        }
        tail = root;
        inorder(root.right);
    }
}
