package leetcode;

import java.util.LinkedList;

public class L331VerifyPreorderSerializationofaBinaryTree {

    public static boolean isValidSerialization(String preorder) {
//        当一个节点不是叶子节点的时候，那么它必定至少有一个孩子非空！有两种情况：
//        两个孩子都非"#"（空）；
//        一个孩子为"#"（空），另一个孩子非"#"（空）；
//        把有效的叶子节点使用 "#" 代替。 比如把 4## 替换成 # 。此时，叶子节点会变成空节点！

        LinkedList<String> stack = new LinkedList<String>();
        String[] arr = preorder.split(",");
        for (String s : arr) {
            stack.push(s);
            while(stack.size() >= 3 && stack.get(0).equals("#")
                    && stack.get(1).equals("#") && !stack.get(2).equals("#")) {
                stack.pop();
                stack.pop();
                stack.pop();
                stack.push(s);
            }
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }

    public static boolean isValidSerialization2(String preorder) {
        //在树（甚至图）中，所有节点的入度之和等于出度之和
        String[] arr = preorder.split(",");
        int diff = 1;
        for (String s : arr) {
            diff--;
            if (diff < 0) return false;
            if (!s.equals("#")) diff += 2;
        }
        return diff == 0;
    }

    public static void main(String[] args) {
        System.out.println(isValidSerialization2("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
